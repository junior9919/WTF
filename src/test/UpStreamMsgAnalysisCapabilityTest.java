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
import com.halo.wechat.capabilities.abilities.UpStreamMsgAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgData;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistData;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistMonthBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistMonthData;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistWeekBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgDistWeekData;
import com.halo.wechat.capabilities.beans.UpStreamMsgHourBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgHourData;
import com.halo.wechat.capabilities.beans.UpStreamMsgMonthBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgMonthData;
import com.halo.wechat.capabilities.beans.UpStreamMsgWeekBean;
import com.halo.wechat.capabilities.beans.UpStreamMsgWeekData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class UpStreamMsgAnalysisCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UpStreamMsgAnalysisAbility upStreamMsgAnalysisAbility;

	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	@Test
	public void testGetUpStreamMsg() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		UpStreamMsgBean upStreamMsgBean = null;
		try {
			upStreamMsgBean = upStreamMsgAnalysisAbility.getUpStreamMsg(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgBean);

		if (0 == upStreamMsgBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgBean.getList().length; i++) {
				UpStreamMsgData upStreamMsgData = upStreamMsgBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgData.getRef_date());
				System.out.print(" | msg_type = " + upStreamMsgData.getMsg_type());
				System.out.print(" | msg_user = " + upStreamMsgData.getMsg_user());
				System.out.println(" | msg_count = " + upStreamMsgData.getMsg_count());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgBean.getErrmsg());
		}
	}

	@Test
	public void testGetUpStreamMsgHour() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-14");
		analysisBean.setEnd_date("2015-11-14");

		UpStreamMsgHourBean upStreamMsgHourBean = null;
		try {
			upStreamMsgHourBean = upStreamMsgAnalysisAbility.getUpStreamMsgHour(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgHourBean);

		if (0 == upStreamMsgHourBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgHourBean.getList().length; i++) {
				UpStreamMsgHourData upStreamMsgHourData = upStreamMsgHourBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgHourData.getRef_date());
				System.out.print(" | ref_hour = " + upStreamMsgHourData.getRef_hour());
				System.out.print(" | msg_type = " + upStreamMsgHourData.getMsg_type());
				System.out.print(" | msg_user = " + upStreamMsgHourData.getMsg_user());
				System.out.println(" | msg_count = " + upStreamMsgHourData.getMsg_count());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgHourBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgHourBean.getErrmsg());
		}
	}

	@Test
	public void testGetUpStreamMsgWeek() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		UpStreamMsgWeekBean upStreamMsgWeekBean = null;
		try {
			upStreamMsgWeekBean = upStreamMsgAnalysisAbility.getUpStreamMsgWeek(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgWeekBean);

		if (0 == upStreamMsgWeekBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgWeekBean.getList().length; i++) {
				UpStreamMsgWeekData upStreamMsgWeekData = upStreamMsgWeekBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgWeekData.getRef_date());
				System.out.print(" | msg_type = " + upStreamMsgWeekData.getMsg_type());
				System.out.print(" | msg_user = " + upStreamMsgWeekData.getMsg_user());
				System.out.println(" | msg_count = " + upStreamMsgWeekData.getMsg_count());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgWeekBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgWeekBean.getErrmsg());
		}
	}

	@Test
	public void testGetUpStreamMsgMonth() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-01");
		analysisBean.setEnd_date("2015-11-30");

		UpStreamMsgMonthBean upStreamMsgMonthBean = null;
		try {
			upStreamMsgMonthBean = upStreamMsgAnalysisAbility.getUpStreamMsgMonth(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgMonthBean);

		if (0 == upStreamMsgMonthBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgMonthBean.getList().length; i++) {
				UpStreamMsgMonthData upStreamMsgMonthData = upStreamMsgMonthBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgMonthData.getRef_date());
				System.out.print(" | msg_type = " + upStreamMsgMonthData.getMsg_type());
				System.out.print(" | msg_user = " + upStreamMsgMonthData.getMsg_user());
				System.out.println(" | msg_count = " + upStreamMsgMonthData.getMsg_count());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgMonthBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgMonthBean.getErrmsg());
		}
	}

	@Test
	public void testGetUpStreamMsgDist() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		UpStreamMsgDistBean upStreamMsgDistBean = null;
		try {
			upStreamMsgDistBean = upStreamMsgAnalysisAbility.getUpStreamMsgDist(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgDistBean);

		if (0 == upStreamMsgDistBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgDistBean.getList().length; i++) {
				UpStreamMsgDistData upStreamMsgDistData = upStreamMsgDistBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgDistData.getRef_date());
				System.out.print(" | count_interval = " + upStreamMsgDistData.getCount_interval());
				System.out.println(" | msg_user = " + upStreamMsgDistData.getMsg_user());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgDistBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgDistBean.getErrmsg());
		}
	}

	@Test
	public void testGetUpStreamMsgDistWeek() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-08");
		analysisBean.setEnd_date("2015-11-14");

		UpStreamMsgDistWeekBean upStreamMsgDistWeekBean = null;
		try {
			upStreamMsgDistWeekBean = upStreamMsgAnalysisAbility.getUpStreamMsgDistWeek(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgDistWeekBean);

		if (0 == upStreamMsgDistWeekBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgDistWeekBean.getList().length; i++) {
				UpStreamMsgDistWeekData upStreamMsgWeekData = upStreamMsgDistWeekBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgWeekData.getRef_date());
				System.out.print(" | count_interval = " + upStreamMsgWeekData.getCount_interval());
				System.out.println(" | msg_user = " + upStreamMsgWeekData.getMsg_user());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgDistWeekBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgDistWeekBean.getErrmsg());
		}
	}

	@Test
	public void testGetUpStreamMsgDistMonth() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-11-01");
		analysisBean.setEnd_date("2015-11-30");

		UpStreamMsgDistMonthBean upStreamMsgDistMonthBean = null;
		try {
			upStreamMsgDistMonthBean = upStreamMsgAnalysisAbility.getUpStreamMsgDistMonth(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(upStreamMsgDistMonthBean);

		if (0 == upStreamMsgDistMonthBean.getErrcode()) {
			for (int i = 0; i < upStreamMsgDistMonthBean.getList().length; i++) {
				UpStreamMsgDistMonthData upStreamMsgDistMonthData = upStreamMsgDistMonthBean.getList()[i];

				System.out.print("ref_date = " + upStreamMsgDistMonthData.getRef_date());
				System.out.print(" | count_interval = " + upStreamMsgDistMonthData.getCount_interval());
				System.out.println(" | msg_user = " + upStreamMsgDistMonthData.getMsg_user());
			}
		} else {
			System.out.println("errcode = " + upStreamMsgDistMonthBean.getErrcode());
			System.out.println("errmsg = " + upStreamMsgDistMonthBean.getErrmsg());
		}
	}

}
