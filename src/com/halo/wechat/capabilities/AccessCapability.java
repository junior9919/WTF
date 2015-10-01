package com.halo.wechat.capabilities;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.spring.utils.SpringUtils;
import com.halo.spring.utils.SpringUtilsException;
import com.halo.wechat.capabilities.abilities.AccessAbility;
import com.halo.wechat.capabilities.beans.AccessTokenBean;
import com.halo.wechat.capabilities.beans.ServerAddrBean;

/**
 * 获取微信接口调用凭据，本类实现了获取全局唯一票据（access_token）的方法，和获取微信服务器的IP地址方法。<br>
 * 在微信开发框架中，在接收任何微信推送消息和事件之前都会调用本类的方法，获取接口调用凭据。<br>
 * 用户也可以在自己的项目中的任何地方实例化本类的对象，来调用本类的方法，前提是用户项目是基于Spring框架的web应用。
 * 
 * @author Junior
 * @date 2015年9月10日 下午8:50:27
 * @version 1.0
 * @since Wechat Framework 1.0
 * @see AbstractCapability
 */
public class AccessCapability extends AbstractCapability implements AccessAbility {

	private final String APP_ID_NAME = "app_id";

	private final String APP_SECRET_NAME = "app_secret";

	private final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

	private final String GET_IP_LIST_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip";

	private boolean isAccessTokenExpired(AccessTokenBean accessTokenBean) {
		long currentTime = Calendar.getInstance().getTimeInMillis();
		long timeEscape = currentTime - accessTokenBean.getRefreshTime();
		long expiresTime = accessTokenBean.getExpires_in() * 1000;
		return timeEscape >= expiresTime;
	}

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public AccessCapability() throws CapabilityException {

	}

	/**
	 * 从参数文件中获取微信公众号的app_id，如果抛出异常则需检查配置文件中的app_id参数是否正确配置
	 * 
	 * @return 微信公众号的app_id
	 * @throws CapabilityException
	 *             app_id参数在配置文件中不存在，或未设置值。
	 */
	public String getAppId() throws CapabilityException {
		return getProperty(APP_ID_NAME);
	}

	/**
	 * 从参数文件中获取微信公众号的app_secret，如果抛出异常则需检查配置文件中的app_secret参数是否正确配置
	 * 
	 * @return 微信公众号的app_secret
	 * @throws CapabilityException
	 *             app_secret参数在配置文件中不存在，或未设置值。
	 */
	public String getAppSecret() throws CapabilityException {
		return getProperty(APP_SECRET_NAME);
	}

	/**
	 * 调用微信平台接口的获取access_token。<br>
	 * 返回的AccessTokenBean对象中含有从微信平台获取的接口调用凭据（access_token）
	 * 
	 * @return 
	 *         AccessTokenBean对象，对象属性中包含了接口调用凭据（access_token），凭证有效时间（expires_in）等信息
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败都会引发异常
	 * @see AccessTokenBean
	 */
	@Override
	public AccessTokenBean getAccessToken() throws CapabilityException {
		AccessTokenBean accessTokenBean;
		try {
			accessTokenBean = (AccessTokenBean) SpringUtils.getFromServletContext(AccessTokenBean.class.getName());
		} catch (SpringUtilsException e) {
			throw new CapabilityException("Get access token from application context error: " + e.getMessage());
		}
		if (null == accessTokenBean || isAccessTokenExpired(accessTokenBean)) {
			Map<String, String> args = new HashMap<String, String>();
			args.put("grant_type", "client_credential");
			args.put("appid", getAppId());
			args.put("secret", getAppSecret());
			String resultStr = null;
			try {
				resultStr = this.getHttpTemplate().get(GET_ACCESS_TOKEN_URL, args);
			} catch (HttpUtilsException e) {
				throw new CapabilityException("Get access token error. ");
			}

			accessTokenBean = getJsonBean(new JSONUtils<AccessTokenBean>(AccessTokenBean.class), resultStr);
			if (null != accessTokenBean) {
				accessTokenBean.setRefreshTime(Calendar.getInstance().getTimeInMillis());
			}

			try {
				SpringUtils.addIntoServletContext(accessTokenBean.getClass().getName(), accessTokenBean);
			} catch (SpringUtilsException e) {
				throw new CapabilityException("Add access token into servlet context error: " + e.getMessage());
			}
		}
		return accessTokenBean;
	}

	/**
	 * 通过接口获得微信服务器IP地址列表
	 * 
	 * @return ServerAddrBean对象，对象属性中包含服务器IP地址列表信息
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败会引发本异常
	 * @see ServerAddrBean
	 */
	@Override
	public ServerAddrBean getServerAddr() throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("access_token", getAccessToken().getAccess_token());
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(GET_IP_LIST_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get server ip list error. ");
		}

		return getJsonBean(new JSONUtils<ServerAddrBean>(ServerAddrBean.class), resultStr);
	}

}
