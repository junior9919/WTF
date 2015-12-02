package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.UserManagementAbility;
import com.halo.wechat.capabilities.beans.UserInfoBean;

/**
 * @author zyl
 *
 */
public class UserManagementCapability extends AccessSupportCapability implements UserManagementAbility {

	private final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出PropertiesException异常
	 * 
	 * @throws PropertiesException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public UserManagementCapability() throws PropertiesException {

	}

	/**
	 * 公众号可通过本接口来根据OpenID获取用户基本信息，包括昵称、头像、性别、所在城市、语言和关注时间。
	 * 
	 * @param String
	 *            openId 普通用户的标识，对当前公众号唯一
	 * @param String
	 *            lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return 获取用户基本信息接口返回的用户信息，错误时微信会返回错误码等信息
	 */
	@Override
	public UserInfoBean getUserInfo(String openId, String lang) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}
		args.put("openid", openId);
		args.put("lang", lang);

		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(GET_USER_INFO_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user info failed.", e);
		}

		return getJsonBean(new JSONUtils<UserInfoBean>(UserInfoBean.class), resultStr);
	}

}
