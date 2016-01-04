package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistMonthBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistWeekBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgHourBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgMonthBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgWeekBean;

/**
 * 用于获得公众平台官网数据统计模块中消息分析数据的接口
 * 
 * @author zyl
 * @date 2016年1月4日 下午9:13:43
 * @version
 * @since
 */
public interface UpStreamMsgAnalysisAbility {

	/**
	 * 获取消息发送概况数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgBean getUpStreamMsg(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取消息分送分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgHourBean getUpStreamMsgHour(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取消息发送周数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgWeekBean getUpStreamMsgWeek(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取消息发送月数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgMonthBean getUpStreamMsgMonth(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取消息发送分布数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgDistBean getUpStreamMsgDist(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取消息发送分布周数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgDistWeekBean getUpStreamMsgDistWeek(AnalysisBean analysisBean) throws CapabilityException;

	/**
	 * 获取消息发送分布月数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	public UpStreamMsgDistMonthBean getUpStreamMsgDistMonth(AnalysisBean analysisBean) throws CapabilityException;

}
