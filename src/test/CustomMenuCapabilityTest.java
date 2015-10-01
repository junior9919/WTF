/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.halo.json.utils.JSONUtils;
import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.abilities.CustomMenuAbility;
import com.halo.wechat.capabilities.beans.AccessTokenBean;
import com.halo.wechat.capabilities.beans.MenuBean;
import com.halo.wechat.capabilities.beans.MenuBean.ButtonBean;
import com.halo.wechat.capabilities.beans.MenuResultBean;
import com.halo.wechat.capabilities.beans.ResultBean;

/**
 * @file CustomMenuCapabilityTest.java
 * @author Junior
 * @date 2015年9月1日 下午10:24:08
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class CustomMenuCapabilityTest {

	private final String ACCESS_TOKEN = "3DEzuQIpQCQFFaLgKE5-61IBdMt1I2OmLDvNdu3zmU9wBU2JrMcjKdafIpM--68aVk7s39TbHZHvUKfak9heEd6kHXjXoBO5w0EdUTszreU";

	private MenuBean menu;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private CustomMenuAbility customMenuAbility;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
		AccessTokenBean accessTokenBean = new AccessTokenBean();
		accessTokenBean.setAccess_token(ACCESS_TOKEN);
		accessTokenBean.setExpires_in(7200);
		SpringUtils.addIntoServletContext(accessTokenBean.getClass().getName(), accessTokenBean);

		MenuBean menu = new MenuBean();

		ButtonBean buttonEnv = menu.new ButtonBean();
		buttonEnv.setKey("article_env");
		buttonEnv.setName("开发环境");
		buttonEnv.setType(ButtonBean.BUTTON_TYPE_CLICK);

		ButtonBean buttonJava = menu.new ButtonBean();
		buttonJava.setKey("article_java");
		buttonJava.setName("Java语言");
		buttonJava.setType(ButtonBean.BUTTON_TYPE_CLICK);

		ButtonBean buttonDesign = menu.new ButtonBean();
		buttonDesign.setKey("article_design");
		buttonDesign.setName("设计模式");
		buttonDesign.setType(ButtonBean.BUTTON_TYPE_CLICK);

		ButtonBean buttonDatabase = menu.new ButtonBean();
		buttonDatabase.setKey("article_database");
		buttonDatabase.setName("数据库");
		buttonDatabase.setType(ButtonBean.BUTTON_TYPE_CLICK);

		List<ButtonBean> articleSubbuttons = new LinkedList<ButtonBean>();
		articleSubbuttons.add(buttonEnv);
		articleSubbuttons.add(buttonJava);
		articleSubbuttons.add(buttonDesign);
		articleSubbuttons.add(buttonDatabase);

		ButtonBean buttonArticle = menu.new ButtonBean();
		buttonArticle.setName("技术文章");
		buttonArticle.setSub_button(articleSubbuttons);

		ButtonBean buttonAbilities = menu.new ButtonBean();
		buttonAbilities.setKey("menual_abilities");
		buttonAbilities.setName("微信接口调用");
		buttonAbilities.setType(ButtonBean.BUTTON_TYPE_CLICK);

		ButtonBean buttonMessages = menu.new ButtonBean();
		buttonMessages.setKey("menual_messages");
		buttonMessages.setName("微信消息和事件");
		buttonMessages.setType(ButtonBean.BUTTON_TYPE_CLICK);

		ButtonBean buttonUtils = menu.new ButtonBean();
		buttonUtils.setKey("menual_utils");
		buttonUtils.setName("工具类");
		buttonUtils.setType(ButtonBean.BUTTON_TYPE_CLICK);

		ButtonBean buttonExceptions = menu.new ButtonBean();
		buttonExceptions.setKey("menual_exceptions");
		buttonExceptions.setName("异常速查手册");
		buttonExceptions.setType(ButtonBean.BUTTON_TYPE_CLICK);

		List<ButtonBean> menualSubbuttons = new LinkedList<ButtonBean>();
		menualSubbuttons.add(buttonAbilities);
		menualSubbuttons.add(buttonMessages);
		menualSubbuttons.add(buttonUtils);
		menualSubbuttons.add(buttonExceptions);

		ButtonBean buttonMenual = menu.new ButtonBean();
		buttonMenual.setName("开发手册");
		buttonMenual.setSub_button(menualSubbuttons);

		ButtonBean buttonTip = menu.new ButtonBean();
		buttonTip.setKey("tip");
		buttonTip.setName("打赏");
		buttonTip.setType(ButtonBean.BUTTON_TYPE_CLICK);

		List<ButtonBean> buttons = new LinkedList<ButtonBean>();
		buttons.add(buttonArticle);
		buttons.add(buttonMenual);
		buttons.add(buttonTip);

		menu.setButton(buttons);
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.CustomMenuCapability#createMenu(com.halo.wechat.capabilities.beans.MenuBean)}
	 * .
	 */
	@Test
	public void bTestCreateMenu() {
		ResultBean resultBean = null;
		try {
			resultBean = customMenuAbility.createMenu(menu);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(resultBean);

		System.out.println(String.valueOf(resultBean.getErrcode()) + "|" + resultBean.getErrmsg());

		assertEquals(0, resultBean.getErrcode());
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.CustomMenuCapability#getMenu()}.
	 */
	@Test
	public void cTestGetMenu() {
		MenuResultBean menuResultBean = null;
		try {
			menuResultBean = customMenuAbility.getMenu();
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(menuResultBean);

		JSONUtils<MenuResultBean> jsonUtils = new JSONUtils<MenuResultBean>(MenuResultBean.class);
		System.out.println(jsonUtils.getJsonStr(menuResultBean));
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.CustomMenuCapability#deleteMenu()}.
	 */
	@Test
	public void aTestDeleteMenu() {
		ResultBean resultBean = null;
		try {
			resultBean = customMenuAbility.deleteMenu();
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(resultBean);

		System.out.println(String.valueOf(resultBean.getErrcode()) + "|" + resultBean.getErrmsg());

		assertEquals(0, resultBean.getErrcode());
	}

}
