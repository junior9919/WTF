/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送分时数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午8:35:45
 * @version
 * @since
 */
public class UpStreamMsgHourData {

	private String ref_date;

	private String ref_hour;

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
	 * @return String
	 *         数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	public String getRef_hour() {
		return ref_hour;
	}

	/**
	 * @param String
	 *            ref_hour
	 *            数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	public void setRef_hour(String ref_hour) {
		this.ref_hour = ref_hour;
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
