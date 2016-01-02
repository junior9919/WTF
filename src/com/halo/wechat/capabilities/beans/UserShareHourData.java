package com.halo.wechat.capabilities.beans;

/**
 * 获取图文分享转发每日数据接口的返回数据
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:47:56
 * @version
 * @since
 */
public class UserShareHourData {

	private String ref_date;

	private String ref_hour;

	private int share_scene;

	private int share_user;

	private int share_count;

	/**
	 * @return String 数据的日期
	 */
	public String getRef_date() {
		return ref_date;
	}

	/**
	 * @param String
	 *            ref_date 数据的日期
	 */
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	/**
	 * @return String
	 *         数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	public String getRef_hour() {
		return ref_hour;
	}

	/**
	 * @param String
	 *            ref_hour
	 *            数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
	 */
	public void setRef_hour(String ref_hour) {
		this.ref_hour = ref_hour;
	}

	/**
	 * @return int 分享的场景：1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 */
	public int getShare_scene() {
		return share_scene;
	}

	/**
	 * @param int
	 *            share_scene 分享的场景：1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 */
	public void setShare_scene(int share_scene) {
		this.share_scene = share_scene;
	}

	/**
	 * @return int 分享的人数
	 */
	public int getShare_user() {
		return share_user;
	}

	/**
	 * @param int
	 *            分享的人数
	 */
	public void setShare_user(int share_user) {
		this.share_user = share_user;
	}

	/**
	 * @return int 分享的次数
	 */
	public int getShare_count() {
		return share_count;
	}

	/**
	 * @param int
	 *            share_count 分享的次数
	 */
	public void setShare_count(int share_count) {
		this.share_count = share_count;
	}

}
