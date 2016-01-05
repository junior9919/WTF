package com.halo.wechat.capabilities.beans;

/**
 * 接口分析分时数据
 * 
 * @author zyl
 * @date 2016年1月5日 下午9:01:52
 * @version
 * @since
 */
public class InterfaceSummaryHourData {

	private String ref_date;

	private String ref_hour;

	private int callback_count;

	private int fail_count;

	private int total_time_cost;

	private int max_time_cost;

	/**
	 * @return String 数据的日期
	 */
	public String getRef_date() {
		return ref_date;
	}

	/**
	 * @param String
	 *            ref_date 数据的日期
	 */
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	/**
	 * @return String 数据的小时
	 */
	public String getRef_hour() {
		return ref_hour;
	}

	/**
	 * @param String
	 *            ref_hour 数据的小时
	 */
	public void setRef_hour(String ref_hour) {
		this.ref_hour = ref_hour;
	}

	/**
	 * @return int 通过服务器配置地址获得消息后，被动回复用户消息的次数
	 */
	public int getCallback_count() {
		return callback_count;
	}

	/**
	 * @param int
	 *            callback_count 通过服务器配置地址获得消息后，被动回复用户消息的次数
	 */
	public void setCallback_count(int callback_count) {
		this.callback_count = callback_count;
	}

	/**
	 * @return int 上述动作的失败次数
	 */
	public int getFail_count() {
		return fail_count;
	}

	/**
	 * @param int
	 *            fail_count 上述动作的失败次数
	 */
	public void setFail_count(int fail_count) {
		this.fail_count = fail_count;
	}

	/**
	 * @return int 总耗时，除以callback_count即为平均耗时
	 */
	public int getTotal_time_cost() {
		return total_time_cost;
	}

	/**
	 * @param int
	 *            total_time_cost 总耗时，除以callback_count即为平均耗时
	 */
	public void setTotal_time_cost(int total_time_cost) {
		this.total_time_cost = total_time_cost;
	}

	/**
	 * @return int 最大耗时
	 */
	public int getMax_time_cost() {
		return max_time_cost;
	}

	/**
	 * @param int
	 *            max_time_cost 最大耗时
	 */
	public void setMax_time_cost(int max_time_cost) {
		this.max_time_cost = max_time_cost;
	}

}
