package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.MenuBean;
import com.halo.wechat.capabilities.beans.MenuResultBean;
import com.halo.wechat.capabilities.beans.ResultBean;

public interface CustomMenuAbility {

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
	public ResultBean createMenu(MenuBean menu) throws CapabilityException;

	/**
	 * 自定义菜单查询接口
	 * 
	 * @return MenuResultBean 微信公众平台返回的菜单结构，其中包含一个MenuBean对象
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败都会引发异常
	 * @see MenuResultBean
	 */
	public MenuResultBean getMenu() throws CapabilityException;

	/**
	 * 自定义菜单删除接口
	 * 
	 * @return ResultBean 微信公众平台返回的结果值，详见公众平台开发者文档“全局返回码说明”
	 * @throws CapabilityException
	 *             从ServletContext中读写AccessTokenBean、请求服务器失败都会引发异常
	 * @see ResultBean
	 */
	public ResultBean deleteMenu() throws CapabilityException;

}
