/**
 * 
 */
package com.halo.wechat.capabilities;

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
	public AccessSupportCapability() throws CapabilityException {

	}

	/**
	 * 获取接口调用凭据
	 * 
	 * @return 接口调用凭据（access token）
	 * @throws CapabilityException
	 *             获取接口调用凭据返回null值时抛出该异常
	 */
	public AccessTokenBean retrieveAccessToken() throws CapabilityException {
		AccessTokenBean accessTokenBean = getAccessToken();
		if (null == accessTokenBean) {
			throw new CapabilityException("Can't get access token.");
		}
		return accessTokenBean;
	}
}
