/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取图文统计数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:27:19
 * @version
 * @since
 */
public class UserReadBean extends ResultBean {

	private UserReadData[] list;

	/**
	 * @return UserReadData[] 在begin_date和end_date之间的数据
	 */
	public UserReadData[] getList() {
		return list;
	}

	/**
	 * @param UserReadData[]
	 *            list 在begin_date和end_date之间的数据
	 */
	public void setList(UserReadData[] list) {
		this.list = list;
	}

}
