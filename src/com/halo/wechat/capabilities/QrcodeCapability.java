/**
 * 
 */
package com.halo.wechat.capabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.QrcodeAbility;
import com.halo.wechat.capabilities.beans.QrcodeBean;
import com.halo.wechat.capabilities.beans.QrcodeBean.ActionInfo;
import com.halo.wechat.capabilities.beans.QrcodeBean.Scene;
import com.halo.wechat.capabilities.beans.QrcodeResultBean;

/**
 * 为了满足用户渠道推广分析的需要，公众平台提供了生成带参数二维码的接口。<br>
 * 使用该接口可以获得多个带不同场景值的二维码，用户扫描后，公众号可以接收到事件推送。 目前有2种类型的二维码： <br>
 * 1、临时二维码，是有过期时间的，最长可以设置为在二维码生成后的7天（即604800秒）后过期，但能够生成较多数量。
 * 临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景。<br>
 * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
 * 
 * @author Junior
 * @date 2015年9月20日 下午9:43:37
 * @version 1.0
 * @since
 * @see
 */
public class QrcodeCapability extends AccessSupportCapability implements QrcodeAbility {

	private final String GET_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";

	private final String GET_QRCODE_IMAGE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public QrcodeCapability() throws PropertiesException {

	}

	/**
	 * 临时二维码，是有过期时间的，最长可以设置为在二维码生成后的7天（即604800秒）后过期，但能够生成较多数量。<br>
	 * 临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景。
	 * 
	 * @param expireSeconds
	 *            该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
	 * @param sceneId
	 *            场景值ID，临时二维码时为32位非0整型
	 * @return QrcodeResultBean
	 *         Json返回结果转换成对象，正确的结果errcode为0，可以通过ticket、expire_seconds
	 *         、url取得返回的内容。<br>
	 *         错误的返回结果通过errcode和errmsg获得错误码和错误说明。
	 * @throws CapabilityException
	 *             获取保存在WebApplicationContext中的access_token失败，
	 *             或向微信公众平台post请求失败触发该异常。
	 * @see QrcodeResultBean
	 */
	@Override
	public QrcodeResultBean getTemporaryQrcode(int expireSeconds, int sceneId) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		QrcodeBean qrcode = new QrcodeBean();
		qrcode.setExpire_seconds(expireSeconds);
		qrcode.setAction_name(QrcodeBean.QR_SCENE);

		ActionInfo actionInfo = qrcode.new ActionInfo();
		qrcode.setAction_info(actionInfo);

		Scene scene = qrcode.new Scene();
		actionInfo.setScene(scene);

		scene.setScene_id(sceneId);

		QrcodeResultBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_QRCODE_URL, args,
					new JSONUtils<QrcodeBean>(QrcodeBean.class), qrcode,
					new JSONUtils<QrcodeResultBean>(QrcodeResultBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get qrcode failed.", e);
		}
		return resultBean;
	}

	/**
	 * 永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
	 * 
	 * @param sceneId
	 *            场景值ID，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param sceneStr
	 *            场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 * @return QrcodeResultBean
	 *         Json返回结果转换成对象，正确的结果errcode为0，可以通过ticket、expire_seconds
	 *         、url取得返回的内容。<br>
	 *         错误的返回结果通过errcode和errmsg获得错误码和错误说明。
	 * @throws CapabilityException
	 *             获取保存在WebApplicationContext中的access_token失败，
	 *             或向微信公众平台post请求失败触发该异常。
	 * @see QrcodeResultBean
	 */
	@Override
	public QrcodeResultBean getPermanentQrcode(String sceneStr) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		QrcodeBean qrcode = new QrcodeBean();
		qrcode.setAction_name(QrcodeBean.QR_LIMIT_STR_SCENE);

		ActionInfo actionInfo = qrcode.new ActionInfo();
		qrcode.setAction_info(actionInfo);

		Scene scene = qrcode.new Scene();
		actionInfo.setScene(scene);

		scene.setScene_str(sceneStr);

		QrcodeResultBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_QRCODE_URL, args,
					new JSONUtils<QrcodeBean>(QrcodeBean.class), qrcode,
					new JSONUtils<QrcodeResultBean>(QrcodeResultBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get " + QrcodeBean.QR_LIMIT_STR_SCENE + " qrcode failed. ", e);
		}
		return resultBean;
	}

	/**
	 * 永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
	 * 
	 * @param sceneId
	 *            场景值ID，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return QrcodeResultBean
	 *         Json返回结果转换成对象，正确的结果errcode为0，可以通过ticket、expire_seconds
	 *         、url取得返回的内容。<br>
	 *         错误的返回结果通过errcode和errmsg获得错误码和错误说明。
	 * @throws CapabilityException
	 *             获取保存在WebApplicationContext中的access_token失败，
	 *             或向微信公众平台post请求失败触发该异常。
	 * @see QrcodeResultBean
	 */
	@Override
	public QrcodeResultBean getPermanentQrcode(int sceneId) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		putAccessTokenIntoArgs(args);

		QrcodeBean qrcode = new QrcodeBean();
		qrcode.setAction_name(QrcodeBean.QR_LIMIT_SCENE);

		ActionInfo actionInfo = qrcode.new ActionInfo();
		qrcode.setAction_info(actionInfo);

		Scene scene = qrcode.new Scene();
		actionInfo.setScene(scene);

		scene.setScene_id(sceneId);

		QrcodeResultBean resultBean = null;
		try {
			resultBean = this.getHttpTemplate().jsonPost(GET_QRCODE_URL, args,
					new JSONUtils<QrcodeBean>(QrcodeBean.class), qrcode,
					new JSONUtils<QrcodeResultBean>(QrcodeResultBean.class));
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Get " + QrcodeBean.QR_LIMIT_SCENE + " qrcode failed. ", e);
		}
		return resultBean;
	}

	/**
	 * 获取二维码ticket后，开发者可用ticket换取二维码图片。
	 * 
	 * @param ticket
	 *            获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 * @return File 下载的二维码图片文件，文件默认保存在web根目录中。<br>
	 *         建议用File.renameTo(File file)方法将文件另存到开发者指定的目录。
	 * @throws CapabilityException
	 */
	@Override
	public File getQrcodeImage(String ticket) throws CapabilityException {
		Map<String, String> args = new HashMap<String, String>();
		args.put("ticket", ticket);

		File downloadFile = null;
		try {
			downloadFile = this.getHttpTemplate().download(GET_QRCODE_IMAGE_URL, args);
		} catch (HttpUtilsException e) {
			throw new CapabilityException("Download qrcode image error.", e);
		}
		return downloadFile;
	}

}
