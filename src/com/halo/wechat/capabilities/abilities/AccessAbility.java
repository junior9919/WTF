package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.AccessTokenBean;
import com.halo.wechat.capabilities.beans.ServerAddrBean;

public interface AccessAbility {

	/**
	 * 调用微信平台接口的获取access_token。<br>
	 * 返回的AccessTokenBean对象中含有从微信平台获取的接口调用凭据（access_token）
	 * 
	 * @return 
	 *         AccessTokenBean对象，对象属性中包含了接口调用凭据（access_token），凭证有效时间（expires_in）等信息
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean失败、请求AccessToken失败、
	 *             读参数失败引发的异常
	 * @see AccessTokenBean
	 */
	public AccessTokenBean getAccessToken() throws CapabilityException;

	/**
	 * 通过接口获得微信服务器IP地址列表
	 * 
	 * @return ServerAddrBean对象，对象属性中包含服务器IP地址列表信息
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器地址失败引发的异常
	 */
	public ServerAddrBean getServerAddr() throws CapabilityException;

}
