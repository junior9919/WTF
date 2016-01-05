/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送周数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午8:49:38
 * @version
 * @since
 */
public class UpStreamMsgWeekBean extends ResultBean {

	private UpStreamMsgWeekData[] list;

	/**
	 * @return UpStreamMsgWeekData[] 同一ref_date下不同msg_type的数据，及不同ref_date的数据
	 */
	public UpStreamMsgWeekData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgWeekData[]
	 *            list 同一ref_date下不同msg_type的数据，及不同ref_date的数据
	 */
	public void setList(UpStreamMsgWeekData[] list) {
		this.list = list;
	}

}
