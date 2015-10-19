/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

import org.w3c.dom.Node;

import com.halo.wechat.xml.utils.XmlConvertException;

/**
 * @file StringConverter.java
 * @author Junior
 * @date 2015年8月5日 下午8:56:48
 * @version 1.0
 */
public class StringConverter extends NodeConverter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
		// TODO 如果clazz是String，直接返回node的值
		if (clazz.getName().equals("java.lang.String")) {
			return (T) node.getFirstChild().getNodeValue();
		} else {
			if (null != this.getNextConverter()) {
				return this.getNextConverter().convert(clazz, node);
			} else {
				return null;
			}
		}
	}

	@Override
	public String reverse(Object obj) throws XmlConvertException {
		if (obj.getClass().getName().equals("java.lang.String")) {
			return quotedCDATA(String.valueOf(obj));
		} else {
			if (null != this.getNextConverter()) {
				return this.getNextConverter().reverse(obj);
			} else {
				return "";
			}
		}
	}

}
