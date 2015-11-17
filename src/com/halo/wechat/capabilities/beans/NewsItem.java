/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 图文消息素材
 * 
 * @author Junior
 * @date 2015年10月14日 下午10:40:14
 * @version 1.0
 * @since
 * @see
 */
public class NewsItem {

	private String title;

	private String thumb_media_id;

	private byte show_cover_pic;

	private String author;

	private String digest;

	private String content;

	private String url;

	private String content_source_url;

	/**
	 * @return 图文消息的标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            图文消息的标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return 图文消息的封面图片素材id（必须是永久mediaID）
	 */
	public String getThumb_media_id() {
		return thumb_media_id;
	}

	/**
	 * @param thumb_media_id
	 *            图文消息的封面图片素材id（必须是永久mediaID）
	 */
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	/**
	 * @return 是否显示封面，0为false，即不显示，1为true，即显示
	 */
	public byte getShow_cover_pic() {
		return show_cover_pic;
	}

	/**
	 * @param show_cover_pic
	 *            是否显示封面，0为false，即不显示，1为true，即显示
	 */
	public void setShow_cover_pic(byte show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	/**
	 * @return 作者
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 */
	public String getDigest() {
		return digest;
	}

	/**
	 * @param digest
	 *            图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}

	/**
	 * @return 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return 图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	public String getContent_source_url() {
		return content_source_url;
	}

	/**
	 * @param content_source_url
	 *            图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

	public NewsItem() {

	}
	
}
