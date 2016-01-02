package com.halo.wechat.capabilities.beans;

/**
 * 获取累计用户数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2015年12月29日 下午9:35:22
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserCumulateBean extends ResultBean {

	private UserCumulateData[] list;

	/**
	 * @return UserCumulateData[] 有多条ref_date在begin_date和end_date之间的数据
	 */
	public UserCumulateData[] getList() {
		return list;
	}

	/**
	 * @param UserCumulateData[]
	 *            list 有多条ref_date在begin_date和end_date之间的数据
	 */
	public void setList(UserCumulateData[] list) {
		this.list = list;
	}

}
