/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

/**
 * @file ConverterBuilder.java
 * @author Junior
 * @date 2015年8月5日 下午9:01:01
 * @version 1.0
 */
public class ConverterBuilder {
	public static NodeConverter newConverter() {
		CommonConverter commonConverter = new CommonConverter();
		PrimitiveConverter primitiveConverter = new PrimitiveConverter();
		StringConverter stringConverter = new StringConverter();
		TimestampConverter timestampConverter = new TimestampConverter();

		commonConverter.setNextConverter(primitiveConverter);
		primitiveConverter.setNextConverter(stringConverter);
		stringConverter.setNextConverter(timestampConverter);

		return commonConverter;
	}
}
