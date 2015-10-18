/**
 * 
 */
package com.halo.wechat.capabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.MaterialAbility;
import com.halo.wechat.capabilities.beans.MaterialCountBean;
import com.halo.wechat.capabilities.beans.MaterialListBean;
import com.halo.wechat.capabilities.beans.MaterialResultBean;

/**
 * 公众号经常有需要用到一些临时性的多媒体素材的场景，例如在使用接口特别是发送消息时，对多媒体文件、多媒体消息的获取和调用等操作，
 * 是通过media_id来进行的。<br>
 * 素材管理接口对所有认证的订阅号和服务号开放（注：自定义菜单接口和素材管理接口向第三方平台旗下未认证订阅号开放）。<br>
 * 通过本接口，公众号可以管理临时和永久素材。
 * 
 * @author Junior
 * @date 2015年10月15日 下午9:58:07
 * @version 1.0
 * @since
 * @see
 */
public class MaterialCapability extends AccessSupportCapability implements MaterialAbility {

	public class BatchGetCondition {

		private String type;

		private short offset;

		private short count;

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the offset
		 */
		public short getOffset() {
			return offset;
		}

		/**
		 * @param offset
		 *            the offset to set
		 */
		public void setOffset(short offset) {
			this.offset = offset;
		}

		/**
		 * @return the count
		 */
		public short getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(short count) {
			this.count = count;
		}

		public BatchGetCondition(String type, short offset, short count) {
			this.type = type;
			this.offset = offset;
			this.count = count;
		}

	}

	public class MediaIdBean {

		private String media_id;

		/**
		 * @return 要获取的素材的media_id
		 */
		public String getMedia_id() {
			return media_id;
		}

		/**
		 * @param media_id
		 *            要获取的素材的media_id
		 */
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		public MediaIdBean(String media_id) {
			this.media_id = media_id;
		}

	}

	private final String GET_MATERIAL_COUNT_URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount";

	private final String BATCH_GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";

	private final String GET_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/get";

	private final String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public MaterialCapability() throws CapabilityException {

	}

	/**
	 * 获取永久素材的总数<br>
	 * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材<br>
	 * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
	 * 
	 * @return MaterialCountBean
	 * @throws CapabilityException
	 */
	@Override
	public MaterialCountBean getMaterialCount() throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("access_token", retrieveAccessToken().getAccess_token());

		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(GET_MATERIAL_COUNT_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get material count. ");
		}

		return getJsonBean(new JSONUtils<MaterialCountBean>(MaterialCountBean.class), resultStr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.halo.wechat.capabilities.abilities.MaterialAbility#batchGetMaterial
	 * (java.lang.String, short, short)
	 */
	@Override
	public MaterialListBean batchGetMaterial(String type, short offset, short count) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("access_token", retrieveAccessToken().getAccess_token());

		BatchGetCondition batchGetCondition = new BatchGetCondition(type, offset, count);
		String jsonStr = getJsonStr(new JSONUtils<BatchGetCondition>(BatchGetCondition.class), batchGetCondition);
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().post(BATCH_GET_MATERIAL_URL, args, jsonStr, JSON_CONTENT_TYPE);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Batch get material error. ");
		}

		return getJsonBean(new JSONUtils<MaterialListBean>(MaterialListBean.class), resultStr);
	}

	/**
	 * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件）。请注意，视频文件不支持https下载，调用该接口需http协议。
	 * 
	 * @param mediaIdBean
	 *            媒体文件ID
	 * @return 下载的媒体文件（File），可以用renameTo方法将文件另存到指定的位置。
	 * @throws CapabilityException
	 */
	@Override
	public File getMedia(String mediaId) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("access_token", retrieveAccessToken().getAccess_token());
		args.put("media_id", mediaId);

		File mediaFile = null;
		try {
			mediaFile = this.getHttpTemplate().download(GET_MEDIA_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get media file error.");
		}
		return mediaFile;
	}

	/**
	 * 
	 * 在新增了永久素材后，开发者可以根据media_id来获取永久素材，需要时也可保存到本地。 <br>
	 * 请注意：<br>
	 * 1、获取永久素材也可以获取公众号在公众平台官网素材管理模块中新建的图文消息、图片、语音、视频等素材<br>
	 * （但需要先通过获取素材列表来获知素材的media_id）<br>
	 * 2、临时素材无法通过本接口获取 3、调用该接口需https协议
	 * 
	 * @param mediaId
	 *            媒体文件ID
	 * @return 下载的媒体文件（File），可以用renameTo方法将文件另存到指定的位置。
	 * @throws CapabilityException
	 */
	@Override
	public MaterialResultBean getMaterial(String mediaId) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("access_token", retrieveAccessToken().getAccess_token());

		MediaIdBean mediadBean = new MediaIdBean(mediaId);
		String jsonStr = getJsonStr(new JSONUtils<MediaIdBean>(MediaIdBean.class), mediadBean);
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().post(GET_MATERIAL_URL, args, jsonStr, JSON_CONTENT_TYPE);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get material error. ");
		}

		return getJsonBean(new JSONUtils<MaterialResultBean>(MaterialResultBean.class), resultStr);
	}

	/**
	 * 
	 * 除图文、视频以外其他类型的素材消息，则响应的直接为素材的内容，开发者可以自行保存为文件。
	 * 
	 * @param mediaId
	 *            媒体文件ID
	 * @return 下载的媒体文件（File），可以用renameTo方法将文件另存到指定的位置。
	 * @throws CapabilityException
	 */
	@Override
	public File downloadMaterial(String mediaId) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("access_token", retrieveAccessToken().getAccess_token());

		MediaIdBean mediadBean = new MediaIdBean(mediaId);
		String jsonStr = getJsonStr(new JSONUtils<MediaIdBean>(MediaIdBean.class), mediadBean);
		File materialFile = null;
		try {
			materialFile = this.getHttpTemplate().downloadUsePost(GET_MATERIAL_URL, args, jsonStr, JSON_CONTENT_TYPE);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get material error. ");
		}

		return materialFile;
	}

}
