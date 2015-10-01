/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

import org.w3c.dom.Node;

import com.halo.wechat.xml.utils.XmlConvertException;

/**
 * @file CommonConverter.java
 * @author Junior
 * @date 2015年8月5日 下午8:36:09
 * @version 1.0
 */
public class CommonConverter extends NodeConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.halo.wechat.xml.utils.converters.NodeConverter#convert(java.lang.
	 * Class, org.w3c.dom.Node)
	 */
	@Override
	public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
		// TODO 检查NodeType，如果不是elements，直接抛出异常，否则调用下一个处理类。
		if (Node.ELEMENT_NODE == node.getNodeType()) {
			if (null != this.getNextConverter()) {
				return this.getNextConverter().convert(clazz, node);
			} else {
				return null;
			}
		} else {
			throw new XmlConvertException("Only element node can convert to field, " + node.getNodeName() + " is " + node.getNodeType());
		}
	}

	@Override
	public String reverse(Object obj) throws XmlConvertException {
		if (null != this.getNextConverter()) {
			return this.getNextConverter().reverse(obj);
		} else {
			return "";
		}
	}

}
