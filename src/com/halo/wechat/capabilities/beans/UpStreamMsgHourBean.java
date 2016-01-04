/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送分时数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午8:41:00
 * @version
 * @since
 */
public class UpStreamMsgHourBean {

	private UpStreamMsgHourData[] list;

	/**
	 * @return UpStreamMsgHourData[]
	 *         同一ref_hour的不同msg_type的数据，以及不同ref_hour的数据，ref_date固定，因为最大时间跨度为1
	 */
	public UpStreamMsgHourData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgHourData[]
	 *            list
	 *            同一ref_hour的不同msg_type的数据，以及不同ref_hour的数据，ref_date固定，因为最大时间跨度为1
	 */
	public void setList(UpStreamMsgHourData[] list) {
		this.list = list;
	}

}
