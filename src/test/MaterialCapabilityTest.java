/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.File;
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
import com.halo.wechat.capabilities.abilities.MaterialAbility;
import com.halo.wechat.capabilities.beans.MaterialCountBean;
import com.halo.wechat.capabilities.beans.MaterialListBean;
import com.halo.wechat.capabilities.beans.NewsItem;

/**
 * @author Junior
 * @date 2015年10月24日 上午11:24:56
 * @version 1.0
 * @since
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:com/halo/wechat/config/applicationContext-wechat.xml",
		"classpath:com/halo/wechat/config/applicationContext-servlet.xml" })
public class MaterialCapabilityTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MaterialAbility materialAbility;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SpringUtils.setWebApplicationContext(webApplicationContext);
	}

	@Test
	public void testGetMaterial() throws Exception {
		short materialCount = 5;

		MaterialCountBean materialCountBean = null;
		try {
			materialCountBean = materialAbility.getMaterialCount();
		} catch (CapabilityException e) {
			throw new Exception("Get material count error.");
		}

		assertNotNull(materialCountBean);

		System.out.println("Images: " + String.valueOf(materialCountBean.getImage_count()) + "\r\n" + "News: "
				+ String.valueOf(materialCountBean.getNews_count()) + "\r\n" + "Videos: " + String.valueOf(materialCountBean.getVideo_count()) + "\r\n"
				+ "Voices: " + String.valueOf(materialCountBean.getVoice_count()));

		short count = materialCountBean.getNews_count() > materialCount ? materialCount : materialCountBean.getNews_count();
		short offset = (short) (materialCountBean.getNews_count() > materialCount ? materialCountBean.getNews_count() - materialCount : 0);

		if (0 == count) {
			return;
		}

		MaterialListBean materialListBean = null;
		try {
			materialListBean = materialAbility.batchGetMaterial(MaterialAbility.MATERIAL_TYPE_NEWS, offset, count);
		} catch (CapabilityException e) {
			throw new Exception("Batch get material error.");
		}

		assertNotNull(materialListBean);

		String savedRecord = "共下载" + String.valueOf(count) + "条素材\r\n";
		for (MaterialListBean.Item item : materialListBean.getItem()) {
			for (NewsItem newsItem : item.getContent().getNews_item()) {
				File bigPicFile;
				try {
					bigPicFile = materialAbility.downloadMaterial(newsItem.getThumb_media_id());
				} catch (CapabilityException e) {
					throw new Exception("Download cover picture error.");
				}
				String saveAsPath = SpringUtils.getWebApplicationContext().getServletContext().getRealPath("/");
				String saveAsFileName = newsItem.getThumb_media_id() + ".jpg";
				File saveAsFile = new File(saveAsPath + File.separator + saveAsFileName);
				bigPicFile.renameTo(saveAsFile);

				String bigPicUrl = "http://115.159.67.204/WeChat/" + saveAsFileName;

				savedRecord += newsItem.getTitle() + "\r\n";
				savedRecord += bigPicUrl + "\r\n";
				savedRecord += newsItem.getUrl() + "\r\n";
			}
		}

		System.out.println(savedRecord);
	}

}
