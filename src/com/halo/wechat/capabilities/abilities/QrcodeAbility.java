/**
 * 
 */
package com.halo.wechat.capabilities.abilities;

import java.io.File;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.QrcodeResultBean;

/**
 * 为了满足用户渠道推广分析的需要，公众平台提供了生成带参数二维码的接口。<br>
 * 使用该接口可以获得多个带不同场景值的二维码，用户扫描后，公众号可以接收到事件推送。 目前有2种类型的二维码： <br>
 * 1、临时二维码，是有过期时间的，最长可以设置为在二维码生成后的7天（即604800秒）后过期，但能够生成较多数量。
 * 临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景。<br>
 * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
 * 
 * @author Junior
 * @date 2015年9月20日 下午9:12:09
 * @version 1.0
 * @since
 * @see
 */
public interface QrcodeAbility {

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
	 */
	public QrcodeResultBean getTemporaryQrcode(int expireSeconds, int sceneId) throws CapabilityException;

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
	 */
	public QrcodeResultBean getPermanentQrcode(int sceneId) throws CapabilityException;

	/**
	 * 永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
	 * 
	 * @param sceneStr
	 *            场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
	 * @return QrcodeResultBean
	 *         Json返回结果转换成对象，正确的结果errcode为0，可以通过ticket、expire_seconds
	 *         、url取得返回的内容。<br>
	 *         错误的返回结果通过errcode和errmsg获得错误码和错误说明。
	 * @throws CapabilityException
	 */
	public QrcodeResultBean getPermanentQrcode(String sceneStr) throws CapabilityException;

	/**
	 * 获取二维码ticket后，开发者可用ticket换取二维码图片。
	 * 
	 * @param ticket
	 *            获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 * @return File 下载的二维码图片文件，文件默认保存在web根目录中。<br>
	 *         建议用File.renameTo(File file)方法将文件另存到开发者指定的目录。
	 * @throws CapabilityException
	 */
	public File getQrcodeImage(String ticket) throws CapabilityException;

}
