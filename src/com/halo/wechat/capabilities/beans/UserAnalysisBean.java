package com.halo.wechat.capabilities.beans;

/**
 * 用户分析数据接口（包括接口列表中的所有接口）需要向相应接口调用地址POST以下数据包
 * 
 * @author Junior
 * @date 2015年12月29日 下午18:07:51
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserAnalysisBean {

	private String begin_date;

	private String end_date;

	/**
	 * @return String 获取数据的起始日期，格式“yyyy-mm-dd”。begin_date和end_date的差值需小于“最大时间跨度”
	 *         <br>
	 *         （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 */
	public String getBegin_date() {
		return begin_date;
	}

	/**
	 * @param String
	 *            begin_date
	 *            获取数据的起始日期，格式“yyyy-mm-dd”。begin_date和end_date的差值需小于“最大时间跨度”<br>
	 *            （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
	 */
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	/**
	 * @return String 获取数据的结束日期，格式“yyyy-mm-dd”。end_date允许设置的最大值为昨日
	 */
	public String getEnd_date() {
		return end_date;
	}

	/**
	 * @param String
	 *            end_date 获取数据的结束日期，格式“yyyy-mm-dd”。end_date允许设置的最大值为昨日
	 */
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

}
