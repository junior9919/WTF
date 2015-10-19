package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.CustomMenuAbility;
import com.halo.wechat.capabilities.beans.MenuBean;
import com.halo.wechat.capabilities.beans.MenuResultBean;
import com.halo.wechat.capabilities.beans.ResultBean;

/**
 * 自定义菜单管理接口，本类实现了微信公众平台自定义菜单管理接口的创建、查询、删除菜单接口
 * 
 * @author Junior
 * @date 2015年9月10日 下午9:35:19
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class CustomMenuCapability extends AccessSupportCapability implements CustomMenuAbility {

	private final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";

	private final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get";

	private final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public CustomMenuCapability() throws PropertiesException {

	}

	/**
	 * 自定义菜单创建接口，向微信公众平台请求创建通过MenuBean参数定义的菜单
	 * 
	 * @param menu
	 *            申请创建的菜单
	 * @return ResultBean 微信公众平台返回的结果值，详见公众平台开发者文档“全局返回码说明”
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败都会引发异常
	 * @see MenuBean
	 * @see ResultBean
	 */
	@Override
	public ResultBean createMenu(MenuBean menu) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}

		String jsonStr = getJsonStr(new JSONUtils<MenuBean>(MenuBean.class), menu);
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().post(CREATE_MENU_URL, args, jsonStr, JSON_CONTENT_TYPE);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Create menu failed.", e);
		}

		return getJsonBean(new JSONUtils<ResultBean>(ResultBean.class), resultStr);
	}

	/**
	 * 自定义菜单查询接口
	 * 
	 * @return MenuResultBean 微信公众平台返回的菜单结构，其中包含一个MenuBean对象
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败都会引发异常
	 * @see MenuResultBean
	 */
	@Override
	public MenuResultBean getMenu() throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}

		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(GET_MENU_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get menu failed.", e);
		}

		return getJsonBean(new JSONUtils<MenuResultBean>(MenuResultBean.class), resultStr);
	}

	/**
	 * 自定义菜单删除接口
	 * 
	 * @return ResultBean 微信公众平台返回的结果值，详见公众平台开发者文档“全局返回码说明”
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败都会引发异常
	 * @see ResultBean
	 */
	@Override
	public ResultBean deleteMenu() throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}

		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(DELETE_MENU_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Delete menu failed.", e);
		}

		return getJsonBean(new JSONUtils<ResultBean>(ResultBean.class), resultStr);
	}

}
