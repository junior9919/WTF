/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.VideoMessage;
import com.halo.wechat.saos.SaoException;

/**
 * @file VideoMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午11:22:22
 * @version 1.0
 */
public class VideoMessageSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(VideoMessage.class, xmlContent);
	}

}
