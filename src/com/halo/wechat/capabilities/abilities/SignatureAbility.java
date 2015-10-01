package com.halo.wechat.capabilities.abilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.wechat.capabilities.CapabilityException;

public interface SignatureAbility {

	/**
	 * 开发者通过检验signature对请求进行校验。若确认此次GET请求来自微信服务器，原样返回echostr参数内容。<br>
	 * 则接入生效，成为开发者成功，否则接入失败。
	 * 
	 * @param request
	 *            HttpServletRequest对象，从中获取微信公众平台发来的signature等参数
	 * @param response
	 *            HttpServletResponse对象，通过该对象向微信公众平台回复校验结果
	 * @return boolean 校验通过返回true，否则返回false
	 * @throws CapabilityException
	 *             获取参数失败，加密签名失败，校验失败都会抛出该异常
	 */
	public boolean checkSignature(HttpServletRequest request, HttpServletResponse response) throws CapabilityException;

}
