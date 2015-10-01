package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.TextMessage;
import com.halo.wechat.saos.SaoException;

/**
 * @author ZhuYinli
 * @version 1.0
 * @created 04-八月-2015 21:57:20
 */
public class TextMessageSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(TextMessage.class, xmlContent);
	}

}