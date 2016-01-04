package com.halo.wechat.capabilities.beans;

/**
 * 消息发送分布月数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午9:09:17
 * @version
 * @since
 */
public class UpStreamMsgDistMonthBean {

	private UpStreamMsgDistMonthData[] list;

	/**
	 * @return UpStreamMsgDistMonthData[]
	 *         同一ref_date下不同count_interval的数据，及不同ref_date的数据
	 */
	public UpStreamMsgDistMonthData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgDistMonthData[]
	 *            list 同一ref_date下不同count_interval的数据，及不同ref_date的数据
	 */
	public void setList(UpStreamMsgDistMonthData[] list) {
		this.list = list;
	}

}
