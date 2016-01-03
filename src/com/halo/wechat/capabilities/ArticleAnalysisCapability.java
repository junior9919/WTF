/**
 * 
 */
package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.ArticleAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.ArticleSummaryBean;
import com.halo.wechat.capabilities.beans.ArticleTotalBean;
import com.halo.wechat.capabilities.beans.UserReadBean;
import com.halo.wechat.capabilities.beans.UserReadHourBean;
import com.halo.wechat.capabilities.beans.UserShareBean;
import com.halo.wechat.capabilities.beans.UserShareHourBean;

/**
 * 用于获得公众平台官网数据统计模块中图文分析数据的接口
 * 
 * @author zyl
 * @date 2016年1月2日 下午8:14:16
 * @version
 * @since
 */
public class ArticleAnalysisCapability extends AccessSupportCapability implements ArticleAnalysisAbility {

	private final String GET_ARTICLE_SUMMARY_URL = "https://api.weixin.qq.com/datacube/getarticlesummary";

	private final String GET_ARTICLE_TOTAL_URL = "https://api.weixin.qq.com/datacube/getarticletotal";

	private final String GET_USER_READ_URL = "https://api.weixin.qq.com/datacube/getuserread";

	private final String GET_USER_READ_HOUR_URL = "https://api.weixin.qq.com/datacube/getuserreadhour";

	private final String GET_USER_SHARE_URL = "https://api.weixin.qq.com/datacube/getusershare";

	private final String GET_USER_SHARE_HOUR_URL = "https://api.weixin.qq.com/datacube/getusersharehour";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public ArticleAnalysisCapability() throws PropertiesException {

	}

	/**
	 * 获取图文群发每日数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文群发每日数据
	 * @throws CapabilityException
	 */
	@Override
	public ArticleSummaryBean getArticleSummary(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		ArticleSummaryBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_ARTICLE_SUMMARY_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<ArticleSummaryBean>(ArticleSummaryBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get article summary failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取图文群发总数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文群发总数据
	 */
	@Override
	public ArticleTotalBean getArticleTotal(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		ArticleTotalBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_ARTICLE_TOTAL_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<ArticleTotalBean>(ArticleTotalBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get article total failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取图文统计数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文统计数据
	 */
	@Override
	public UserReadBean getUserRead(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UserReadBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_USER_READ_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UserReadBean>(UserReadBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user read failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取图文统计分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文统计分时数据
	 */
	@Override
	public UserReadHourBean getUserReadHour(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UserReadHourBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_USER_READ_HOUR_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UserReadHourBean>(UserReadHourBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user read hour failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取图文分享转发数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文分享转发数据
	 */
	@Override
	public UserShareBean getUserShare(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UserShareBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_USER_SHARE_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UserShareBean>(UserShareBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user share failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取图文分享转发分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 图文分享转发分时数据
	 */
	@Override
	public UserShareHourBean getUserShareHour(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UserShareHourBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_USER_SHARE_HOUR_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UserShareHourBean>(UserShareHourBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user share hour failed.", e);
		}
		return resultBean;
	}

}
