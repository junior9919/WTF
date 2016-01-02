package com.halo.wechat.capabilities.beans;

/**
 * 获取用户增减数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2015年12月29日 下午9:31:26
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserSummaryBean extends ResultBean {

	private UserSummaryData[] list;

	/**
	 * @return UserSummaryData[] 有多条ref_date在begin_date和end_date之间的数据
	 */
	public UserSummaryData[] getList() {
		return list;
	}

	/**
	 * @param UserSummaryData[]
	 *            list 有多条ref_date在begin_date和end_date之间的数据
	 */
	public void setList(UserSummaryData[] list) {
		this.list = list;
	}

}
