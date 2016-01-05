package com.halo.wechat.capabilities.beans;

/**
 * 接口分析数据接口的返回数据
 * 
 * @author zyl
 * @date 2016年1月5日 下午8:56:23
 * @version
 * @since
 */
public class InterfaceSummaryBean extends ResultBean {

	private InterfaceSummaryData[] list;

	/**
	 * @return InterfaceSummaryData[] 不同ref_date（在begin_date和end_date之间）的数据
	 */
	public InterfaceSummaryData[] getList() {
		return list;
	}

	/**
	 * @param InterfaceSummaryData[]
	 *            list 不同ref_date（在begin_date和end_date之间）的数据
	 */
	public void setList(InterfaceSummaryData[] list) {
		this.list = list;
	}

}
