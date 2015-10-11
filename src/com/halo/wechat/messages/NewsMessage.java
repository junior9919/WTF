/**
 * 
 */
package com.halo.wechat.messages;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Junior
 * @date 2015年10月10日 下午9:04:52
 * @version 1.0
 * @since
 * @see
 */
public class NewsMessage extends Message {

	public class Item {

		private String title;

		private String description;

		private String picUrl;

		private String url;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the picUrl
		 */
		public String getPicUrl() {
			return picUrl;
		}

		/**
		 * @param picUrl
		 *            the picUrl to set
		 */
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		/**
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @param url
		 *            the url to set
		 */
		public void setUrl(String url) {
			this.url = url;
		}

	}

	public class Articles {

		private List<Item> items;

		/**
		 * @return the items
		 */
		public List<Item> getItems() {
			return items;
		}

		/**
		 * @param items
		 *            the items to set
		 */
		public void setItems(List<Item> items) {
			this.items = items;
		}

	}

	private int articleCount;

	private Articles articles;

	/**
	 * @return the articleCount
	 */
	public int getArticleCount() {
		return articleCount;
	}

	/**
	 * @param articleCount
	 *            the articleCount to set
	 */
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	/**
	 * @return the articles
	 */
	public Articles getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(Articles articles) {
		this.articles = articles;
	}

	/**
	 * 无参构造方法，不做任何操作，为方便用Spring自动创建类而声明
	 */
	public NewsMessage() {

	}

	/**
	 * @param toUserName
	 * @param fromUserName
	 * @param createTime
	 * @param msgType
	 * @param msgId
	 */
	public NewsMessage(String toUserName, String fromUserName, Timestamp createTime, String msgType, int articleCount, Articles articles) {
		super(toUserName, fromUserName, createTime, msgType, 0);
		this.setArticleCount(articleCount);
		this.setArticles(articles);
	}

	/**
	 * @param toUserName
	 * @param fromUserName
	 * @param createTime
	 * @param msgType
	 * @param msgId
	 */
	public NewsMessage(String toUserName, String fromUserName, long createTime, String msgType, int articleCount, Articles articles) {
		super(toUserName, fromUserName, createTime, msgType, 0);
		this.setArticleCount(articleCount);
		this.setArticles(articles);
	}

}
