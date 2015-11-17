package com.halo.wechat.capabilities.beans;

public class Item {

	private String media_id;

	private String name;

	private Content content;

	private String update_time;

	private String url;

	/**
	 * @return 素材id（必须是永久mediaID）
	 */
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id
	 *            素材id（必须是永久mediaID）
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	/**
	 * @return 文件名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            文件名称
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return 当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public Item() {

	}

}
