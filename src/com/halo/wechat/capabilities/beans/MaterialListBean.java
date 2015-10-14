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

	public class Item {

		private int media_id;

		private Content content;

		private String update_time;

		/**
		 * @return 素材id（必须是永久mediaID）
		 */
		public int getMedia_id() {
			return media_id;
		}

		/**
		 * @param media_id
		 *            素材id（必须是永久mediaID）
		 */
		public void setMedia_id(int media_id) {
			this.media_id = media_id;
		}

		/**
		 * @return 图文消息内容
		 */
		public Content getContent() {
			return content;
		}

		/**
		 * @param content
		 *            图文消息内容
		 */
		public void setContent(Content content) {
			this.content = content;
		}

		/**
		 * @return 图文消息素材的最后更新时间
		 */
		public String getUpdate_time() {
			return update_time;
		}

		/**
		 * @param update_time
		 *            图文消息素材的最后更新时间
		 */
		public void setUpdate_time(String update_time) {
			this.update_time = update_time;
		}

	}

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
