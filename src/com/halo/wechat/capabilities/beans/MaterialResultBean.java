/**
 * 
 */
package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * 根据media_id获取的永久素材，需要时也可保存到本地。
 * 
 * @author Junior
 * @date 2015年10月18日 上午11:06:06
 * @version 1.0
 * @since
 * @see
 */
public class MaterialResultBean extends ResultBean {

	private String title;

	private String description;

	private String down_url;

	private List<NewsItem> news_item;

	/**
	 * @return 如果请求的素材是视频消息，则此处为视频消息的标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            如果请求的素材是视频消息，则此处为视频消息的标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return 如果请求的素材是视频消息，则此处为视频消息的描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            如果请求的素材是视频消息，则此处为视频消息的描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 如果请求的素材是视频消息，则此处为视频的下载地址
	 */
	public String getDown_url() {
		return down_url;
	}

	/**
	 * @param down_url
	 *            如果请求的素材是视频消息，则此处为视频的下载地址
	 */
	public void setDown_url(String down_url) {
		this.down_url = down_url;
	}

	/**
	 * @return 如果请求的素材为图文消息，则图文消息内容包括在该字段中。
	 */
	public List<NewsItem> getNews_item() {
		return news_item;
	}

	/**
	 * @param news_item
	 *            the news_item to set
	 */
	public void setNews_item(List<NewsItem> news_item) {
		this.news_item = news_item;
	}
}
