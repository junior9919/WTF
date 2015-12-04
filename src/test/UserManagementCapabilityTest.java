/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.abilities.UserManagementAbility;
import com.halo.wechat.capabilities.beans.ResultBean;
import com.halo.wechat.capabilities.beans.UserInfoBean;
import com.halo.wechat.capabilities.beans.UserListBean;

/**
 * @author zyl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class UserManagementCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UserManagementAbility userManagementAbility;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	@Test
	public void testGetUserList() throws CapabilityException {
		UserListBean userListBean = userManagementAbility.getUserList("");

		assertNotNull(userListBean);

		System.out.println("total: " + userListBean.getTotal());
		System.out.println("count: " + userListBean.getCount());

		if (null != userListBean.getData()) {
			for (String openId : userListBean.getData().getOpenid()) {
				System.out.println("openid: " + openId);
			}
		}

		System.out.println("next_openid: " + userListBean.getNext_openid());
		System.out.println("errcode: " + userListBean.getErrcode());
		System.out.println("errmsg: " + userListBean.getErrmsg());
	}

	@Test
	public void testUpdateRemark() throws CapabilityException {
		ResultBean resultBean = userManagementAbility.updateRemark("oANCiuDnCPMDzMH81-JravbLFBUk", "我");

		assertNotNull(resultBean);

		System.out.println("errcode: " + resultBean.getErrcode());
		System.out.println("errmsg: " + resultBean.getErrmsg());
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.UserManagementCapability#getUserInfo(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CapabilityException
	 */
	@Test
	public void testGetUserInfo() throws CapabilityException {
		UserInfoBean userInfoBean = userManagementAbility.getUserInfo("oANCiuDnCPMDzMH81-JravbLFBUk", "zh_CN");

		assertNotNull(userInfoBean);

		System.out.println("subscribe: " + userInfoBean.getSubscribe());
		System.out.println("nickname: " + userInfoBean.getNickname());
		System.out.println("sex: " + userInfoBean.getSex());
		System.out.println("country: " + userInfoBean.getCountry());
		System.out.println("province: " + userInfoBean.getProvince());
		System.out.println("city: " + userInfoBean.getCity());
		System.out.println("language: " + userInfoBean.getLanguage());
		System.out.println("headimgurl: " + userInfoBean.getHeadimgurl());
		System.out.println("subscribe_time: " + new Date(userInfoBean.getSubscribe_time()));
	}

}
