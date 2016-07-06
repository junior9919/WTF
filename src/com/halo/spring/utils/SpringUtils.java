package com.halo.spring.utils;

import java.util.Locale;

import javax.servlet.ServletContext;

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

	public static void loadWebApplicationContext() {
		if (null == webApplicationContext) {
			webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		}
		if (null == webApplicationContext) {
			throw new NullApplicationContextException(
					"Spring WebApplicationContext is null, please check web.xml make sure ContextLoaderListener configuration is correct.");
		}
	}

	public static WebApplicationContext getWebApplicationContext() {
		loadWebApplicationContext();
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

	public static Object getServletBean(String servletName, String beanId) {
		String attrId = FrameworkServlet.class.getName() + ".CONTEXT." + servletName;
		ApplicationContext servletApplicationContext = (ApplicationContext) getFromServletContext(attrId);
		if (null == servletApplicationContext) {
			throw new NullApplicationContextException("Servlet application context " + attrId + " is null.");
		}
		return servletApplicationContext.getBean(beanId);
	}

	public static Object getBean(String beanId) {
		if (null == applicationContext) {
			throw new NullApplicationContextException("Application context is null.");
		}
		return applicationContext.getBean(beanId);
	}

	public static void addIntoServletContext(String attrId, Object toAdd) throws NullApplicationContextException {
		loadWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		if (null == servletContext) {
			throw new NullApplicationContextException("Servlet context in web application context is null.");
		}
		servletContext.setAttribute(attrId, toAdd);
	}
	
	public static void removeFromServletContext(String attrId) throws NullApplicationContextException {
		loadWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		if (null == servletContext) {
			throw new NullApplicationContextException("Servlet context in web application context is null.");
		}

		servletContext.removeAttribute(attrId);
	}

	public static Object getFromServletContext(String attrId) {
		loadWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		if (null == servletContext) {
			throw new NullApplicationContextException("Servlet context in web application context is null.");
		}
		return servletContext.getAttribute(attrId);
	}

	public static String getMessage(String code, Object[] args) {
		loadWebApplicationContext();
		return webApplicationContext.getMessage(code, args, Locale.getDefault());
	}

}
