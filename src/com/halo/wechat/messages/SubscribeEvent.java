package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 关注事件，用户在关注公众号时，微信会把这个事件推送到开发者填写的URL，方便开发者给用户下发欢迎消息或者，此时eventKey和ticket内容为空。
 * 另外用户未关注时扫描二维码也会触发该事件，并且eventKey和ticket两字段会带上内容。
 * 
 * @author Junior
 * @date 2015年9月7日 下午10:11:09
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class SubscribeEvent extends Event {

	private String eventKey;

	private String ticket;

	/**
	 * @return 用户未关注时扫描带参数的二维码会触发本事件并传递该事件KEY值，如：qrscene_123123，qrscene_为前缀
	 *         ，后面为二维码的参数值
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * @param eventKey
	 *            用户未关注时扫描带参数的二维码会触发本事件并传递该事件KEY值，如：qrscene_123123
	 *            ，qrscene_为前缀，后面为二维码的参数值
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * @return 用户未关注时扫描带参数的二维码会触发本事件并传递该二维码的ticket，可用来换取二维码图片
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            用户未关注时扫描带参数的二维码会触发本事件并传递该二维码的ticket，可用来换取二维码图片
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public SubscribeEvent() {

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
	 * @param eventKey
	 *            -
	 *            用户未关注时扫描带参数的二维码会触发本事件并传递该事件KEY值，如：qrscene_123123，qrscene_为前缀，
	 *            后面为二维码的参数值
	 * @param ticket
	 *            用户未关注时扫描带参数的二维码会触发本事件并传递该二维码的ticket，可用来换取二维码图片
	 */
	public SubscribeEvent(String toUserName, String fromUserName, Timestamp createTime, String msgType, String event, String eventKey, String ticket) {
		super(toUserName, fromUserName, createTime, msgType, event);
		setEventKey(eventKey);
		setTicket(ticket);
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
	 * @param eventKey
	 *            -
	 *            用户未关注时扫描带参数的二维码会触发本事件并传递该事件KEY值，如：qrscene_123123，qrscene_为前缀，
	 *            后面为二维码的参数值
	 * @param ticket
	 *            用户未关注时扫描带参数的二维码会触发本事件并传递该二维码的ticket，可用来换取二维码图片
	 */
	public SubscribeEvent(String toUserName, String fromUserName, long createTime, String msgType, String event, String eventKey, String ticket) {
		super(toUserName, fromUserName, createTime, msgType, event);
		setEventKey(eventKey);
		setTicket(ticket);
	}

}
