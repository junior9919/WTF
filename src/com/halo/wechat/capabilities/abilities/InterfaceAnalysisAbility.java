package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryHourBean;

/**
 * 用于获得公众平台官网数据统计模块中接口分析数据的接口
 * 
 * @author zyl
 * @date 2016年1月5日 下午9:06:23
 * @version
 * @since
 */
public interface InterfaceAnalysisAbility {

	/**
	 * 获取接口分析数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 接口分析数据接口的返回数据
	 * @throws CapabilityException
	 */
	public InterfaceSummaryBean getInterfaceSummary(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取接口分析分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 接口分析分时数据
	 * @throws CapabilityException
	 */
	public InterfaceSummaryHourBean getInterfaceSummaryHour(AnalysisBean analysisBean) throws CapabilityException;

}
