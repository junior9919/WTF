/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

import org.w3c.dom.Node;

import com.halo.wechat.xml.utils.XmlConvertException;

/**
 * @file NodeConverter.java
 * @author Junior
 * @date 2015年8月5日 下午8:30:19
 * @version 1.0
 */
public abstract class NodeConverter {
	private NodeConverter nextConverter;

	protected String quotedCDATA(String data) {
		return "<![CDATA[" + data + "]]>";
	}

	/**
	 * @return the nextConverter
	 */
	public NodeConverter getNextConverter() {
		return nextConverter;
	}

	/**
	 * @param nextConverter
	 *            the nextConverter to set
	 */
	public void setNextConverter(NodeConverter nextConverter) {
		this.nextConverter = nextConverter;
	}

	public abstract <T> T convert(Class<T> clazz, Node node) throws XmlConvertException;

	public abstract String reverse(Object obj) throws XmlConvertException;
}
