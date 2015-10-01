package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 图片消息
 * 
 * @author Junior
 * @date 2015年8月24日 下午10:25:54
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class ImageMessage extends Message {

	private String picUrl;

	private String mediaId;

	/**
	 * @return 图片链接
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * @param picUrl
	 *            图片链接
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
	 * @return 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId
	 *            图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public ImageMessage() {

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
	 * @param picUrl
	 *            图片链接
	 * @param mediaId
	 *            图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 * @param msgId
	 *            消息id，64位整型
	 */
	public ImageMessage(String toUserName, String fromUserName, Timestamp createTime, String msgType, String picUrl, String mediaId, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setPicUrl(picUrl);
		setMediaId(mediaId);
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
	 * @param picUrl
	 *            图片链接
	 * @param mediaId
	 *            图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 * @param msgId
	 *            消息id，64位整型
	 */
	public ImageMessage(String toUserName, String fromUserName, long createTime, String msgType, String picUrl, String mediaId, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setPicUrl(picUrl);
		setMediaId(mediaId);
	}

}
