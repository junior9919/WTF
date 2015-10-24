/**
 * 
 */
package com.halo.wechat.mvc.commands;

/**
 * @author Junior
 * @date 2015年9月26日 下午12:20:31
 * @version 1.0
 * @since
 * @see
 */
public class CommandException extends Exception {

	private static final long serialVersionUID = -9112433239365559192L;

	public CommandException(String message) {
		super(message);
	}

	public CommandException(String message, Throwable cause) {
		super(message, cause);
	}

}
