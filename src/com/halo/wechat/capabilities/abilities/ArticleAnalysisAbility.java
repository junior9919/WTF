package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.ArticleSummaryBean;
import com.halo.wechat.capabilities.beans.ArticleTotalBean;
import com.halo.wechat.capabilities.beans.UserReadBean;
import com.halo.wechat.capabilities.beans.UserReadHourBean;
import com.halo.wechat.capabilities.beans.UserShareBean;
import com.halo.wechat.capabilities.beans.UserShareHourBean;

public interface ArticleAnalysisAbility {

	/**
	 * 获取图文群发每日数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文群发每日数据
	 */
	public ArticleSummaryBean getArticleSummary(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取图文群发总数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文群发总数据
	 */
	public ArticleTotalBean getArticleTotal(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取图文统计数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文统计数据
	 */
	public UserReadBean getUserRead(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取图文统计分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文统计分时数据
	 */
	public UserReadHourBean getUserReadHour(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取图文分享转发数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文分享转发数据
	 */
	public UserShareBean getUserShare(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取图文分享转发分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文分享转发分时数据
	 */
	public UserShareHourBean getUserShareHour(AnalysisBean analysisBean) throws CapabilityException;

}
