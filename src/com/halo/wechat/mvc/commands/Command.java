package com.halo.wechat.mvc.commands;

import com.halo.wechat.messages.Event;
import com.halo.wechat.messages.Message;

/**
 * 处理微信推送消息和事件的用户命令接口，用户定义的类实现该接口，并标注为Spring框架组件（Component），
 * Spring框架会将用户定义的类自动装配到微信开发框架中 。<br>
 * 为了使微信开发框架自动装配用户定义的Command实现类，实现类所属的包（package）名必须是以下的形式：com.*.wechat.mvc，其中星号（
 * *）可以是用户自定义的任何单词。<br>
 * 同时实现类必须加上Spring框架的Component注解，用户自定义命令接口实现类参见@see UserCommand。<br>
 * 当框架接收到微信推送的消息或事件时，将自动调用类的消息处理方法或事件处理方法，并将消息或事件对象传送给方法参数。<br>
 * 用户在微信客户端项目中只能定义并标注一个Command接口的实现类，多的实现类将引起异常，微信开发框架收到的任何消息或事件都将调用该唯一的实现类进行处理。<br>
 * 用户需要自己在实现方法中判断消息或事件的类别（通过消息类的getMsgType和事件类的getEvent）。
 * 
 * @author Junior
 * @version 1.0
 * @date 04-八月-2015 21:57:20
 * @since Wechat Framework 1.0
 * @see UserCommand
 */
public interface Command {

	/**
	 * 消息处理方法，当微信开发框架收到微信服务器推送的任何消息，都会自动调用该方法，并将消息对象传给receiveMessage参数，
	 * 用户需要在方法中自行判断消息类型，如下例：<br>
	 * <br>
	 * if (MsgType.LOCATION.equals(receiveMessage.getMsgType())) {<br>
	 * <blockquote> LocationMessage locationMsg = (LocationMessage)
	 * receiveMessage;<br>
	 * responseText = "你目前位于东经" + String.valueOf(locationMsg.getLocation_Y()) + <br>
	 * "度，北纬" + String.valueOf(locationMsg.getLocation_X()) + "度。地点：" +<br>
	 * locationMsg.getLabel();<br>
	 * </blockquote> <br>
	 * } <br>
	 * <br>
	 * 消息处理结束后，方法返回被动回复消息对象，可以是任何微信消息类型。如果返回值为null，微信开发框架会自动向微信服务器回复一个空消息。
	 * 
	 * @param receiveMessage
	 *            微信推送消息对象
	 * @return Message 被动回复消息，只能是各种类型的消息，不能回复事件。
	 */
	public Message processMessage(Message receiveMessage) throws CommandException;

	/**
	 * 事件处理方法，当微信开发框架收到微信服务器推送的任何事件，都会自动调用该方法，并将事件对象传给receiveEvent参数，
	 * 用户需要在方法中自行判断事件类型，如下例：<br>
	 * <br>
	 * if (receiveEvent instanceof ClickEvent) {<br>
	 * <blockquote> ClickEvent clickEvent = (ClickEvent) receiveEvent;<br>
	 * if ("tip".equals(clickEvent.getEventKey())) {<br>
	 * <blockquote> ...<br>
	 * </blockquote> }<br>
	 * </blockquote> }<br>
	 * <br>
	 * 消息处理结束后，方法返回被动回复消息对象，可以是任何微信消息类型。如果返回值为null，微信开发框架会自动向微信服务器回复一个空消息。
	 * 
	 * @param receiveEvent
	 *            微信平台推送的事件
	 * @return Message 被动回复消息，只能是各种类型的消息，不能回复事件。
	 */
	public Message processEvent(Event receiveEvent) throws CommandException;

}