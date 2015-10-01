package com.halo.wechat.capabilities;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.http.utils.HttpUtils;
import com.halo.http.utils.HttpUtilsException;
import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.abilities.MessageAbility;
import com.halo.wechat.messages.Event;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.mvc.commands.Command;
import com.halo.wechat.mvc.commands.CommandException;
import com.halo.wechat.saos.SaoException;
import com.halo.wechat.saos.XmlSao;

/**
 * 接收消息能力接口，微信开发框架用本类来处理微信公众平台推送的消息和事件，并调用用户定义的Command接口实现类，然后将用户回复的消息转换成XML字符串，
 * 回复给微信公众平台。<br>
 * 用户也可以在自己的项目中实例化本类，并调用本类的方法来处理微信公众平台推送消息和事件，前提是用户项目需要Spring框架的支持，并且是web应用。
 * 
 * @author Junior
 * @date 2015年9月10日 下午10:34:46
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class MessageCapability extends AbstractCapability implements MessageAbility {

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public MessageCapability() throws CapabilityException {

	}

	/**
	 * 从HttpServletRequest对象中取得微信公众平台推送的消息或事件，并将xml格式的消息（或事件）转换成MsgType及其子类型的对象。
	 * 
	 * @param request
	 *            微信公众平台的post请求
	 * @return 从xml格式的消息（或事件）转换成的MsgType类型的对象，其实际对象类型可通过getMsgType方法获得。
	 * @throws CapabilityException
	 *             读取request中的实体信息错误，基于Spring框架的applicationContext_wechat.
	 *             xml文件内容损坏，解析xml错误，都会引发该异常
	 * @see MsgType, BaseMessage, Message, TextMessage, ImageMessage,
	 *      LinkMessage, LocationMessage, VideoMessage, ShortVideoMessage,
	 *      VoiceMessage, Event, ClickEvent, LocationEvent, ScanEvent,
	 *      SubscribeEvent, UnsubscribeEvent, ViewEvent
	 */
	@Override
	public MsgType receiveMessage(HttpServletRequest request) throws CapabilityException {
		String receiveXml = "";
		try {
			receiveXml = HttpUtils.readEntityFromStream(request);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Read http entity error.");
		}
		if (receiveXml.isEmpty()) {
			receiveXml = request.getParameter("msg");
		}

		XmlSao msgTypeSao = (XmlSao) SpringUtils.getBean("msgTypeSao");
		if (null == msgTypeSao) {
			throw new CapabilityException("Get bean msgTypeSao failed, applicationContext-wechat.xml may be damaged.");
		}

		MsgType msgType = null;
		try {
			msgType = msgTypeSao.get(receiveXml);
		} catch (SaoException e) {
			throw new CapabilityException("An error occured when get message type from xml.");
		}

		XmlSao sao = (XmlSao) SpringUtils.getBean(msgType.getMsgType());
		if (null == sao) {
			throw new CapabilityException("Get bean " + msgType.getMsgType() + " failed, please make sure bean has defined in applicationContext-wechat.xml");
		}
		MsgType message = null;
		try {
			message = sao.get(receiveXml);
		} catch (SaoException e) {
			// TODO throw new ServiceException
			throw new CapabilityException("An error occured when get message from xml.");
		}

		if (msgType.getMsgType().equals(MsgType.EVENT)) {
			Event event = (Event) message;
			String beanId = event.getEvent().toLowerCase() + "_event";
			XmlSao eventSao = (XmlSao) SpringUtils.getBean(beanId);

			if (null == eventSao) {
				throw new CapabilityException("Get bean " + beanId + " failed, please make sure bean has defined in applicationContext-wechat.xml");
			}

			try {
				return eventSao.get(receiveXml);
			} catch (SaoException e) {
				// TODO throw new ServiceException
				throw new CapabilityException("An error occured when get message from xml.");
			}
		} else {
			return message;
		}
	}

	/**
	 * 执行用户自定义的Command接口实现类。
	 * 
	 * @param command
	 *            用户自定义的Command接口实现类。
	 * @param message
	 *            微信公众平台推送的消息或事件。
	 * @return 用户处理结束后的回复消息。
	 * @throws CapabilityException
	 *             如果用户未定义Command接口实现类，command参数为null，抛出该异常。
	 * @see MsgType, BaseMessage, Message, TextMessage, ImageMessage,
	 *      LinkMessage, LocationMessage, VideoMessage, ShortVideoMessage,
	 *      VoiceMessage, Event, ClickEvent, LocationEvent, ScanEvent,
	 *      SubscribeEvent, UnsubscribeEvent, ViewEvent
	 */
	@Override
	public Message executeCommand(Command command, MsgType message) throws CapabilityException {
		if (null == command) {
			throw new CapabilityException("command object is null.");
		}

		Message respMsg = null;
		if (message.getMsgType().equals(MsgType.EVENT)) {
			try {
				respMsg = command.processEvent((Event) message);
			} catch (CommandException e) {
				throw new CapabilityException("User command raise an exception.");
			}
		} else {
			try {
				respMsg = command.processMessage((Message) message);
			} catch (CommandException e) {
				throw new CapabilityException("User command raise an exception.");
			}
		}
		return respMsg;
	}

	/**
	 * 将用户的回复消息回复给微信公众平台。
	 * 
	 * @param response
	 *            HttpServletResponse对象，通过该对象回复消息。
	 * @param message
	 *            用户的回复消息。
	 * @throws CapabilityException
	 *             基于Spring框架的applicationContext_wechat.
	 *             xml文件内容损坏，解析xml错误，回复消息错误，都会引发该异常
	 * @see MsgType, BaseMessage, Message, TextMessage, ImageMessage,
	 *      LinkMessage, LocationMessage, VideoMessage, ShortVideoMessage,
	 *      VoiceMessage
	 */
	@Override
	public void responseMessage(HttpServletResponse response, Message message) throws CapabilityException {
		String responseXml = "success";
		if (null != message) {
			try {
				XmlSao sao = (XmlSao) SpringUtils.getBean(message.getMsgType());
				if (null == sao) {
					throw new CapabilityException("Get bean " + message.getMsgType()
							+ " failed, please make sure bean defined in applicationContext-wechat.xml");
				}
				responseXml = sao.save(message);
			} catch (SaoException e) {
				throw new CapabilityException("An error occured when save message to xml.");
			}
		}

		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(responseXml);
		} catch (IOException e) {
			// TODO
			throw new CapabilityException("Write response message error.");
		}
	}

}
