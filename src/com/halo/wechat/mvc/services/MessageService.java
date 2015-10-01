/**
 * 
 */
package com.halo.wechat.mvc.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @file MessageService.java
 * @author Junior
 * @date 2015年8月9日 上午10:40:41
 * @version 1.0
 */
public interface MessageService {

	public void checkSignature(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

	public void processMessage(HttpServletRequest request, HttpServletResponse response) throws ServiceException;

}
