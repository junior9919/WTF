package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送概况数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午8:22:46
 * @version
 * @since
 */
public class UpStreamMsgData {

	private String ref_date;

	private byte msg_type;

	private int msg_user;

	private int msg_count;

	/**
	 * @return String 数据的日期，需在begin_date和end_date之间
	 */
	public String getRef_date() {
		return ref_date;
	}

	/**
	 * @param String
	 *            ref_date 数据的日期，需在begin_date和end_date之间
	 */
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	/**
	 * @return byte 消息类型，代表含义如下：<br>
	 *         1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 */
	public byte getMsg_type() {
		return msg_type;
	}

	/**
	 * @param byte
	 *            msg_type 消息类型，代表含义如下：<br>
	 *            1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
	 */
	public void setMsg_type(byte msg_type) {
		this.msg_type = msg_type;
	}

	/**
	 * @return int 上行发送了（向公众号发送了）消息的用户数
	 */
	public int getMsg_user() {
		return msg_user;
	}

	/**
	 * @param int
	 *            msg_user 上行发送了（向公众号发送了）消息的用户数
	 */
	public void setMsg_user(int msg_user) {
		this.msg_user = msg_user;
	}

	/**
	 * @return int 上行发送了消息的消息总数
	 */
	public int getMsg_count() {
		return msg_count;
	}

	/**
	 * @param int
	 *            msg_count 上行发送了消息的消息总数
	 */
	public void setMsg_count(int msg_count) {
		this.msg_count = msg_count;
	}

}
