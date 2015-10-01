package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 地理位置消息，本消息是用户在弹出地理位置选择器并选择地理位置后上报给开发者微信号的消息，详见开发者文档“自定义菜单创建接口”。
 * 
 * @author Junior
 * @date 2015年8月24日 下午11:30:54
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class LocationMessage extends Message {

	private float location_X;

	private float location_Y;

	private int scale;

	private String label;

	/**
	 * @return 地理位置维度，精确到小数点后6位
	 */
	public float getLocation_X() {
		return location_X;
	}

	/**
	 * @param location_X
	 *            地理位置维度，精确到小数点后6位
	 */
	public void setLocation_X(float location_X) {
		this.location_X = location_X;
	}

	/**
	 * @return 地理位置经度，精确到小数点后6位
	 */
	public float getLocation_Y() {
		return location_Y;
	}

	/**
	 * @param location_Y
	 *            地理位置经度，精确到小数点后6位
	 */
	public void setLocation_Y(float location_Y) {
		this.location_Y = location_Y;
	}

	/**
	 * @return 地图缩放大小
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * @param scale
	 *            地图缩放大小
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * @return 地理位置信息
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            地理位置信息
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public LocationMessage() {

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
	 * @param location_X
	 *            地理位置维度，精确到小数点后6位
	 * @param location_Y
	 *            地理位置经度，精确到小数点后6位
	 * @param scale
	 *            地图缩放大小
	 * @param label
	 *            地理位置信息
	 * @param msgId
	 *            消息id，64位整型
	 */
	public LocationMessage(String toUserName, String fromUserName, Timestamp createTime, String msgType, float location_X, float location_Y, int scale,
			String label, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setLocation_X(location_X);
		setLocation_Y(location_Y);
		setScale(scale);
		setLabel(label);
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
	 * @param location_X
	 *            地理位置维度，精确到小数点后6位
	 * @param location_Y
	 *            地理位置经度，精确到小数点后6位
	 * @param scale
	 *            地图缩放大小
	 * @param label
	 *            地理位置信息
	 * @param msgId
	 *            消息id，64位整型
	 */
	public LocationMessage(String toUserName, String fromUserName, long createTime, String msgType, float location_X, float location_Y, int scale,
			String label, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setLocation_X(location_X);
		setLocation_Y(location_Y);
		setScale(scale);
		setLabel(label);
	}

}
