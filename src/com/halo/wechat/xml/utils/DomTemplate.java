package com.halo.wechat.xml.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.halo.wechat.xml.utils.converters.ConverterBuilder;
import com.halo.wechat.xml.utils.converters.NodeConverter;

/**
 * @author ZhuYinli
 * @version 1.0
 * @created 04-八月-2015 21:57:20
 */
public class DomTemplate implements XmlTemplate {

	private Document document;

	private Map<String, Method> retrieveSetters(Method[] methods) {
		Map<String, Method> setters = new HashMap<String, Method>();
		for (Method method : methods) {
			if (method.getName().substring(0, 3).equals("set")) {
				String fieldName = method.getName().substring(3, method.getName().length());
				setters.put(fieldName, method);
			}
		}
		return setters;
	}

	private Map<String, Method> retrieveGetters(Method[] methods) {
		Map<String, Method> getters = new HashMap<String, Method>();
		for (Method method : methods) {
			if (method.getName().substring(0, 3).equals("get")) {
				String fieldName = method.getName().substring(3, method.getName().length());
				getters.put(fieldName, method);
			}
		}
		return getters;
	}

	/**
	 * 
	 * @param xmlContent
	 * @throws XmlParseException
	 */
	public void parseDocument(String xmlContent) throws XmlParseException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new XmlParseException("Get XML document builder failed. ", e);
		}

		if (null == builder) {
			throw new XmlParseException("XML document builder is null. ");
		}

		try {
			document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes()));
		} catch (SAXException e) {
			throw new XmlParseException("Parse XML failed. \r\n" + xmlContent, e);
		} catch (IOException e) {
			throw new XmlParseException("Read XML stream failed. ", e);
		}

	}

	/**
	 * 
	 * @param clazz
	 * @param stream
	 * @throws XmlParseException
	 * @throws XmlConvertException
	 */
	public <T> T get(Class<T> clazz, String xmlContent) throws XmlParseException, XmlConvertException {
		Map<String, Method> setters = retrieveSetters(clazz.getMethods());

		parseDocument(xmlContent);

		T obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new XmlConvertException("Create new instance of " + clazz.getName() + " failed.", e);
		}

		for (String fieldName : setters.keySet()) {
			NodeList nodes = document.getElementsByTagName(fieldName);
			Method setter = setters.get(fieldName);
			Class<?>[] paramTypes = setter.getParameterTypes();
			if (1 < paramTypes.length) {
				throw new XmlConvertException("Field " + fieldName + "'s setter has more then one parameter. ");
			}
			if (0 >= paramTypes.length) {
				throw new XmlConvertException("Field " + fieldName + "'s setter has no parameter. ");
			}

			if (0 >= nodes.getLength()) {
				try {
					setter.invoke(obj, new Object[] { null });
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					throw new XmlConvertException("Invoke method " + setter.getName() + " failed.", e);
				}
				continue;
			}

			NodeConverter converter = ConverterBuilder.newConverter();
			try {
				setter.invoke(obj, converter.convert(paramTypes[0], nodes.item(0)));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new XmlConvertException("Invoke method " + setter.getName() + " failed.", e);
			}
		}
		return obj;
	}

	@Override
	public String save(Object obj) throws XmlConvertException {
		Map<String, Method> getters = retrieveGetters(obj.getClass().getMethods());
		NodeConverter converter = ConverterBuilder.newConverter();
		String xml = "<xml>\r\n";
		for (String fieldName : getters.keySet()) {
			if (fieldName.equals("Class")) {
				continue;
			}
			Method getter = getters.get(fieldName);
			Object value = null;
			try {
				value = getter.invoke(obj);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new XmlConvertException("Invoke method " + getter.getName() + " failed.", e);
			}

			String xmlValue = converter.reverse(value);
			if (!xmlValue.isEmpty()) {
				xml += "\t<" + fieldName + ">" + xmlValue + "</" + fieldName + ">\r\n";
			} else {
				xml += "\t<" + fieldName + "/>\r\n";
			}
		}
		xml += "</xml>";

		return xml;
	}
}