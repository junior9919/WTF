/**
 * 
 */
package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * 通过永久素材查询接口获得的永久素材列表
 * 
 * @author Junior
 * @date 2015年10月14日 下午10:29:23
 * @version 1.0
 * @since
 * @see
 */
public class MaterialListBean extends ResultBean {

	private int total_count;

	private int item_count;

	private List<Item> item;

	/**
	 * @return 该类型的素材的总数
	 */
	public int getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count
	 *            该类型的素材的总数
	 */
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return 本次调用获取的素材的数量
	 */
	public int getItem_count() {
		return item_count;
	}

	/**
	 * @param item_count
	 *            本次调用获取的素材的数量
	 */
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	/**
	 * @return 可能有多个图文消息item结构
	 */
	public List<Item> getItem() {
		return item;
	}

	/**
	 * @param item
	 *            可能有多个图文消息item结构
	 */
	public void setItem(List<Item> item) {
		this.item = item;
	}

}
