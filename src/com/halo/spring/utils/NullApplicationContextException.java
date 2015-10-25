package com.halo.spring.utils;

/**
 * @file NullWebApplicationContextException.java
 * @author Junior
 * @date 2015年8月28日 下午10:40:11
 * @version 1.0
 */
public class NullApplicationContextException extends RuntimeException {

	private static final long serialVersionUID = 5096369159157276362L;

	public NullApplicationContextException(String message) {
		super(message);
	}

}
