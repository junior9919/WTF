/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取素材总数<br>
 * 请注意： 1.永久素材的总数，也会计算公众平台官网素材管理中的素材<br>
 * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000<br>
 *
 * @author Junior
 * @date 2015年10月15日 下午9:39:31
 * @version 1.0
 * @since
 * @see
 */
public class MaterialCountBean extends ResultBean {

	private short voice_count;

	private short video_count;

	private short image_count;

	private short news_count;

	/**
	 * @return 语音总数量
	 */
	public short getVoice_count() {
		return voice_count;
	}

	/**
	 * @param voice_count
	 *            语音总数量
	 */
	public void setVoice_count(short voice_count) {
		this.voice_count = voice_count;
	}

	/**
	 * @return 视频总数量
	 */
	public short getVideo_count() {
		return video_count;
	}

	/**
	 * @param video_count
	 *            视频总数量
	 */
	public void setVideo_count(short video_count) {
		this.video_count = video_count;
	}

	/**
	 * @return 图片总数量
	 */
	public short getImage_count() {
		return image_count;
	}

	/**
	 * @param image_count
	 *            图片总数量
	 */
	public void setImage_count(short image_count) {
		this.image_count = image_count;
	}

	/**
	 * @return 图文总数量
	 */
	public short getNews_count() {
		return news_count;
	}

	/**
	 * @param news_count
	 *            图文总数量
	 */
	public void setNews_count(short news_count) {
		this.news_count = news_count;
	}

}
