package com.halo.spring.utils;

import java.util.Locale;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FrameworkServlet;

/**
 * @file SpringUtils.java
 * @author Junior
 * @date 2015年8月9日 上午11:02:46
 * @version 1.0
 */
public class SpringUtils implements ApplicationContextAware {

	private static WebApplicationContext webApplicationContext;

	private static ApplicationContext applicationContext;

	public static void loadWebApplicationContext() throws NullWebApplicationContextException {
		if (null == webApplicationContext) {
			webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		}
		if (null == webApplicationContext) {
			throw new NullWebApplicationContextException(
					"Spring WebApplicationContext is null, please check web.xml make sure ContextLoaderListener configuration is correct.");
		}
	}

	public static WebApplicationContext getWebApplicationContext() {
		try {
			loadWebApplicationContext();
		} catch (NullWebApplicationContextException e) {
			return null;
		}

		return webApplicationContext;
	}

	public static void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		if (null == SpringUtils.webApplicationContext) {
			SpringUtils.webApplicationContext = webApplicationContext;
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) {
		applicationContext = arg0;
	}

	public static Object getServletBean(String servletName, String beanId) throws NullWebApplicationContextException {
		ApplicationContext servletApplicationContext = (ApplicationContext) getFromServletContext(FrameworkServlet.class.getName() + ".CONTEXT." + servletName);
		Object bean = null;
		try {
			bean = servletApplicationContext.getBean(beanId);
		} catch (NoSuchBeanDefinitionException e) {
			bean = null;
		}
		return bean;
	}

	public static Object getBean(String beanId) {
		Object bean = null;
		try {
			bean = applicationContext.getBean(beanId);
		} catch (NoSuchBeanDefinitionException e) {
			bean = null;
		}
		return bean;
	}

	public static void addIntoServletContext(String attrId, Object toAdd) throws NullWebApplicationContextException {
		loadWebApplicationContext();
		webApplicationContext.getServletContext().setAttribute(attrId, toAdd);
	}

	public static Object getFromServletContext(String attrId) throws NullWebApplicationContextException {
		loadWebApplicationContext();
		return webApplicationContext.getServletContext().getAttribute(attrId);
	}

	public static String getMessage(String code, Object[] args) {
		try {
			loadWebApplicationContext();
		} catch (NullWebApplicationContextException e) {
			return "";
		}
		return webApplicationContext.getMessage(code, args, Locale.getDefault());
	}

}
