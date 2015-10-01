package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Calendar;

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

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.abilities.QrcodeAbility;
import com.halo.wechat.capabilities.beans.AccessTokenBean;
import com.halo.wechat.capabilities.beans.QrcodeResultBean;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class QrcodeCapabilityTest {

	private final String ACCESS_TOKEN = "UvmDJT11CBIMBoALxMmILaNUzQDiqU1Kot5sO5FoTNN05PB5xsLblK9IU6H0hBp_BgfDcnMlWShVRWs0kHoLds3ES31-2xrDPy78x1-KBMw";

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private QrcodeAbility qrcodeAbility;

	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);

		AccessTokenBean accessTokenBean = new AccessTokenBean();
		accessTokenBean.setAccess_token(ACCESS_TOKEN);
		accessTokenBean.setExpires_in(7200);
		accessTokenBean.setRefreshTime(Calendar.getInstance().getTimeInMillis());
		SpringUtils.addIntoServletContext(accessTokenBean.getClass().getName(), accessTokenBean);
	}

	public QrcodeResultBean testGetTemporaryQrcode() {
		QrcodeResultBean qrcodeResultBean = null;
		try {
			qrcodeResultBean = qrcodeAbility.getTemporaryQrcode(1800, 123);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(qrcodeResultBean);

		System.out.println(qrcodeResultBean.getTicket() + " | " + String.valueOf(qrcodeResultBean.getExpire_seconds()) + " | " + qrcodeResultBean.getUrl()
				+ " | " + String.valueOf(qrcodeResultBean.getErrcode()) + " | " + qrcodeResultBean.getErrmsg());

		assertEquals(0, qrcodeResultBean.getErrcode());
		return qrcodeResultBean;
	}

	public QrcodeResultBean testGetPermanentQrcodeString() {
		QrcodeResultBean qrcodeResultBean = null;
		try {
			qrcodeResultBean = qrcodeAbility.getPermanentQrcode(234);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(qrcodeResultBean);

		System.out.println(qrcodeResultBean.getTicket() + " | " + String.valueOf(qrcodeResultBean.getExpire_seconds()) + " | " + qrcodeResultBean.getUrl()
				+ " | " + String.valueOf(qrcodeResultBean.getErrcode()) + " | " + qrcodeResultBean.getErrmsg());

		assertEquals(0, qrcodeResultBean.getErrcode());
		return qrcodeResultBean;
	}

	public QrcodeResultBean testGetPermanentQrcodeInt() {
		QrcodeResultBean qrcodeResultBean = null;
		try {
			qrcodeResultBean = qrcodeAbility.getPermanentQrcode("take me");
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(qrcodeResultBean);

		System.out.println(qrcodeResultBean.getTicket() + " | " + String.valueOf(qrcodeResultBean.getExpire_seconds()) + " | " + qrcodeResultBean.getUrl()
				+ " | " + String.valueOf(qrcodeResultBean.getErrcode()) + " | " + qrcodeResultBean.getErrmsg());

		assertEquals(0, qrcodeResultBean.getErrcode());
		return qrcodeResultBean;
	}

	@Test
	public void testGetQrcodeImage() {
		QrcodeResultBean qrcodeResultBean = null;
		qrcodeResultBean = testGetTemporaryQrcode();

		// String downloadPath =
		// webApplicationContext.getServletContext().getRealPath("/images");
		// String downloadFileName = downloadPath + "\\" +
		// qrcodeResultBean.getTicket() + ".jpg";
		String saveAsFileName = "E:\\myWork\\DownloadImages\\"
				+ qrcodeResultBean.getTicket().replace('\\', 'x').replace('/', 'x').replace(':', 'x').replace('*', 'x').replace('?', 'x').replace('\"', 'x')
						.replace('<', 'x').replace('>', 'x').replace('|', 'x').replace('\"', 'x') + ".jpg";

		File downloadFile = null;
		try {
			downloadFile = qrcodeAbility.getQrcodeImage(qrcodeResultBean.getTicket());
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(downloadFile);

		System.out.println("Origin file: " + downloadFile.getAbsolutePath());

		File saveAsFile = new File(saveAsFileName);
		downloadFile.renameTo(saveAsFile);

		System.out.println("Save as file: " + saveAsFile.getAbsolutePath());
	}
}
