/**
 * 
 */
package com.halo.wechat.mvc.controllers;

/**
 * @author zWX298166
 *
 */
public class ControllerException extends Exception {

	private static final long serialVersionUID = -3544708201392321636L;

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}

}
