package com.halo.wechat.messages;

import java.sql.Timestamp;

/**
 * 语音消息
 * 
 * @author Junior
 * @date 2015年8月24日 下午11:12:20
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class VoiceMessage extends Message {

	private String mediaId;

	private String format;

	/**
	 * @return 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId
	 *            语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * @return 语音格式，如amr，speex等
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            语音格式，如amr，speex等
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public VoiceMessage() {

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
	 * @param mediaId
	 *            语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 * @param format
	 *            语音格式，如amr，speex等
	 * @param msgId
	 *            消息id，64位整型
	 */
	public VoiceMessage(String toUserName, String fromUserName, Timestamp createTime, String msgType, String mediaId, String format, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setMediaId(mediaId);
		setFormat(format);
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
	 * @param mediaId
	 *            语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 * @param format
	 *            语音格式，如amr，speex等
	 * @param msgId
	 *            消息id，64位整型
	 */
	public VoiceMessage(String toUserName, String fromUserName, long createTime, String msgType, String mediaId, String format, long msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		setMediaId(mediaId);
		setFormat(format);
	}

}
