/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.abilities.AccessAbility;
import com.halo.wechat.capabilities.beans.AccessTokenBean;
import com.halo.wechat.capabilities.beans.ServerAddrBean;

/**
 * @file AccessCapabilityTest.java
 * @author Junior
 * @date 2015年8月31日 下午10:28:48
 * @version 1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class AccessCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private AccessAbility accessAbility;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.AccessCapability#getAccessToken()}.
	 */
	@Test
	public void testGetAccessToken() {
		AccessTokenBean accessTokenBean = null;
		try {
			accessTokenBean = accessAbility.getAccessToken();
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(accessTokenBean);

		System.out.println(accessTokenBean.getAccess_token() + "|" + String.valueOf(accessTokenBean.getExpires_in()) + "|"
				+ String.valueOf(accessTokenBean.getRefreshTime()) + "|" + String.valueOf(accessTokenBean.getErrcode()) + "|" + accessTokenBean.getErrmsg());

		assertEquals(0, accessTokenBean.getErrcode());
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.AccessCapability#getServerAddr()}.
	 */
	@Test
	public void testGetServerAddr() {
		ServerAddrBean serverAddrBean = null;
		try {
			serverAddrBean = accessAbility.getServerAddr();
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(serverAddrBean);

		for (String serverAddr : serverAddrBean.getIp_list()) {
			System.out.println(serverAddr);
		}
	}

}
