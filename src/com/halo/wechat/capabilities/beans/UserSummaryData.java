package com.halo.wechat.capabilities.beans;

/**
 * 获取用户增减数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2015年12月29日 下午6:23:56
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class UserSummaryData {

	private String ref_date;

	private int user_source;

	private int new_user;

	private int cancel_user;

	/**
	 * @return String 数据的日期，格式“yyyy-mm-dd”
	 */
	public String getRef_date() {
		return ref_date;
	}

	/**
	 * @param String
	 *            ref_date 数据的日期，格式“yyyy-mm-dd”
	 */
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	/**
	 * @return int 用户的渠道，数值代表的含义如下：<br>
	 *         0代表其他合计;<br>
	 *         1代表公众号搜索;<br>
	 *         17代表名片分享;<br>
	 *         30代表扫描二维码;<br>
	 *         43代表图文页右上角菜单;<br>
	 *         51代表支付后关注（在支付完成页）;<br>
	 *         57代表图文页内公众号名称;<br>
	 *         75代表公众号文章广告;<br>
	 *         78代表朋友圈广告.
	 */
	public int getUser_source() {
		return user_source;
	}

	/**
	 * @param int
	 *            user_sourceint 用户的渠道，数值代表的含义如下：<br>
	 *            0代表其他合计;<br>
	 *            1代表公众号搜索;<br>
	 *            17代表名片分享;<br>
	 *            30代表扫描二维码;<br>
	 *            43代表图文页右上角菜单;<br>
	 *            51代表支付后关注（在支付完成页）;<br>
	 *            57代表图文页内公众号名称;<br>
	 *            75代表公众号文章广告;<br>
	 *            78代表朋友圈广告 <br>
	 */
	public void setUser_source(int user_source) {
		this.user_source = user_source;
	}

	/**
	 * @return int 新增的用户数量
	 */
	public int getNew_user() {
		return new_user;
	}

	/**
	 * @param int
	 *            new_user 新增的用户数量
	 */
	public void setNew_user(int new_user) {
		this.new_user = new_user;
	}

	/**
	 * @return int 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 */
	public int getCancel_user() {
		return cancel_user;
	}

	/**
	 * @param int
	 *            cancel_user 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 */
	public void setCancel_user(int cancel_user) {
		this.cancel_user = cancel_user;
	}

}
