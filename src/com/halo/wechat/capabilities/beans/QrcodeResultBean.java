/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * @author Junior
 * @date 2015年9月20日 下午9:32:16
 * @version 1.0
 * @since
 * @see
 */
public class QrcodeResultBean extends ResultBean {

	private String ticket;

	private short expire_seconds;

	private String url;

	/**
	 * @return 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return short 二维码的有效时间，以秒为单位。最大不超过1800。
	 */
	public short getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @param expire_seconds
	 *            short 二维码的有效时间，以秒为单位。最大不超过1800。
	 */
	public void setExpire_seconds(short expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	/**
	 * @return 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
