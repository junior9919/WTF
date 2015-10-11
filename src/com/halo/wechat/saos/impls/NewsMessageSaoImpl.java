/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.NewsMessage;
import com.halo.wechat.saos.SaoException;

/**
 * @author Junior
 * @date 2015年10月11日 上午10:59:16
 * @version 1.0
 * @since
 * @see
 */
public class NewsMessageSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(NewsMessage.class, xmlContent);
	}

}
