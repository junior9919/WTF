package com.halo.wechat.capabilities.beans;

/**
 * 保存微信公众平台全局唯一票据（access_token）信息的类，该类可以通过JSONUtils工具类与json字符串互相转换
 * 
 * @author Junior
 * @date 2015年9月10日 下午9:17:51
 * @version 1.0
 * @since Wechat Framework 1.0
 * @see JSONUtils\
 */
public class AccessTokenBean extends ResultBean {

	private String access_token;

	private long expires_in;

	private long refreshTime;

	/**
	 * 
	 * @return String 从微信平台获取到的公众号全局唯一票据，详见微信公众平台开发者文档。
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            从微信平台获取到的公众号全局唯一票据，详见微信公众平台开发者文档。
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return long 凭证有效时间，单位：秒
	 */
	public long getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            凭证有效时间，单位：秒
	 */
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return long 最近一次从微信平台获取access_token的时间，单位：毫秒。<br>
	 *         用当前时间（Timestamp格式）减去该时间后转换成毫秒（结果除以1000），如果大于expires_in，
	 *         说明access_token已过期，需从微信平台重新获取。
	 */
	public long getRefreshTime() {
		return refreshTime;
	}

	/**
	 * @param refreshTime
	 *            最近一次从微信平台获取access_token的时间，单位：毫秒。
	 */
	public void setRefreshTime(long refreshTime) {
		this.refreshTime = refreshTime;
	}

}
