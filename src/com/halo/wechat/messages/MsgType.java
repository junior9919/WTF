package com.halo.wechat.messages;

/**
 * 所有微信推送消息和事件的基类，其中定义了一组消息类型常量，并且只有一个成员msgType（通过get和set方法读写）。
 * 当客户端收到一个不确定类型的消息或事件时，可以通过msgType判断消息类型，再将对象强制转换为相应的消息或事件类型。
 * 
 * @date 2015年7月29日 下午8:05:01
 * @author Junior
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class MsgType {

	private String msgType;

	/**
	 * 文本消息
	 */
	public static final String TEXT = "text";

	/**
	 * 图片消息
	 */
	public static final String IMAGE = "image";

	/**
	 * 语音消息
	 */
	public static final String VOICE = "voice";

	/**
	 * 视频消息
	 */
	public static final String VIDEO = "video";

	/**
	 * 小视频消息
	 */
	public static final String SHORTVIDEO = "shortvideo";

	/**
	 * 地理位置消息
	 */
	public static final String LOCATION = "location";

	/**
	 * 链接消息
	 */
	public static final String LINK = "link";

	/**
	 * 图文消息
	 */
	public static final String NEWS = "news";

	/**
	 * 事件
	 */
	public static final String EVENT = "event";

	/**
	 * @return 消息类型，详见微信公众平台开发者文档。
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType
	 *            消息类型，详见微信公众平台开发者文档。
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
