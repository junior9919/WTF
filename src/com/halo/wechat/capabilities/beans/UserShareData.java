package com.halo.wechat.capabilities.beans;

/**
 * 获取图文分享转发数据接口的返回数据
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:40:19
 * @version
 * @since
 */
public class UserShareData {

	private String ref_date;

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
