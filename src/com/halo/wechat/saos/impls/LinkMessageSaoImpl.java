/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.LinkMessage;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.saos.SaoException;

/**
 * @file LinkMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午11:42:59
 * @version 1.0
 */
public class LinkMessageSaoImpl extends AbstractMessageSaoImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.halo.wechat.saos.impls.AbstractMessageSaoImpl#get(java.lang.String)
	 */
	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(LinkMessage.class, xmlContent);
	}

}
