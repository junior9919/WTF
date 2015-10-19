/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.VoiceMessage;
import com.halo.wechat.saos.SaoException;

/**
 * @file VoiceMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午11:11:27
 * @version 1.0
 */
public class VoiceMessageSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(VoiceMessage.class, xmlContent);
	}

}
