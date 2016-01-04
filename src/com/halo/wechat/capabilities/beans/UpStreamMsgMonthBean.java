/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送月数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午8:53:32
 * @version
 * @since
 */
public class UpStreamMsgMonthBean {

	private UpStreamMsgMonthData[] list;

	/**
	 * @return UpStreamMsgMonthData[] 同一ref_date下不同msg_type的数据，及不同ref_date的数据
	 */
	public UpStreamMsgMonthData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgMonthData[]
	 *            list 同一ref_date下不同msg_type的数据，及不同ref_date的数据
	 */
	public void setList(UpStreamMsgMonthData[] list) {
		this.list = list;
	}

}
