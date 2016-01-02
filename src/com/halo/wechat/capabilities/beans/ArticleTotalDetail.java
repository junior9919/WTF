/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:08:57
 * @version
 * @since
 */
public class ArticleTotalDetail {

	private String stat_date;

	private int target_user;

	private int int_page_read_user;

	private int int_page_read_count;

	private int ori_page_read_user;

	private int ori_page_read_count;

	private int share_user;

	private int share_count;

	private int add_to_fav_user;

	private int add_to_fav_count;

	/**
	 * @return String 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期，
	 *         而stat_date是数据统计日期
	 */
	public String getStat_date() {
		return stat_date;
	}

	/**
	 * @param String
	 *            stat_date 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期，
	 *            而stat_date是数据统计日期
	 */
	public void setStat_date(String stat_date) {
		this.stat_date = stat_date;
	}

	/**
	 * @return int 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
	 */
	public int getTarget_user() {
		return target_user;
	}

	/**
	 * @param int
	 *            target_user 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
	 */
	public void setTarget_user(int target_user) {
		this.target_user = target_user;
	}

	/**
	 * @return int 图文页（点击群发图文卡片进入的页面）的阅读人数
	 */
	public int getInt_page_read_user() {
		return int_page_read_user;
	}

	/**
	 * @param int
	 *            int_page_read_user 图文页（点击群发图文卡片进入的页面）的阅读人数
	 */
	public void setInt_page_read_user(int int_page_read_user) {
		this.int_page_read_user = int_page_read_user;
	}

	/**
	 * @return int 图文页的阅读次数
	 */
	public int getInt_page_read_count() {
		return int_page_read_count;
	}

	/**
	 * @param int
	 *            int_page_read_count 图文页的阅读次数
	 */
	public void setInt_page_read_count(int int_page_read_count) {
		this.int_page_read_count = int_page_read_count;
	}

	/**
	 * @return int 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 */
	public int getOri_page_read_user() {
		return ori_page_read_user;
	}

	/**
	 * @param int
	 *            ori_page_read_user 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 */
	public void setOri_page_read_user(int ori_page_read_user) {
		this.ori_page_read_user = ori_page_read_user;
	}

	/**
	 * @return int 原文页的阅读次数
	 */
	public int getOri_page_read_count() {
		return ori_page_read_count;
	}

	/**
	 * @param int
	 *            ori_page_read_count 原文页的阅读次数
	 */
	public void setOri_page_read_count(int ori_page_read_count) {
		this.ori_page_read_count = ori_page_read_count;
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

	/**
	 * @return int 收藏的人数
	 */
	public int getAdd_to_fav_user() {
		return add_to_fav_user;
	}

	/**
	 * @param int
	 *            add_to_fav_user 收藏的人数
	 */
	public void setAdd_to_fav_user(int add_to_fav_user) {
		this.add_to_fav_user = add_to_fav_user;
	}

	/**
	 * @return int 收藏的次数
	 */
	public int getAdd_to_fav_count() {
		return add_to_fav_count;
	}

	/**
	 * @param int
	 *            add_to_fav_count 收藏的次数
	 */
	public void setAdd_to_fav_count(int add_to_fav_count) {
		this.add_to_fav_count = add_to_fav_count;
	}

}
