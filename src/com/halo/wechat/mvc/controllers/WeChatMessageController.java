package com.halo.wechat.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.wechat.mvc.services.MessageService;
import com.halo.wechat.mvc.services.ServiceException;

/**
 * 拦截微信公众平台推送消息或事件的主控制器（Controller），本控制器由Spring框架自动配置和管理，实现对所有微信消息和事件的拦截和后续处理。<br>
 * 本控制器拦截的相对URL为"/send.do"，因此用户需在微信公众平台上配置服务器地址：http://网站根路径/send.do；<br>
 * 例如，您的网站根路径假设为：http://182.92.155.180/wechat；那么您在微信公众平台上配置的服务器地址应为：<br>
 * http://182.92.155.180/wechat/send.do
 * 
 * @author Junior
 * @date 2015年9月10日 下午10:59:57
 * @version 1.0
 * @since
 * @see
 */
@Controller
public class WeChatMessageController {

	@Autowired
	private MessageService messageService;

	/**
	 * 处理微信公众平台发送的HTTP请求，并回复。
	 * 
	 * @param arg0
	 *            HttpServletRequest对象，在第一次接入微信公众平台时，服务器会发来一个get方法，以验证服务器地址的有效性。
	 *            此后发来的都是post方法，其中带有消息内容。
	 * @param arg1
	 *            HttpServletResponse对象， 通过该对象可以向微信公众平台回复消息。
	 * @throws ControllerException
	 *             消息处理失败抛出的异常。
	 */
	@RequestMapping("/send.do")
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ControllerException {
		if (arg0.getMethod().toLowerCase().equals("get")) {
			if (null != arg0.getParameter("msg")) {
				try {
					messageService.processMessage(arg0, arg1);
				} catch (ServiceException e) {
					throw new ControllerException("Process message exception. ");
				}
			} else {
				try {
					messageService.checkSignature(arg0, arg1);
				} catch (ServiceException e) {
					throw new ControllerException("Check signature exception. ");
				}
			}
		} else {
			try {
				messageService.processMessage(arg0, arg1);
			} catch (ServiceException e) {
				throw new ControllerException("Process message exception. ");
			}
		}
	}

}