/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.LocationMessage;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.saos.SaoException;

/**
 * @file LocationMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午11:37:00
 * @version 1.0
 */
public class LocationMessageSaoImpl extends AbstractMessageSaoImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.halo.wechat.saos.impls.AbstractMessageSaoImpl#get(java.lang.String)
	 */
	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(LocationMessage.class, xmlContent);
	}

}
