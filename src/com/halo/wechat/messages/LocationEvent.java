package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 上报地理位置事件，用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置。
 * 与LocationMessage不同
 * ，LocationMessage是用户在弹出地理位置选择器并选择地理位置后上报给开发者微信号的消息，详见开发者文档“自定义菜单创建接口”。
 * 
 * @author Junior
 * @date 2015年9月7日 下午10:38:40
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class LocationEvent extends Event {

	private float latitude;

	private float longitude;

	private float precision;

	/**
	 * @return 地理位置纬度，精确到小数点后6位
	 */
	public float getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            地理位置纬度，精确到小数点后6位
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return 地理位置经度，精确到小数点后6位
	 */
	public float getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            地理位置经度，精确到小数点后6位
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return 地理位置精度，精确到小数点后6位
	 */
	public float getPrecision() {
		return precision;
	}

	/**
	 * @param precision
	 *            地理位置精度，精确到小数点后6位
	 */
	public void setPrecision(float precision) {
		this.precision = precision;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public LocationEvent() {

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
	 * @param latitude
	 *            地理位置纬度，精确到小数点后6位
	 * @param longitude
	 *            地理位置经度，精确到小数点后6位
	 * @param precision
	 *            地理位置精度，精确到小数点后6位
	 */
	public LocationEvent(String toUserName, String fromUserName, Timestamp createTime, String msgType, String event, float latitude, float longitude,
			float precision) {
		super(toUserName, fromUserName, createTime, msgType, event);
		setLatitude(latitude);
		setLongitude(longitude);
		setPrecision(precision);
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
	 * @param latitude
	 *            地理位置纬度，精确到小数点后6位
	 * @param longitude
	 *            地理位置经度，精确到小数点后6位
	 * @param precision
	 *            地理位置精度，精确到小数点后6位
	 */
	public LocationEvent(String toUserName, String fromUserName, long createTime, String msgType, String event, float latitude, float longitude, float precision) {
		super(toUserName, fromUserName, createTime, msgType, event);
		setLatitude(latitude);
		setLongitude(longitude);
		setPrecision(precision);
	}

}
