package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.UpStreamMsgAnalysisAbility;
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
 * @date 2016年1月4日 下午9:25:57
 * @version
 * @since
 */
public class UpStreamMsgAnalysisCapability extends AccessSupportCapability implements UpStreamMsgAnalysisAbility {

	private final String GET_UP_STREAM_MSG_URL = "https://api.weixin.qq.com/datacube/getupstreammsg";

	private final String GET_UP_STREAM_MSG_HOUR_URL = "https://api.weixin.qq.com/datacube/getupstreammsghour";

	private final String GET_UP_STREAM_MSG_WEEK_URL = "https://api.weixin.qq.com/datacube/getupstreammsgweek";

	private final String GET_UP_STREAM_MSG_MONTH_URL = "https://api.weixin.qq.com/datacube/getupstreammsgmonth";

	private final String GET_UP_STREAM_MSG_DIST_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdist";

	private final String GET_UP_STREAM_MSG_DIST_WEEK_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek";

	private final String GET_UP_STREAM_MSG_DIST_MONTH_URL = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public UpStreamMsgAnalysisCapability() throws PropertiesException {

	}

	/**
	 * 获取消息分送分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgBean getUpStreamMsg(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgBean>(UpStreamMsgBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取消息分送分时数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgHourBean getUpStreamMsgHour(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgHourBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_HOUR_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgHourBean>(UpStreamMsgHourBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message hour failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取消息发送周数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgWeekBean getUpStreamMsgWeek(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgWeekBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_WEEK_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgWeekBean>(UpStreamMsgWeekBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message week failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取消息发送月数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgMonthBean getUpStreamMsgMonth(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgMonthBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_MONTH_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgMonthBean>(UpStreamMsgMonthBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message month failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取消息发送分布数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgDistBean getUpStreamMsgDist(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgDistBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_DIST_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgDistBean>(UpStreamMsgDistBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message distribution failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取消息发送分布周数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgDistWeekBean getUpStreamMsgDistWeek(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgDistWeekBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_DIST_WEEK_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgDistWeekBean>(UpStreamMsgDistWeekBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message distribution week failed.", e);
		}
		return resultBean;
	}

	/**
	 * 获取消息发送分布月数据
	 * 
	 * @param analysisBean
	 *            用户分析数据接口需要向相应接口调用地址POST的数据包
	 * @return 消息发送概况数据
	 * @throws CapabilityException
	 */
	@Override
	public UpStreamMsgDistMonthBean getUpStreamMsgDistMonth(AnalysisBean analysisBean) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UpStreamMsgDistMonthBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_UP_STREAM_MSG_DIST_MONTH_URL, args,
					new JSONUtils<AnalysisBean>(AnalysisBean.class), analysisBean,
					new JSONUtils<UpStreamMsgDistMonthBean>(UpStreamMsgDistMonthBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get upstream message distribution month failed.", e);
		}
		return resultBean;
	}

}
