package com.halo.wechat.capabilities.beans;

/**
 * 用户备注名长度超过限制时抛出异常
 * @author zyl
 *
 */
public class LengthExceedsException extends Error {

	private static final long serialVersionUID = -3934614596884028696L;

	public LengthExceedsException() {

	}

	public LengthExceedsException(String message) {
		super(message);
	}

}
