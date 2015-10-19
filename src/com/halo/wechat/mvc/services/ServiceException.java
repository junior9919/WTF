/**
 * 
 */
package com.halo.wechat.mvc.services;

/**
 * @file ServiceException.java
 * @author Junior
 * @date 2015年8月9日 上午10:48:22
 * @version 1.0
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -969599128038861840L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
