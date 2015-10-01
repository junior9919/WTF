/**
 * 
 */
package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * @author zWX298166
 *
 */
public class ServerAddrBean extends ResultBean {

	private List<String> ip_list;

	/**
	 * @return the ip_list
	 */
	public List<String> getIp_list() {
		return ip_list;
	}

	/**
	 * @param ip_list
	 *            the ip_list to set
	 */
	public void setIp_list(List<String> ip_list) {
		this.ip_list = ip_list;
	}

}
