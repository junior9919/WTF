/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取图文分享转发每日数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:50:32
 * @version
 * @since
 */
public class UserShareHourBean extends ResultBean {

	private UserShareHourData[] list;

	/**
	 * @return UserShareHourData[]
	 *         不同share_scene的数据，以及ref_hour逐渐增大的数据。由于最大时间跨度为1，所以ref_date此处固定
	 */
	public UserShareHourData[] getList() {
		return list;
	}

	/**
	 * @param UserShareHourData[]
	 *            list
	 *            不同share_scene的数据，以及ref_hour逐渐增大的数据。由于最大时间跨度为1，所以ref_date此处固定
	 */
	public void setList(UserShareHourData[] list) {
		this.list = list;
	}

}
