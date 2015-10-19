/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.ShortVideoMessage;
import com.halo.wechat.saos.SaoException;

/**
 * @file ShortVideoMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午11:27:41
 * @version 1.0
 */
public class ShortVideoMessageSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(ShortVideoMessage.class, xmlContent);
	}

}
