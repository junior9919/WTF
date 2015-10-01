package com.halo.wechat.saos;

import com.halo.wechat.messages.MsgType;

/**
 * @author ZhuYinli
 * @version 1.0
 * @created 04-八月-2015 21:57:21
 */
public interface XmlSao {
	/**
	 * 
	 * @param xmlContent
	 * @throws SaoException
	 */
	public MsgType get(String xmlContent) throws SaoException;

	/**
	 * 
	 * @param message
	 */
	public String save(MsgType message) throws SaoException;

}