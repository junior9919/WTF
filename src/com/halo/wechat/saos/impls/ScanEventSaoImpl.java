/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.ScanEvent;
import com.halo.wechat.saos.SaoException;

/**
 * @author zWX298166
 *
 */
public class ScanEventSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(ScanEvent.class, xmlContent);
	}

}
