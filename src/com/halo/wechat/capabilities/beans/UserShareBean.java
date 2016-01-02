package com.halo.wechat.capabilities.beans;

/**
 * 获取图文分享转发数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:44:18
 * @version
 * @since
 */
public class UserShareBean extends ResultBean {

	private UserShareData[] list;

	/**
	 * @return UserShareData[]
	 *         不同share_scene（分享场景）的数据，以及ref_date在begin_date和end_date之间的数据
	 */
	public UserShareData[] getList() {
		return list;
	}

	/**
	 * @param UserShareData[]
	 *            list
	 *            不同share_scene（分享场景）的数据，以及ref_date在begin_date和end_date之间的数据
	 */
	public void setList(UserShareData[] list) {
		this.list = list;
	}

}
