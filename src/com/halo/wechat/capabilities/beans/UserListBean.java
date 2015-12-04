/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 关注者列表数据
 * 
 * @author zyl
 *
 */
public class UserListBean extends ResultBean {

	private int total;

	private short count;

	private DataBean data;

	private String next_openid;

	/**
	 * @return int 关注该公众账号的总用户数
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param int
	 *            total 关注该公众账号的总用户数
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return short 拉取的OPENID个数，最大值为10000
	 */
	public short getCount() {
		return count;
	}

	/**
	 * @param short
	 *            count 拉取的OPENID个数，最大值为10000
	 */
	public void setCount(short count) {
		this.count = count;
	}

	/**
	 * @return DataBean 列表数据，OPENID的列表
	 */
	public DataBean getData() {
		return data;
	}

	/**
	 * @param DataBean
	 *            data 列表数据，OPENID的列表
	 */
	public void setData(DataBean data) {
		this.data = data;
	}

	/**
	 * @return String 拉取列表的最后一个用户的OPENID
	 */
	public String getNext_openid() {
		return next_openid;
	}

	/**
	 * @param String
	 *            next_openid 拉取列表的最后一个用户的OPENID
	 */
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}

}
