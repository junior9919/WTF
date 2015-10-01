/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 申请创建带参数的二维码的请求Bean，该类可以通过JSONUtils工具类与json字符串互相转换
 * 
 * @author Junior
 * @date 2015年9月20日 下午4:05:57
 * @version 1.0
 * @since
 * @see
 */
public class QrcodeBean {

	/**
	 * 这是一个成员内部类，其中定义了场景值参数。该类的对象需要用QrcodeBean的实例的new方法来创建，请看以下的例子：<br>
	 * QrcodeBean qrcode = new QrcodeBean(); <br>
	 * Scene scene = qrcode.new Scene();
	 * 
	 * @author Junior
	 * @date 2015年9月28日 下午10:20:31
	 * @version 1.0
	 * @since
	 * @see
	 */
	public class Scene {

		private int scene_id;

		private String scene_str;

		/**
		 * @return int 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000
		 */
		public int getScene_id() {
			return scene_id;
		}

		/**
		 * @param scene_id
		 *            int 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--
		 *            100000
		 */
		public void setScene_id(int scene_id) {
			this.scene_id = scene_id;
		}

		/**
		 * @return 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
		 */
		public String getScene_str() {
			return scene_str;
		}

		/**
		 * @param scene_str
		 *            场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
		 */
		public void setScene_str(String scene_str) {
			this.scene_str = scene_str;
		}

	}

	/**
	 * 这是一个成员内部类，定义了二维码详细信息。该类的对象需要用QrcodeBean的实例的new方法来创建，请看以下的例子：<br>
	 * QrcodeBean qrcode = new QrcodeBean();<br>
	 * ActionInfo actionInfo = qrcode.new ActionInfo();
	 * 
	 * @author Junior
	 * @date 2015年9月28日 下午10:21:16
	 * @version 1.0
	 * @since
	 * @see
	 */
	public class ActionInfo {

		private Scene scene;

		/**
		 * @return 二维码场景值，设置scene_id和scene_str
		 */
		public Scene getScene() {
			return scene;
		}

		/**
		 * @param scene
		 *            二维码场景值，设置scene_id和scene_str
		 */
		public void setScene(Scene scene) {
			this.scene = scene;
		}

	}

	private int expire_seconds;

	private String action_name;

	private ActionInfo action_info;

	/**
	 * 二维码类型，临时
	 */
	public final static String QR_SCENE = "QR_SCENE";

	/**
	 * 二维码类型，永久
	 */
	public final static String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";

	/**
	 * 二维码类型，永久的字符串参数值
	 */
	public final static String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";

	/**
	 * @return int 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
	 */
	public int getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @param expire_seconds
	 *            int 该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
	 */
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	/**
	 * @return 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	public String getAction_name() {
		return action_name;
	}

	/**
	 * @param action_name
	 *            二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,
	 *            QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	/**
	 * @return 二维码详细信息
	 */
	public ActionInfo getAction_info() {
		return action_info;
	}

	/**
	 * @param action_info
	 *            二维码详细信息
	 */
	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}

}
