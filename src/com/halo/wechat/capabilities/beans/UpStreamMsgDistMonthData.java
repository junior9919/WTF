package com.halo.wechat.capabilities.beans;

/**
 * 消息发送分布月数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午9:08:15
 * @version
 * @since
 */
public class UpStreamMsgDistMonthData {

	private String ref_date;

	private byte count_interval;

	private int msg_user;

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
	 * @return byte 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 */
	public byte getCount_interval() {
		return count_interval;
	}

	/**
	 * @param byte
	 *            count_interval 当日发送消息量分布的区间<br>
	 *            0代表“0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 */
	public void setCount_interval(byte count_interval) {
		this.count_interval = count_interval;
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

}
