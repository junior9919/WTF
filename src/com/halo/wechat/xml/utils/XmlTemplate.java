package com.halo.wechat.xml.utils;

/**
 * @author ZhuYinli
 * @version 1.0
 * @created 04-八月-2015 21:57:21
 */
public interface XmlTemplate {

	/**
	 * 
	 * @param xmlContent
	 */
	public void parseDocument(String xmlContent) throws XmlParseException;

	/**
	 * 
	 * @param clazz
	 * @param xmlContent
	 */
	public <T> T get(Class<T> clazz, String xmlContent) throws XmlParseException, XmlConvertException;

	/**
	 * 
	 * @param obj
	 * @return
	 * @throws XmlConvertException
	 */
	public String save(Object obj) throws XmlConvertException;

}