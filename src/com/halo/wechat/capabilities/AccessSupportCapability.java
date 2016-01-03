/**
 * 
 */
package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;

import com.halo.wechat.capabilities.beans.AccessTokenBean;

/**
 * 本类提供对获取接口调用凭据的支持，本类继承自AccessCapability，但与AccessCapability不同，本类是供那些需要access
 * token的能力接口类（例如自定义菜单接口）继承的。<br>
 * 能力接口类继承本类后即可很方便的获得access token，而不用在类中再去引用AccessCapability类。
 * 
 * @author Junior
 * @date 2015年9月22日 下午10:27:03
 * @version 1.0
 * @since
 * @see
 */
public class AccessSupportCapability extends AccessCapability {

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public AccessSupportCapability() throws PropertiesException {

	}

	/**
	 * 获取接口调用凭据
	 * 
	 * @return 接口调用凭据（access token）
	 * @throws NullAccessTokenException
	 *             获取接口调用凭据返回null值时抛出该异常
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean失败、请求AccessToken失败、
	 *             读参数失败引发的异常
	 */
	public AccessTokenBean retrieveAccessToken() throws NullAccessTokenException, CapabilityException {
		AccessTokenBean accessTokenBean = getAccessToken();
		if (null == accessTokenBean) {
			throw new NullAccessTokenException("Get access token failed.");
		}
		return accessTokenBean;
	}

	/**
	 * 将接口调用凭据放进准备post的参数Map中，大部分能力接口需要这个方法
	 * 
	 * @param args
	 *            调用本方法前需要先创建args的对象，否则本方法将创建一个HashMap<String, String>的对象
	 * @throws CapabilityException
	 *             获取的Access Token为空时抛出的异常
	 */
	public void putAccessTokenIntoArgs(Map<String, String> args) throws CapabilityException {
		if (null == args) {
			args = new HashMap<String, String>();
		}

		try {
			args.put("access_token", retrieveAccessToken().getAccess_token());
		} catch (NullAccessTokenException e) {
			throw new CapabilityException("Retrieve access token failed.", e);
		}
	}

}
