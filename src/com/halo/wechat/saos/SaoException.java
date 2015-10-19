/**
 * 
 */
package com.halo.wechat.saos;

/**
 * @file SaoException.java
 * @author Junior
 * @date 2015年8月6日 下午10:45:53
 * @version 1.0
 */
public class SaoException extends Exception {

	private static final long serialVersionUID = -4439023763171846777L;

	public SaoException(String message) {
		super(message);
	}

	public SaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
