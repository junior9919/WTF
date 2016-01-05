package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.InterfaceAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryHourBean;

/**
 * 用于获得公众平台官网数据统计模块中接口分析数据的接口
 * 
 * @author zyl
 * @date 2016年1月5日 下午9:11:30
 * @version
 * @since
 */
public class InterfaceAnalysisCapability extends AccessSupportCapability implements InterfaceAnalysisAbility {

	private final String GET_INTERFACE_SUMMARY_URL = "https://api.weixin.qq.com/datacube/getinterfacesummary";

	private final String GET_INTERFACE_SUMMARY_HOUR_URL = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public InterfaceAnalysisCapability() throws PropertiesException {

	}

	/**
	 * 获取接口分析数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 接口分析数据接口的返回数据
	 * @throws CapabilityException
	 */
	@Override
	public InterfaceSummaryBean getInterfaceSummary(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		InterfaceSummaryBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_INTERFACE_SUMMARY_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<InterfaceSummaryBean>(InterfaceSummaryBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get interface summary failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取接口分析分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 接口分析分时数据
	 * @throws CapabilityException
	 */
	@Override
	public InterfaceSummaryHourBean getInterfaceSummaryHour(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		InterfaceSummaryHourBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_INTERFACE_SUMMARY_HOUR_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<InterfaceSummaryHourBean>(InterfaceSummaryHourBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get interface summary hour failed.", e);
		}
		return resultBean;
	}

}
