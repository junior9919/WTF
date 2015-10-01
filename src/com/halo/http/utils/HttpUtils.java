package com.halo.http.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * @file HttpUtils.java
 * @author Junior
 * @date 2015年8月19日 下午9:59:11
 * @version 1.0
 */
public class HttpUtils {

	public static String readEntityFromStream(HttpServletRequest request) throws HttpUtilsException {
		ServletInputStream stream = null;
		try {
			stream = request.getInputStream();
		} catch (IOException e) {
			throw new HttpUtilsException("An error occured when get input stream. ");
		}

		StringBuilder sb = new StringBuilder();
		byte[] b = new byte[4096];

		try {
			for (int n; (n = stream.read(b)) != -1;) {
				try {
					sb.append(new String(b, 0, n, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					throw new HttpUtilsException("Can't create string from byte. ");
				}
			}
		} catch (IOException e) {
			throw new HttpUtilsException("An error occured when read from stream. ");
		}
		return sb.toString();
	}

}
