package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.UserManagementAbility;
import com.halo.wechat.capabilities.beans.DataBean;
import com.halo.wechat.capabilities.beans.ResultBean;
import com.halo.wechat.capabilities.beans.UserInfoBean;
import com.halo.wechat.capabilities.beans.UserListBean;
import com.halo.wechat.capabilities.beans.UserRemarkBean;

/**
 * @author zyl
 *
 */
public class UserManagementCapability extends AccessSupportCapability implements UserManagementAbility {

	private final String GET_USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get";

	private final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

	private final String UPDATE_REMARK_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark";

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
	 * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID组成。<br>
	 * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
	 * 
	 * @param String
	 *            nextOpenId 第一个拉取的OPENID，为空值("")时默认从头开始拉取
	 * @return UserListBean 关注者列表数据
	 * @throws CapabilityException
	 */
	@Override
	public UserListBean getUserList(String nextOpenId) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);
		if (!nextOpenId.isEmpty()) {
			args.put("next_openid", nextOpenId);
		}

		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(GET_USER_LIST_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get user info failed.", e);
		}

		@SuppressWarnings("rawtypes")
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("data", DataBean.class);

		return getComplexJsonBean(new JSONUtils<UserListBean>(UserListBean.class), resultStr, classMap);
	}

	/**
	 * 开发者可以通过该接口对指定用户设置备注名，该接口暂时开放给微信认证的服务号。
	 * 
	 * @param String
	 *            openId 用户标识
	 * @param String
	 *            remark 新的备注名，长度必须小于30字符
	 * @return 微信公众平台接口调用返回码和详细说明
	 */
	@Override
	public ResultBean updateRemark(String openId, String remark) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		UserRemarkBean userRemarkBean = new UserRemarkBean();
		userRemarkBean.setOpenid(openId);
		userRemarkBean.setRemark(remark);

		ResultBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(UPDATE_REMARK_URL, args,
					new JSONUtils<UserRemarkBean>(UserRemarkBean.class), userRemarkBean,
					new JSONUtils<ResultBean>(ResultBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Update remark failed.", e);
		}
		return resultBean;
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
		putAccessTokenIntoArgs(args);
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
