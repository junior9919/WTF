package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * 获取用户增减数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2015年12月29日 下午9:31:26
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserSummaryBean extends ResultBean {

	private List<UserSummaryData> list;

	/**
	 * @return List<UserSummaryData> 有多条ref_date在begin_date和end_date之间的数据
	 */
	public List<UserSummaryData> getList() {
		return list;
	}

	/**
	 * @param List<UserSummaryData>
	 *            list 有多条ref_date在begin_date和end_date之间的数据
	 */
	public void setList(List<UserSummaryData> list) {
		this.list = list;
	}
	
}
