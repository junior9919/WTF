/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.ImageMessage;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.saos.SaoException;

/**
 * @file ImageMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午10:39:10
 * @version 1.0
 */
public class ImageMessageSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(ImageMessage.class, xmlContent);
	}

}
