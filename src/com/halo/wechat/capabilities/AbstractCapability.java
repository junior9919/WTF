package com.halo.wechat.capabilities;

import java.util.Properties;

import com.halo.http.utils.HttpTemplate;
import com.halo.json.utils.JSONUtils;
import com.halo.json.utils.JSONUtilsException;

/**
 * 微信能力接口抽象类，实际上本类中没有一个抽象方法。本类实现了所有微信能力接口的共用方法，可以当作是微信能力接口类的工具类。
 * 所有微信能力接口实现类都继承该方法，以获得类中公用方法的调用。
 * 
 * @author Junior
 * @date 2015年9月9日 下午9:42:10
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public abstract class AbstractCapability {

	private final String WECHAT_PROPERTIES_FILE_NAME = "wechat.properties";

	private HttpTemplate httpTemplate;

	private Properties properties;

	public final String JSON_CONTENT_TYPE = "application/json";

	/**
	 * 获得一个HttpTemplate对象，该对象是单例的，实现了HTTP协议的get和post方法。该对象由Spring框架自动创建并装配。
	 * 
	 * @return 由Spring框架自动创建并装配的HttpTemplate对象
	 */
	public HttpTemplate getHttpTemplate() {
		return httpTemplate;
	}

	/**
	 * @param httpTemplate
	 *            由Spring框架自动创建并装配的HttpTemplate对象
	 */
	public void setHttpTemplate(HttpTemplate httpTemplate) {
		this.httpTemplate = httpTemplate;
	}

	/**
	 * 获得用户微信客户端配置参数的Properties对象，用户微信客户端配置文件必须命名为"wechat.properties"（注意大小写），
	 * 并在classpath目录下。<br>
	 * 用户微信客户端的app_id、app_secret、token等参数在该文件中配置，在微信框架的压缩包中有一个范例
	 * "wechat.properties"文件可供参考。<br>
	 * 实际上用户程序不必调用本方法来获得Properties对象，调用getProperty方法可直接获得某个参数的值。
	 * 
	 * @return 获得用户微信客户端配置参数的Properties对象
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * 构造方法，在对象实例化时加载"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public AbstractCapability() throws CapabilityException {
		try {
			properties = WechatProperties.getInstance();
		} catch (PropertiesException e) {
			throw new CapabilityException("Instantiate capability object error: " + e.getMessage());
		}
	}

	/**
	 * 通过参数名propertyName获取"wechat.properties"配置文件中的参数值
	 * 
	 * @param propertyName
	 *            参数名，系统默认的微信客户端参数有：app_id、app_secret、token；用户也可以在配置文件中声明自己的参数。
	 * @return String类型的参数值
	 * @throws CapabilityException
	 *             参数名在配置文件中不存在，将抛出异常。此时应当检查配置文件是否损坏或参数名是否与配置文件中一致
	 */
	public String getProperty(String propertyName) throws CapabilityException {
		String propertyValue = getProperties().getProperty(propertyName);
		if (null == propertyValue) {
			throw new CapabilityException("Missing " + propertyName + " in " + WECHAT_PROPERTIES_FILE_NAME + ", please make sure property has been set.");
		}
		return propertyValue;
	}

	/**
	 * 将json字符串转换成对象，本方法多用于解析微信服务器post请求中的json字符串
	 * 
	 * @param jsonUtils
	 *            JSONUtils对象，json字符串转换工具。JSONUtils由泛型定义，可以指定要解析的类。
	 * @param jsonStr
	 *            要解析的json字符串
	 * @return 解析后的对象，类型由JSONUtils的泛型指定
	 * @throws CapabilityException
	 *             解析过程中发生错误抛出的异常
	 */
	public <T> T getJsonBean(JSONUtils<T> jsonUtils, String jsonStr) throws CapabilityException {
		T bean = null;
		try {
			bean = jsonUtils.getJsonBean(jsonStr);
		} catch (JSONUtilsException e) {
			throw new CapabilityException("Parse result error with json string: " + jsonStr);
		}

		return bean;
	}

	/**
	 * 将一个对象编码成json字符串，本方法多用于编码微信能力接口中的请求数据，例如自定义菜单能力接口（CustomMenuCapability）
	 * 中要创建的菜单
	 * 
	 * @param jsonUtils
	 *            JSONUtils对象，json字符串转换工具。JSONUtils由泛型定义，可以指定要编码的类。
	 * @param jsonBean
	 *            要编码的对象
	 * @return 编码后的json字符串
	 */
	public <T> String getJsonStr(JSONUtils<T> jsonUtils, T jsonBean) {
		return jsonUtils.getJsonStr(jsonBean);
	}

}
