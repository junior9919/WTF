package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送概况数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午8:31:44
 * @version
 * @since
 */
public class UpStreamMsgBean extends ResultBean {

	private UpStreamMsgData[] list;

	/**
	 * @return UpStreamMsgData[]
	 *         同一ref_date的不同msg_type的数据，以及不同ref_date（在时间范围内）的数据
	 */
	public UpStreamMsgData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgData[]
	 *            list 同一ref_date的不同msg_type的数据，以及不同ref_date（在时间范围内）的数据
	 */
	public void setList(UpStreamMsgData[] list) {
		this.list = list;
	}

}
