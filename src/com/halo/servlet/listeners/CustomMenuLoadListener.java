/**
 * 
 */
package com.halo.servlet.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.halo.json.utils.JSONUtils;
import com.halo.json.utils.JSONUtilsException;
import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.abilities.CustomMenuAbility;
import com.halo.wechat.capabilities.beans.MenuBean;
import com.halo.wechat.capabilities.beans.ResultBean;
import com.halo.wechat.logger.AppLogger;

/**
 * 这个监听器在web应用启动时检查在web应用根目录下是否有文件名为customMenu.json的文件，<br>
 * 如果有，则删除原微信公众号的菜单，按文件内容创建新菜单。<br>
 * customMenu.json文件的内容要符合微信公众平台自定义菜单创建接口标准。<br>
 * CustomMenuLoadListener需要在web.xml中配置才能生效，配置格式如下：<br>
 * <listener><br>
 * <blockquote><listener-class>com.halo.servlet.listeners.CustomMenuLoadListener
 * </listener-class><br>
 * </listener>
 * 注意：CustomMenuLoadListener的配置需要放在filter和ContextLoaderListener（如果有的话
 * ）的配置之后，servlet（如果有的话）的配置之前。<br>
 * 开发者可以在web.xml的context-param节中指定自己的菜单文件名，param-name为customMenuLocation，如下例：<br>
 * <context-param><br>
 * <blockquote><param-name>customMenuLocation</param-name><br>
 * <blockquote><param-value>myMenu.json</param-value><br>
 * </context-param><br>
 * 注意： <br>
 * 1. 菜单文件只能有一个，不要试图添加多个菜单文件名，那样找不到任何菜单文件；<br>
 * 2. 修改或添加新的菜单文件后，需重启web应用才会生效；<br>
 * 3. 如果要删除原菜单又不创建新菜单，请在web应用根目录下放置一个名为“deleteMenu.json”的空文件；<br>
 * 4.
 * 菜单文件也可以放在web应用根目录下的任意子目录中，在配置文件路径时使用相对于web应用根目录的路径，例如：resources\myMenu.json
 * 
 * @author Junior
 * @date 2015年10月6日 下午7:37:22
 * @version 1.0
 * @since
 * @see
 */
public class CustomMenuLoadListener implements ServletContextListener {

	private AppLogger appLogger;

	private String getMenuFileName(ServletContext servletContext) {
		String customMenuFileName = "customMenu.json";
		String userMenuFileName = servletContext.getInitParameter("customMenuLocation");
		if (null != userMenuFileName) {
			customMenuFileName = userMenuFileName;
		}
		String fullPathFileName = servletContext.getRealPath("/") + customMenuFileName;
		return fullPathFileName;
	}

	private File getMenuFile(String menuFileName) {
		File file = new File(menuFileName);
		if (!file.exists()) {
			appLogger.getLogger().error(file.getPath() + " does not exist.");
			return null;
		}
		return file;
	}

	private String getJsonStr(File file) {
		FileInputStream fileInputStream = null;
		String jsonStr = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[fileInputStream.available()];
			fileInputStream.read(buffer);
			jsonStr = new String(buffer, "UTF-8");
		} catch (IOException e) {
			appLogger.getLogger().error("Error reading file with message: " + e.getMessage());
		} finally {
			try {
				if (null != fileInputStream) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				appLogger.getLogger().error("Error close file with message: " + e.getMessage());
			}
		}
		return jsonStr;
	}

	private boolean deleteMenu(CustomMenuAbility customMenuAbility) {
		ResultBean resultBean = null;
		try {
			resultBean = customMenuAbility.deleteMenu();
		} catch (CapabilityException e) {
			appLogger.getLogger().error("An error occured when attempt delete menu, with message: " + e.getMessage());
			return false;
		}
		if (null != resultBean) {
			appLogger.getLogger().info("Delete menu request return: " + String.valueOf(resultBean.getErrcode()) + "|" + resultBean.getErrmsg());
			return 0 == resultBean.getErrcode();
		} else {
			return false;
		}
	}

	private boolean createMenu(String menuJson, CustomMenuAbility customMenuAbility) {
		JSONUtils<MenuBean> jsonUtils = new JSONUtils<MenuBean>(MenuBean.class);
		MenuBean menu = null;
		try {
			menu = jsonUtils.getJsonBean(menuJson);
		} catch (JSONUtilsException e) {
			appLogger.getLogger().error(e.getMessage());
			return false;
		}
		if (null != menu) {
			ResultBean resultBean = null;
			try {
				resultBean = customMenuAbility.createMenu(menu);
			} catch (CapabilityException e) {
				appLogger.getLogger().error("Create menu error: " + e.getMessage());
				return false;
			}
			if (null != resultBean) {
				appLogger.getLogger().info("Delete menu request return: " + String.valueOf(resultBean.getErrcode()) + "|" + resultBean.getErrmsg());
				return 0 == resultBean.getErrcode();
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		appLogger = (AppLogger) SpringUtils.getBean("appLogger");

		appLogger.getLogger().debug("Starting create menu...");

		String menuFileName = getMenuFileName(arg0.getServletContext());

		appLogger.getLogger().debug("Menu file is " + menuFileName);

		File menuFile = getMenuFile(menuFileName);
		if (null != menuFile) {

			appLogger.getLogger().debug("Got a menu file.");

			CustomMenuAbility customMenuAbility = (CustomMenuAbility) SpringUtils.getBean("customMenuAbility");
			if (null == customMenuAbility) {
				appLogger.getLogger().error("Get customMenuAbility bean error, may be applicationContext-wechat.xml is damaged.");
				return;
			}
			if (menuFileName.endsWith("deleteMenu.json")) {

				appLogger.getLogger().debug("Ready to delete menu.");

				if (!deleteMenu(customMenuAbility)) {
					appLogger.getLogger().debug("Delete menu request has no response.");
				}
			} else {
				String jsonStr = getJsonStr(menuFile);
				if (null != jsonStr && !jsonStr.isEmpty()) {
					if (deleteMenu(customMenuAbility)) {
						if (!createMenu(jsonStr, customMenuAbility)) {
							appLogger.getLogger().debug("Create menu wrong.");
						}
					}
				} else {
					appLogger.getLogger().error("File read error, or file is empty.");
				}

			}
		}

		appLogger.getLogger().debug("End create menu.");
	}

}
