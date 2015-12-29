package com.halo.wechat.capabilities.beans;

/**
 * 获取累计用户数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2015年12月29日 下午9:27:09
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserCumulateData {

	private String ref_date;

	private int cumulate_user;

	/**
	 * @return String 数据的日期，格式“yyyy-mm-dd”
	 */
	public String getRef_date() {
		return ref_date;
	}

	/**
	 * @param String
	 *            ref_date 数据的日期，格式“yyyy-mm-dd”
	 */
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	/**
	 * @return int 总用户量
	 */
	public int getCumulate_user() {
		return cumulate_user;
	}

	/**
	 * @param int
	 *            cumulate_user 总用户量
	 */
	public void setCumulate_user(int cumulate_user) {
		this.cumulate_user = cumulate_user;
	}

}
