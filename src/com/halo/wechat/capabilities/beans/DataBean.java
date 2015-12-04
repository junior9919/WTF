package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * 用户列表数据
 * 
 * @author zyl
 *
 */
public class DataBean {

	private List<String> openid;

	/**
	 * @return List<String> 列表数据，OPENID的列表
	 */
	public List<String> getOpenid() {
		return openid;
	}

	/**
	 * @param List<String>
	 *            openid 列表数据，OPENID的列表
	 */
	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}

}
