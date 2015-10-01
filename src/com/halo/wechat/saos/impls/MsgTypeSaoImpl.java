/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.saos.SaoException;

/**
 * @file MsgTypeSao.java
 * @author Junior
 * @date 2015年8月5日 下午9:46:16
 * @version 1.0
 */
public class MsgTypeSaoImpl extends AbstractMessageSaoImpl {

	@Override
	public MsgType get(String xmlContent) throws SaoException {
		return getByClass(MsgType.class, xmlContent);
	}

}
