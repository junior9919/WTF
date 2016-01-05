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
import com.halo.wechat.capabilities.abilities.InterfaceAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryData;
import com.halo.wechat.capabilities.beans.InterfaceSummaryHourBean;
import com.halo.wechat.capabilities.beans.InterfaceSummaryHourData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class InterfaceAnalysisCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private InterfaceAnalysisAbility interfaceAnalysisAbility;

	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	@Test
	public void testGetInterfaceSummary() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		InterfaceSummaryBean interfaceSummaryBean = null;
		try {
			interfaceSummaryBean = interfaceAnalysisAbility.getInterfaceSummary(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(interfaceSummaryBean);

		if (0 == interfaceSummaryBean.getErrcode()) {
			for (int i = 0; i < interfaceSummaryBean.getList().length; i++) {
				InterfaceSummaryData interfaceSummaryData = interfaceSummaryBean.getList()[i];

				System.out.print("ref_date = " + interfaceSummaryData.getRef_date());
				System.out.print(" | callback_count = " + interfaceSummaryData.getCallback_count());
				System.out.print(" | fail_count = " + interfaceSummaryData.getFail_count());
				System.out.print(" | total_time_cost = " + interfaceSummaryData.getTotal_time_cost());
				System.out.println(" | max_time_cost = " + interfaceSummaryData.getMax_time_cost());
			}
		} else {
			System.out.println("errcode = " + interfaceSummaryBean.getErrcode());
			System.out.println("errmsg = " + interfaceSummaryBean.getErrmsg());
		}
	}

	@Test
	public void testGetInterfaceSummaryHour() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-14");
		analysisBean.setEnd_date("2015-11-14");

		InterfaceSummaryHourBean interfaceSummaryHourBean = null;
		try {
			interfaceSummaryHourBean = interfaceAnalysisAbility.getInterfaceSummaryHour(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(interfaceSummaryHourBean);

		if (0 == interfaceSummaryHourBean.getErrcode()) {
			for (int i = 0; i < interfaceSummaryHourBean.getList().length; i++) {
				InterfaceSummaryHourData interfaceSummaryHourData = interfaceSummaryHourBean.getList()[i];

				System.out.print("ref_date = " + interfaceSummaryHourData.getRef_date());
				System.out.print(" | ref_hour = " + interfaceSummaryHourData.getRef_hour());
				System.out.print(" | callback_count = " + interfaceSummaryHourData.getCallback_count());
				System.out.print(" | fail_count = " + interfaceSummaryHourData.getFail_count());
				System.out.print(" | total_time_cost = " + interfaceSummaryHourData.getTotal_time_cost());
				System.out.println(" | max_time_cost = " + interfaceSummaryHourData.getMax_time_cost());
			}
		} else {
			System.out.println("errcode = " + interfaceSummaryHourBean.getErrcode());
			System.out.println("errmsg = " + interfaceSummaryHourBean.getErrmsg());
		}
	}

}
