/**
 * 
 */
package com.halo.wechat.capabilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @file WechatProperties.java
 * @author Junior
 * @date 2015年9月5日 上午10:32:33
 * @version 1.0
 */
public class WechatProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792017334419363603L;

	private final static String WECHAT_PROPERTIES_FILE_NAME = "wechat.properties";

	private static WechatProperties instance;

	private WechatProperties() {

	}

	private WechatProperties(Properties arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public static synchronized WechatProperties getInstance() throws PropertiesException {
		if (null == instance) {
			instance = new WechatProperties();
			InputStream propertiesFileStream = WechatProperties.class.getResourceAsStream("/" + WECHAT_PROPERTIES_FILE_NAME);
			if (null == propertiesFileStream) {
				throw new PropertiesException("Load properties file " + WECHAT_PROPERTIES_FILE_NAME + " failed, please sure file is in the classpath.");
			}
			try {
				instance.load(propertiesFileStream);
			} catch (IOException e) {
				throw new PropertiesException("Load properties file " + WECHAT_PROPERTIES_FILE_NAME + " error: " + e.getMessage());
			}
		}
		return instance;
	}

}
