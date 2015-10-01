package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 继承MsgType的微信推送和被动回复消息、事件基类，本类中定义了所有消息和事件都包含的信息，例如开发者微信号、发送方帐号等。
 * 开发者一般不需要实例化本类的对象，本类仅为更具体的消息和事件类所继承。
 * 
 * @date 2015年7月29日 下午7:34:40
 * @author Junior
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class BaseMessage extends MsgType {

	private String toUserName;

	private String fromUserName;

	private Timestamp createTime;

	/**
	 * @return 接收消息时为开发者微信号，被动回复消息时为接收方帐号（收到的OpenID）
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * @param toUserName
	 *            接收消息时为开发者微信号，被动回复消息时为接收方帐号（收到的OpenID）
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * @return 接收消息时为发送方帐号（一个OpenID），被动回复消息时为开发者微信号
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * @param fromUserName
	 *            接收消息时为发送方帐号（一个OpenID），被动回复消息时为开发者微信号
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * @return 消息创建时间，Timestamp类型。即时间戳，1970年1月1日00:00:00到现在的毫秒数。可以用以下方式获取当前时间：<br>
	 *         new Timestamp(System.currentTimeMillis());
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            消息创建时间，Timestamp类型。即时间戳，1970年1月1日00:00:00
	 *            到现在的毫秒数。可以用以下方式获取当前时间：<br>
	 *            new Timestamp(System.currentTimeMillis());
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 无参构造方法
	 */
	public BaseMessage() {

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
	 */
	public BaseMessage(String toUserName, String fromUserName, Timestamp createTime, String msgType) {
		setToUserName(toUserName);
		setFromUserName(fromUserName);
		setCreateTime(createTime);
		setMsgType(msgType);
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
	 */
	public BaseMessage(String toUserName, String fromUserName, long createTime, String msgType) {
		setToUserName(toUserName);
		setFromUserName(fromUserName);
		Timestamp temp = new Timestamp(createTime);
		setCreateTime(temp);
		setMsgType(msgType);
	}

}
