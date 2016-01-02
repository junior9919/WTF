package com.halo.wechat.capabilities.beans;

/**
 * 获取图文统计分时数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:35:38
 * @version
 * @since
 */
public class UserReadHourBean extends ResultBean {

	private UserReadHourData[] list;

	/**
	 * @return UserReadHourData[] ref_hour逐渐增大,以列举1天24小时的数据
	 */
	public UserReadHourData[] getList() {
		return list;
	}

	/**
	 * @param UserReadHourData[]
	 *            list ref_hour逐渐增大,以列举1天24小时的数据
	 */
	public void setList(UserReadHourData[] list) {
		this.list = list;
	}

}
