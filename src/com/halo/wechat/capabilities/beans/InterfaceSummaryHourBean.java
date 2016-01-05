/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 接口分析分时数据
 * @author zyl
 * @date 2016年1月5日 下午9:04:10
 * @version
 * @since
 */
public class InterfaceSummaryHourBean extends ResultBean {

	private InterfaceSummaryHourData[] list;

	/**
	 * @return InterfaceSummaryHourData[] 不同ref_hour的数据
	 */
	public InterfaceSummaryHourData[] getList() {
		return list;
	}

	/**
	 * @param InterfaceSummaryHourData[]
	 *            list 不同ref_hour的数据
	 */
	public void setList(InterfaceSummaryHourData[] list) {
		this.list = list;
	}

}
