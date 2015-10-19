/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.ViewEvent;
import com.halo.wechat.saos.SaoException;

/**
 * @author zWX298166
 *
 */
public class ViewEventSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(ViewEvent.class, xmlContent);
	}

}
