/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

import java.sql.Timestamp;

import org.w3c.dom.Node;

import com.halo.wechat.xml.utils.XmlConvertException;

/**
 * @file TimestampConverter.java
 * @author Junior
 * @date 2015年8月9日 下午2:16:47
 * @version 1.0
 */
public class TimestampConverter extends NodeConverter {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
		// TODO 如果clazz是Timestamp，用node的值创建新Timestamp对象并返回
		if (clazz.getName().equals("java.sql.Timestamp")) {
			long time;
			try {
				time = Long.parseLong(node.getFirstChild().getNodeValue());
			} catch (NumberFormatException e) {
				throw new XmlConvertException(node.getFirstChild().getNodeValue() + " isn't a number. ");
			}
			Timestamp timestamp = new Timestamp(time);
			return (T) timestamp;
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
		if (obj.getClass().getName().equals("java.sql.Timestamp")) {
			long time = ((Timestamp) obj).getTime();
			return String.valueOf(time);
		} else {
			if (null != this.getNextConverter()) {
				return this.getNextConverter().reverse(obj);
			} else {
				return "";
			}
		}
	}

}
