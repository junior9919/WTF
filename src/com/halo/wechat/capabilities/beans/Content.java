/**
 * 
 */
package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * 图文消息内容
 * 
 * @author Junior
 * @date 2015年10月14日 下午10:57:55
 * @version 1.0
 * @since
 * @see
 */
public class Content {

	private List<NewsItem> news_item;

	/**
	 * @return 多图文消息会在此处有多篇文章
	 */
	public List<NewsItem> getNews_item() {
		return news_item;
	}

	/**
	 * @param news_item
	 *            多图文消息会在此处有多篇文章
	 */
	public void setNews_item(List<NewsItem> news_item) {
		this.news_item = news_item;
	}

}
