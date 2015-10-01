package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 取消关注事件
 * 
 * @author Junior
 * @date 2015年9月7日 下午10:27:23
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UnsubscribeEvent extends Event {

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public UnsubscribeEvent() {

	}

	/**
	 * 构造方法
	 * 
	 * @param toUserName
	 *            接收消息时为开发者微信号，被动回复消息时为接收方帐号（收到的OpenID）
	 * @param fromUserName
	 *            接收消息时为发送方帐号（一个OpenID），被动回复消息时为开发者微信号
	 * @param createTime
	 *            消息创建时间，Timestamp类型。即时间戳，1970年1月1日00:00:00
	 *            到现在的毫秒数。可以用以下方式获取当前时间：<br>
	 *            new Timestamp(System.currentTimeMillis());
	 * @param msgType
	 *            消息类型
	 * @param event
	 *            事件类型，详见微信公众平台开发者文档
	 */
	public UnsubscribeEvent(String toUserName, String fromUserName, Timestamp createTime, String msgType, String event) {
		super(toUserName, fromUserName, createTime, msgType, event);
	}

	/**
	 * 构造方法
	 * 
	 * @param toUserName
	 *            接收消息时为开发者微信号，被动回复消息时为接收方帐号（收到的OpenID）
	 * @param fromUserName
	 *            接收消息时为发送方帐号（一个OpenID），被动回复消息时为开发者微信号
	 * @param createTime
	 *            消息创建时间，长整型（long），1970年1月1日00:00:00到现在的毫秒数。可以用以下方式获取当前时间：<br>
	 *            System.currentTimeMillis();
	 * @param msgType
	 *            消息类型
	 * @param event
	 *            事件类型，详见微信公众平台开发者文档
	 */
	public UnsubscribeEvent(String toUserName, String fromUserName, long createTime, String msgType, String event) {
		super(toUserName, fromUserName, createTime, msgType, event);
	}

}
