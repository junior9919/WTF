/**
 * 
 */
package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @file BaseTest.java
 * @author Junior
 * @date 2015年8月28日 下午11:05:23
 * @version 1.0
 */
public class BaseTest {

	protected static final ApplicationContext applicationWeChatContext = new FileSystemXmlApplicationContext(
			new String[] { "src/com/halo/wechat/config/applicationContext-wechat.xml" });

	protected static final ApplicationContext applicationServletContext = new FileSystemXmlApplicationContext(
			new String[] { "src/com/halo/wechat/config/applicationContext-servlet.xml" });

}
