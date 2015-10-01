package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 微信推送和被动回复消息的基类，由于类中定义了msgId成员，因此仅各种消息能继承本类，所有事件均不从本类继承。开发者一般不需要实例化本类的对象，
 * 仅为更具体的消息类所继承。
 * 
 * @date 2015年7月30日 下午11:28:35
 * @author Junior
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public abstract class Message extends BaseMessage {

	private long msgId;

	/**
	 * @return 消息id，64位整型
	 */
	public long getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId
	 *            消息id，64位整型
	 */
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	/**
	 * 无参构造方法
	 */
	public Message() {

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
	 * @param msgId
	 *            消息id，64位整型
	 */
	public Message(String toUserName, String fromUserName, Timestamp createTime, String msgType, long msgId) {
		super(toUserName, fromUserName, createTime, msgType);
		setMsgId(msgId);
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
	 * @param msgId
	 *            消息id，64位整型
	 */
	public Message(String toUserName, String fromUserName, long createTime, String msgType, long msgId) {
		super(toUserName, fromUserName, createTime, msgType);
		setMsgId(msgId);
	}

}
