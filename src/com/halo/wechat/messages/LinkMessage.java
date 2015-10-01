package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 链接消息
 * 
 * @author Junior
 * @date 2015年8月24日 下午11:39:51
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class LinkMessage extends Message {

	private String title;

	private String description;

	private String url;

	/**
	 * @return 消息标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            消息标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return 消息描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            消息描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 消息链接
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            -消息链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public LinkMessage() {

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
	 * @param title
	 *            消息标题
	 * @param description
	 *            消息描述
	 * @param url
	 *            消息链接
	 * @param msgId
	 *            消息id，64位整型
	 */
	public LinkMessage(String toUserName, String fromUserName, Timestamp createTime, String msgType, String title, String description, String url, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setTitle(title);
		setDescription(description);
		setUrl(url);
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
	 * @param title
	 *            消息标题
	 * @param description
	 *            消息描述
	 * @param url
	 *            消息链接
	 * @param msgId
	 *            消息id，64位整型
	 */
	public LinkMessage(String toUserName, String fromUserName, long createTime, String msgType, String title, String description, String url, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setTitle(title);
		setDescription(description);
		setUrl(url);
	}

}
