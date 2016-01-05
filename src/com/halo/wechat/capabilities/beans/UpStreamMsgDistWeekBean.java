package com.halo.wechat.capabilities.beans;

/**
 * 消息发送分布周数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午9:06:18
 * @version
 * @since
 */
public class UpStreamMsgDistWeekBean extends ResultBean {

	private UpStreamMsgDistWeekData[] list;

	/**
	 * @return UpStreamMsgDistWeekData[]
	 *         同一ref_date下不同count_interval的数据，及不同ref_date的数据
	 */
	public UpStreamMsgDistWeekData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgDistWeekData[]
	 *            list 同一ref_date下不同count_interval的数据，及不同ref_date的数据
	 */
	public void setList(UpStreamMsgDistWeekData[] list) {
		this.list = list;
	}

}
