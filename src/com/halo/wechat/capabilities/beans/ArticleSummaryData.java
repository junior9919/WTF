/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取图文群发每日数据接口的返回数据
 * 
 * @author zyl
 * @date 2016年1月2日 下午6:38:36
 * @version
 * @since
 */
public class ArticleSummaryData {

	private String ref_date;

	private String msgid;

	private String title;

	private int int_page_read_user;

	private int int_page_read_count;

	private int ori_page_read_user;

	private int ori_page_read_count;

	private int share_user;

	private int share_count;

	private int add_to_fav_user;

	private int add_to_fav_count;

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
	 *         请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（
	 *         消息次序索引）组成，<br>
	 *         例如12003_3， 其中12003是msgid，即一次群发的消息的id；
	 *         3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	public String getMsgid() {
		return msgid;
	}

	/**
	 * @param String
	 *            msgid
	 *            请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index
	 *            （消息次序索引）组成，<br>
	 *            例如12003_3， 其中12003是msgid，即一次群发的消息的id；
	 *            3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	/**
	 * @return String 图文消息的标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param String
	 *            title 图文消息的标题
	 */
	public void setTitle(String title) {
		this.title = title;
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
