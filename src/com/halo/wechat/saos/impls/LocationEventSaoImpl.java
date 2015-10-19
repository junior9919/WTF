/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.LocationEvent;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.saos.SaoException;

/**
 * @author zWX298166
 *
 */
public class LocationEventSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(LocationEvent.class, xmlContent);
	}

}
