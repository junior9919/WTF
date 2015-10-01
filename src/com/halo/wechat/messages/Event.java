package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 微信推送事件的基类，其中定义了各种事件类型的常量。并定义event成员（通过get和set方法读写）以确定具体的事件类型。
 * 
 * @author Junior
 * @date 2015年9月7日 下午9:40:57
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class Event extends BaseMessage {

	private String event;

	/**
	 * 订阅
	 */
	public static final String SUBSCRIBE_EVENT = "subscribe";

	/**
	 * 取消订阅
	 */
	public static final String UNSUBSCRIBE_EVENT = "unsubscribe";

	/**
	 * 扫描带参数二维码事件（用户已关注时）
	 */
	public static final String SCAN_EVENT = "SCAN";

	/**
	 * 上报地理位置事件
	 */
	public static final String LOCATION_EVENT = "LOCATION";

	/**
	 * 点击菜单拉取消息事件
	 */
	public static final String CLICK_EVENT = "CLICK";

	/**
	 * 点击菜单跳转链接事件
	 */
	public static final String VIEW_EVENT = "VIEW";

	/**
	 * @return 事件类型，详见微信公众平台开发者文档
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            事件类型，详见微信公众平台开发者文档
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * 无参构造方法
	 */
	public Event() {

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
	public Event(String toUserName, String fromUserName, Timestamp createTime, String msgType, String event) {
		super(toUserName, fromUserName, createTime, msgType);
		setEvent(event);
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
	public Event(String toUserName, String fromUserName, long createTime, String msgType, String event) {
		super(toUserName, fromUserName, createTime, msgType);
		setEvent(event);
	}

}
