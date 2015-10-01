package com.halo.spring.utils;

import org.springframework.beans.BeansException;
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

	public static WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}

	public static void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		if (null == SpringUtils.webApplicationContext) {
			SpringUtils.webApplicationContext = webApplicationContext;
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
	}

	public static Object getServletBean(String servletName, String beanId) throws SpringUtilsException {
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

	public static void addIntoServletContext(String attrId, Object toAdd) throws SpringUtilsException {
		if (null == webApplicationContext) {
			webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		}
		if (null == webApplicationContext) {
			throw new SpringUtilsException(
					"Spring WebApplicationContext is null, please check web.xml make sure ContextLoaderListener configuration is correct.");
		}
		webApplicationContext.getServletContext().setAttribute(attrId, toAdd);
	}

	public static Object getFromServletContext(String attrId) throws SpringUtilsException {
		if (null == webApplicationContext) {
			webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		}
		if (null == webApplicationContext) {
			throw new SpringUtilsException(
					"Spring WebApplicationContext is null, please check web.xml make sure ContextLoaderListener configuration is correct.");
		}
		return webApplicationContext.getServletContext().getAttribute(attrId);
	}

}
