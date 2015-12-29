package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.UserAnalysisBean;
import com.halo.wechat.capabilities.beans.UserCumulateBean;
import com.halo.wechat.capabilities.beans.UserSummaryBean;

public interface UserAnalysisAbility {

	/**
	 * 获取用户增减数据
	 * 
	 * @param userAnalysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 获取用户增减数据接口的返回JSON数据包
	 * @throws CapabilityException
	 */
	public UserSummaryBean getUserSummary(UserAnalysisBean userAnalysisBean) throws CapabilityException;

	/**
	 * 获取累计用户数据
	 * 
	 * @param userAnalysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 获取用户增减数据接口的返回JSON数据包
	 * @throws CapabilityException
	 */
	public UserCumulateBean getUserCumulate(UserAnalysisBean userAnalysisBean) throws CapabilityException;

}