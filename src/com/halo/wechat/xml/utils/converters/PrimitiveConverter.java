/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

import java.io.UnsupportedEncodingException;

import org.w3c.dom.Node;

import com.halo.wechat.xml.utils.XmlConvertException;

/**
 * @file PrimitiveConverter.java
 * @author Junior
 * @date 2015年8月5日 下午8:45:30
 * @version 1.0
 */
public class PrimitiveConverter extends NodeConverter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
		// TODO 如果clazz是java基础数据类型，将node的值直接转换，否则继续调用下一个处理类
		if (clazz.isPrimitive()) {
			String className = clazz.getName();
			try {
				if (className.equals("byte")) {
					return (T) (new Byte(node.getFirstChild().getNodeValue()));
				} else if (className.equals("short")) {
					return (T) (new Short(node.getFirstChild().getNodeValue()));
				} else if (className.equals("int")) {
					return (T) (new Integer(node.getFirstChild().getNodeValue()));
				} else if (className.equals("long")) {
					return (T) (new Long(node.getFirstChild().getNodeValue()));
				} else if (className.equals("float")) {
					return (T) (new Float(node.getFirstChild().getNodeValue()));
				} else if (className.equals("double")) {
					return (T) (new Double(node.getFirstChild().getNodeValue()));
				} else if (className.equals("char")) {
					return (T) (new Character(node.getFirstChild().getNodeValue().charAt(0)));
				} else if (className.equals("boolean")) {
					return (T) (new Boolean(node.getFirstChild().getNodeValue()));
				} else {
					return null;
				}
			} catch (ClassCastException e) {
				throw new XmlConvertException(node.getFirstChild().getNodeValue() + " cann't cast to " + className);
			}
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
		String className = obj.getClass().getName();
		try {
			if (className.equals("java.lang.Byte")) {
				byte[] b = new byte[1];
				b[0] = (byte) obj;
				try {
					return quotedCDATA(new String(b, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					throw new XmlConvertException("Create string from byte failed.", e);
				}
			} else if (className.equals("java.lang.Short")) {
				return String.valueOf((int) obj);
			} else if (className.equals("java.lang.Integer")) {
				return String.valueOf((int) obj);
			} else if (className.equals("java.lang.Long")) {
				return String.valueOf((long) obj);
			} else if (className.equals("java.lang.Float")) {
				return String.valueOf((float) obj);
			} else if (className.equals("java.lang.Double")) {
				return String.valueOf((double) obj);
			} else if (className.equals("java.lang.Char")) {
				return quotedCDATA(String.valueOf((char) obj));
			} else if (className.equals("java.lang.Boolean")) {
				return quotedCDATA(String.valueOf((boolean) obj));
			} else {
				if (null != this.getNextConverter()) {
					return this.getNextConverter().reverse(obj);
				} else {
					return "";
				}
			}
		} catch (ClassCastException e) {
			throw new XmlConvertException(obj.toString() + " cann't cast to " + className);
		}
	}

}
