package com.halo.wechat.capabilities.abilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.mvc.commands.Command;

public interface MessageAbility {

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
	 *      VoiceMessage
	 */
	public MsgType receiveMessage(HttpServletRequest request) throws CapabilityException;

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
	 */
	public Message executeCommand(Command command, MsgType message) throws CapabilityException;

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
	public void responseMessage(HttpServletResponse response, Message message) throws CapabilityException;

}
