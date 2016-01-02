/**
 * 
 */
package test;

import static org.junit.Assert.*;

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
import com.halo.wechat.capabilities.abilities.UserAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.UserCumulateBean;
import com.halo.wechat.capabilities.beans.UserCumulateData;
import com.halo.wechat.capabilities.beans.UserSummaryBean;
import com.halo.wechat.capabilities.beans.UserSummaryData;

/**
 * 
 * @author zyl
 * @date 2015年12月30日 下午9:07:48
 * @version
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class UserAnalysisCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UserAnalysisAbility userAnalysisAbility;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.UserAnalysisCapability#getUserSummary(com.halo.wechat.capabilities.beans.AnalysisBean)}
	 * .
	 */
	@Test
	public void testGetUserSummary() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		UserSummaryBean userSummaryBean = null;
		try {
			userSummaryBean = userAnalysisAbility.getUserSummary(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(userSummaryBean);

		if (0 == userSummaryBean.getErrcode()) {
			/*
			 * for (Iterator<UserSummaryData> it =
			 * userSummaryBean.getList().iterator(); it.hasNext();) {
			 * UserSummaryData userSummaryData = it.next();
			 */
			for (int i = 0; i < userSummaryBean.getList().length; i++) {
				UserSummaryData userSummaryData = userSummaryBean.getList()[i];

				System.out.print("ref_date = " + userSummaryData.getRef_date());
				System.out.print(" | user_source = " + userSummaryData.getUser_source());
				System.out.print(" | new_user = " + userSummaryData.getNew_user());
				System.out.println(" | cancel_user = " + userSummaryData.getCancel_user());
			}
		} else {
			System.out.println("errcode = " + userSummaryBean.getErrcode());
			System.out.println("errmsg = " + userSummaryBean.getErrmsg());
		}
	}

	/**
	 * Test method for
	 * {@link com.halo.wechat.capabilities.UserAnalysisCapability#getUserCumulate(com.halo.wechat.capabilities.beans.AnalysisBean)}
	 * .
	 */
	@Test
	public void testGetUserCumulate() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		UserCumulateBean userCumulateBean = null;
		try {
			userCumulateBean = userAnalysisAbility.getUserCumulate(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(userCumulateBean);

		if (0 == userCumulateBean.getErrcode()) {
			for (int i = 0; i < userCumulateBean.getList().length; i++) {
				UserCumulateData userCumulateData = userCumulateBean.getList()[i];

				System.out.print("ref_date = " + userCumulateData.getRef_date());
				System.out.println(" | cumulate_user = " + userCumulateData.getCumulate_user());
			}
		} else {
			System.out.println("errcode = " + userCumulateBean.getErrcode());
			System.out.println("errmsg = " + userCumulateBean.getErrmsg());
		}
	}

}
