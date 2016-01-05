package com.halo.wechat.capabilities.beans;

/**
 * 获取消息发送分布数据
 * 
 * @author zyl
 * @date 2016年1月4日 下午9:02:19
 * @version
 * @since
 */
public class UpStreamMsgDistBean extends ResultBean {

	private UpStreamMsgDistData[] list;

	/**
	 * @return UpStreamMsgDistData[]
	 *         同一ref_date下不同count_interval的数据，及不同ref_date的数据
	 */
	public UpStreamMsgDistData[] getList() {
		return list;
	}

	/**
	 * @param UpStreamMsgDistData[]
	 *            list 同一ref_date下不同count_interval的数据，及不同ref_date的数据
	 */
	public void setList(UpStreamMsgDistData[] list) {
		this.list = list;
	}

}
