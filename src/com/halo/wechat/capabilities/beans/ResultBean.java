package com.halo.wechat.capabilities.beans;

/**
 * 存储微信公众平台接口调用返回码和详细说明的类，同时也是AccessTokenBean等包含返回码的信息类的基类
 * 
 * @author Junior
 * @date 2015年9月10日 下午9:28:09
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class ResultBean {

	private int errcode;

	private String errmsg;

	/**
	 * @return int 微信公众平台全局返回码，详见开发者文档“全局返回码说明”
	 */
	public int getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode
	 *            微信公众平台全局返回码，详见开发者文档“全局返回码说明”
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return 返回码对应的详细信息
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg
	 *            String 返回码对应的详细信息
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
