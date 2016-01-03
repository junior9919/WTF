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
import com.halo.wechat.capabilities.abilities.ArticleAnalysisAbility;
import com.halo.wechat.capabilities.beans.AnalysisBean;
import com.halo.wechat.capabilities.beans.ArticleSummaryBean;
import com.halo.wechat.capabilities.beans.ArticleSummaryData;
import com.halo.wechat.capabilities.beans.ArticleTotalBean;
import com.halo.wechat.capabilities.beans.ArticleTotalData;
import com.halo.wechat.capabilities.beans.ArticleTotalDetail;
import com.halo.wechat.capabilities.beans.UserReadBean;
import com.halo.wechat.capabilities.beans.UserReadData;
import com.halo.wechat.capabilities.beans.UserReadHourBean;
import com.halo.wechat.capabilities.beans.UserReadHourData;
import com.halo.wechat.capabilities.beans.UserShareBean;
import com.halo.wechat.capabilities.beans.UserShareData;
import com.halo.wechat.capabilities.beans.UserShareHourBean;
import com.halo.wechat.capabilities.beans.UserShareHourData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class ArticleAnalysisCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ArticleAnalysisAbility articleAnalysisAbility;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	@Test
	public void testGetArticleSummary() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2016-01-02");
		analysisBean.setEnd_date("2016-01-02");

		ArticleSummaryBean articleSummaryBean = null;

		try {
			articleSummaryBean = articleAnalysisAbility.getArticleSummary(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(articleSummaryBean);

		if (0 == articleSummaryBean.getErrcode()) {
			for (int i = 0; i < articleSummaryBean.getList().length; i++) {
				ArticleSummaryData articleSummaryData = articleSummaryBean.getList()[i];

				System.out.print("ref_date = " + articleSummaryData.getRef_date());
				System.out.print(" | msgid = " + articleSummaryData.getMsgid());
				System.out.print(" | title = " + articleSummaryData.getTitle());
				System.out.print(" | int_page_read_user = " + articleSummaryData.getInt_page_read_user());
				System.out.print(" | int_page_read_count = " + articleSummaryData.getInt_page_read_count());
				System.out.print(" | ori_page_read_user = " + articleSummaryData.getOri_page_read_user());
				System.out.print(" | ori_page_read_count = " + articleSummaryData.getOri_page_read_count());
				System.out.print(" | share_user = " + articleSummaryData.getShare_user());
				System.out.print(" | share_count = " + articleSummaryData.getShare_count());
				System.out.print(" | add_to_fav_user = " + articleSummaryData.getAdd_to_fav_user());
				System.out.println(" | add_to_fav_count = " + articleSummaryData.getAdd_to_fav_count());
			}
		} else {
			System.out.println("errcode = " + articleSummaryBean.getErrcode());
			System.out.println("errmsg = " + articleSummaryBean.getErrmsg());
		}
	}

	@Test
	public void testGetArticleTotal() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2016-01-02");
		analysisBean.setEnd_date("2016-01-02");

		ArticleTotalBean articleTotalBean = null;

		try {
			articleTotalBean = articleAnalysisAbility.getArticleTotal(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(articleTotalBean);

		if (0 == articleTotalBean.getErrcode()) {
			for (int i = 0; i < articleTotalBean.getList().length; i++) {
				ArticleTotalData articleTotalData = articleTotalBean.getList()[i];

				System.out.print("ref_date = " + articleTotalData.getRef_date());
				System.out.print(" | msgid = " + articleTotalData.getMsgid());
				System.out.println(" | title = " + articleTotalData.getTitle());
				for (int j = 0; j < articleTotalData.getDetails().length; j++) {
					ArticleTotalDetail articleTotalDetail = articleTotalData.getDetails()[j];
					System.out.print(" | stat_date = " + articleTotalDetail.getStat_date());
					System.out.print(" | target_user = " + articleTotalDetail.getTarget_user());
					System.out.print(" | int_page_read_user = " + articleTotalDetail.getInt_page_read_user());
					System.out.print(" | int_page_read_count = " + articleTotalDetail.getInt_page_read_count());
					System.out.print(" | ori_page_read_user = " + articleTotalDetail.getOri_page_read_user());
					System.out.print(" | ori_page_read_count = " + articleTotalDetail.getOri_page_read_count());
					System.out.print(" | share_user = " + articleTotalDetail.getShare_user());
					System.out.print(" | share_count = " + articleTotalDetail.getShare_count());
					System.out.print(" | add_to_fav_user = " + articleTotalDetail.getAdd_to_fav_user());
					System.out.println(" | add_to_fav_count = " + articleTotalDetail.getAdd_to_fav_count());
				}
			}
		} else {
			System.out.println("errcode = " + articleTotalBean.getErrcode());
			System.out.println("errmsg = " + articleTotalBean.getErrmsg());
		}
	}

	@Test
	public void testGetUserRead() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2016-01-02");
		analysisBean.setEnd_date("2016-01-02");

		UserReadBean userReadBean = null;
		try {
			userReadBean = articleAnalysisAbility.getUserRead(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(userReadBean);

		if (0 == userReadBean.getErrcode()) {
			for (int i = 0; i < userReadBean.getList().length; i++) {
				UserReadData userReadData = userReadBean.getList()[i];

				System.out.print("ref_date = " + userReadData.getRef_date());
				System.out.print(" | int_page_read_user = " + userReadData.getInt_page_read_user());
				System.out.print(" | int_page_read_count = " + userReadData.getInt_page_read_count());
				System.out.print(" | ori_page_read_user = " + userReadData.getOri_page_read_user());
				System.out.print(" | ori_page_read_count = " + userReadData.getOri_page_read_count());
				System.out.print(" | share_user = " + userReadData.getShare_user());
				System.out.print(" | share_count = " + userReadData.getShare_count());
				System.out.print(" | add_to_fav_user = " + userReadData.getAdd_to_fav_user());
				System.out.println(" | add_to_fav_count = " + userReadData.getAdd_to_fav_count());
			}
		} else {
			System.out.println("errcode = " + userReadBean.getErrcode());
			System.out.println("errmsg = " + userReadBean.getErrmsg());
		}
	}

	@Test
	public void testGetUserReadHour() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2016-01-02");
		analysisBean.setEnd_date("2016-01-02");

		UserReadHourBean userReadHourBean = null;
		try {
			userReadHourBean = articleAnalysisAbility.getUserReadHour(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(userReadHourBean);

		if (0 == userReadHourBean.getErrcode()) {
			for (int i = 0; i < userReadHourBean.getList().length; i++) {
				UserReadHourData userReadHourData = userReadHourBean.getList()[i];

				System.out.print("ref_date = " + userReadHourData.getRef_date());
				System.out.print(" | ref_hour = " + userReadHourData.getRef_hour());
				System.out.print(" | int_page_read_user = " + userReadHourData.getInt_page_read_user());
				System.out.print(" | int_page_read_count = " + userReadHourData.getInt_page_read_count());
				System.out.print(" | ori_page_read_user = " + userReadHourData.getOri_page_read_user());
				System.out.print(" | ori_page_read_count = " + userReadHourData.getOri_page_read_count());
				System.out.print(" | share_user = " + userReadHourData.getShare_user());
				System.out.print(" | share_count = " + userReadHourData.getShare_count());
				System.out.print(" | add_to_fav_user = " + userReadHourData.getAdd_to_fav_user());
				System.out.println(" | add_to_fav_count = " + userReadHourData.getAdd_to_fav_count());
			}
		} else {
			System.out.println("errcode = " + userReadHourBean.getErrcode());
			System.out.println("errmsg = " + userReadHourBean.getErrmsg());
		}
	}

	@Test
	public void testGetUserShare() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-12-27");
		analysisBean.setEnd_date("2015-12-27");

		UserShareBean userShareBean = null;
		try {
			userShareBean = articleAnalysisAbility.getUserShare(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(userShareBean);

		if (0 == userShareBean.getErrcode()) {
			for (int i = 0; i < userShareBean.getList().length; i++) {
				UserShareData userShareData = userShareBean.getList()[i];

				System.out.print("ref_date = " + userShareData.getRef_date());
				System.out.print(" | share_scene = " + userShareData.getShare_scene());
				System.out.print(" | share_user = " + userShareData.getShare_user());
				System.out.println(" | share_count = " + userShareData.getShare_count());
			}
		} else {
			System.out.println("errcode = " + userShareBean.getErrcode());
			System.out.println("errmsg = " + userShareBean.getErrmsg());
		}
	}

	@Test
	public void testGetUserShareHour() {
		AnalysisBean analysisBean = new AnalysisBean();
		analysisBean.setBegin_date("2015-12-27");
		analysisBean.setEnd_date("2015-12-27");

		UserShareHourBean userShareHourBean = null;
		try {
			userShareHourBean = articleAnalysisAbility.getUserShareHour(analysisBean);
		} catch (CapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(userShareHourBean);

		if (0 == userShareHourBean.getErrcode()) {
			for (int i = 0; i < userShareHourBean.getList().length; i++) {
				UserShareHourData userShareHourData = userShareHourBean.getList()[i];

				System.out.print("ref_date = " + userShareHourData.getRef_date());
				System.out.print(" | ref_hour = " + userShareHourData.getRef_hour());
				System.out.print(" | share_scene = " + userShareHourData.getShare_scene());
				System.out.print(" | share_user = " + userShareHourData.getShare_user());
				System.out.println(" | share_count = " + userShareHourData.getShare_count());
			}
		} else {
			System.out.println("errcode = " + userShareHourBean.getErrcode());
			System.out.println("errmsg = " + userShareHourBean.getErrmsg());
		}
	}

}
