/**
 * 
 */
package com.halo.wechat.saos.impls;

import com.halo.wechat.messages.MsgType;
import com.halo.wechat.saos.SaoException;
import com.halo.wechat.saos.XmlSao;
import com.halo.wechat.xml.utils.XmlConvertException;
import com.halo.wechat.xml.utils.XmlParseException;
import com.halo.wechat.xml.utils.XmlTemplate;

/**
 * @file AbstractMessageSaoImpl.java
 * @author Junior
 * @date 2015年8月24日 下午10:42:29
 * @version 1.0
 */
public abstract class AbstractMessageSaoImpl implements XmlSao {

	private XmlTemplate xmlTemplate;

	protected <T> T getByClass(Class<T> clazz, String xmlContent) throws SaoException {
		try {
			return this.getXmlTemplate().get(clazz, xmlContent);
		} catch (XmlParseException | XmlConvertException e) {
			// TODO Auto-generated catch block
			throw new SaoException("Create " + clazz.getName() + " from XML failed. ", e);
		}
	}

	/**
	 * @return the xmlTemplate
	 */
	public XmlTemplate getXmlTemplate() {
		return xmlTemplate;
	}

	/**
	 * @param xmlTemplate
	 *            the xmlTemplate to set
	 */
	public void setXmlTemplate(XmlTemplate xmlTemplate) {
		this.xmlTemplate = xmlTemplate;
	}

	public abstract MsgType get(String xmlContent) throws SaoException;

	public String save(MsgType message) throws SaoException {
		try {
			return this.getXmlTemplate().save(message);
		} catch (XmlConvertException e) {
			throw new SaoException("Reverse " + message.getClass().getName() + " to XML failed.", e);
		}
	}
}
