/**
 * 
 */
package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.UserAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.UserCumulateBean;
import com.halo.wechat.capabilities.beans.UserSummaryBean;

/**
 * 用于获得公众平台官网数据统计模块中用户分析数据的接口
 * 
 * @author zyl
 * @date 2015年12月29日 下午9:42:52
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserAnalysisCapability extends AccessSupportCapability implements UserAnalysisAbility {

	private final String GET_USER_SUMMARY_URL = "https://api.weixin.qq.com/datacube/getusersummary";

	private final String GET_USER_CUMULATE_URL = "https://api.weixin.qq.com/datacube/getusercumulate";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public UserAnalysisCapability() throws PropertiesException {

	}

	/**
	 * 获取用户增减数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 获取用户增减数据接口的返回JSON数据包
	 * @throws CapabilityException
	 */
	@Override
	public UserSummaryBean getUserSummary(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}

		String jsonStr = getJsonStr(new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean);
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().post(GET_USER_SUMMARY_URL, args, jsonStr, JSON_CONTENT_TYPE);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user summary failed.", e);
		}
		return getJsonBean(new JSONUtils<UserSummaryBean>(UserSummaryBean.class), resultStr);
	}

	/**
	 * 获取累计用户数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 获取用户增减数据接口的返回JSON数据包
	 * @throws CapabilityException
	 */
	@Override
	public UserCumulateBean getUserCumulate(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}

		String jsonStr = getJsonStr(new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean);
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().post(GET_USER_CUMULATE_URL, args, jsonStr, JSON_CONTENT_TYPE);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user summary failed.", e);
		}

		return getJsonBean(new JSONUtils<UserCumulateBean>(UserCumulateBean.class), resultStr);
	}

}
