package com.halo.wechat.capabilities.beans;

import java.util.List;

/**
 * 保存开发者准备创建的菜单结构，该类可以通过JSONUtils工具类转换成json字符串。
 * 
 * @author Junior
 * @date 2015年9月10日 下午9:51:42
 * @version 1.0
 * @since Wechat Framework 1.0
 * @see JSONUtils\
 * @see ButtonBean
 */
public class MenuBean {

	/**
	 * 保存用户微信客户端菜单结构中的单个菜单项，该类可以通过JSONUtils工具类转换成json字符串。<br>
	 * 该类是成员内部类，因此需用以下方法来创建对象： MenuBean menuBean = new MenuBean();<br>
	 * ButtonBean buttonBean = menuBean.new ButtonBean();
	 * 
	 * @author Junior
	 * @date 2015年9月10日 下午9:58:42
	 * @version 1.0
	 * @since Wechat Framework 1.0
	 * @see JSONUtils\
	 * @see MenuBean\
	 * @see
	 */
	public class ButtonBean {

		private String type;

		private String name;

		private String key;

		private String url;

		private String media_id;

		private List<ButtonBean> sub_button;

		/**
		 * 菜单类型：点击推事件，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_CLICK = "click";

		/**
		 * 菜单类型：跳转URL，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_VIEW = "view";

		/**
		 * 菜单类型：扫码推事件，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_SCANCODE_PUSH = "scancode_push";

		/**
		 * 菜单类型：扫码推事件且弹出“消息接收中”提示框，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";

		/**
		 * 菜单类型：弹出系统拍照发图，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_PIC_SYSPHOTO = "pic_sysphoto";

		/**
		 * 菜单类型：弹出拍照或者相册发图，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";

		/**
		 * 菜单类型：弹出微信相册发图器，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_PIC_WEIXIN = "pic_weixin";

		/**
		 * 菜单类型：弹出地理位置选择器，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_LOCATION_SELECT = "location_select";

		/**
		 * 菜单类型：下发消息（除文本消息），详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_MEDIA_ID = "media_id";

		/**
		 * 菜单类型：跳转图文消息URL，详见微信公众号开发者文档--自定义菜单创建接口
		 */
		public static final String BUTTON_TYPE_VIEW_LIMITED = "view_limited";

		/**
		 * @return 菜单的响应动作类型，即本类中定义的BUTTON_TYPE_CLICK等常量
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            菜单的响应动作类型，即本类中定义的BUTTON_TYPE_CLICK等常量
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return 菜单标题，不超过16个字节，子菜单不超过40个字节
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            菜单标题，不超过16个字节，子菜单不超过40个字节
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节
		 */
		public String getKey() {
			return key;
		}

		/**
		 * @param key
		 *            click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节
		 */
		public void setKey(String key) {
			this.key = key;
		}

		/**
		 * @return view类型必须，网页链接，用户点击菜单可打开链接，不超过256字节
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @param url
		 *            view类型必须，网页链接，用户点击菜单可打开链接，不超过256字节
		 */
		public void setUrl(String url) {
			this.url = url;
		}

		/**
		 * @return media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id
		 */
		public String getMedia_id() {
			return media_id;
		}

		/**
		 * @param media_id
		 *            media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id
		 */
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		/**
		 * @return 二级菜单数组，个数应为1~5个。当本菜单项已经是二级菜单时，不能再给本属性添加元素，否则微信平台将会报错。
		 */
		public List<ButtonBean> getSub_button() {
			return sub_button;
		}

		/**
		 * @param sub_button
		 *            二级菜单数组，个数应为1~5个。当本菜单项已经是二级菜单时，不能再给本属性添加元素，否则微信平台将会报错。
		 */
		public void setSub_button(List<ButtonBean> sub_button) {
			this.sub_button = sub_button;
		}

	}

	private List<ButtonBean> button;

	/**
	 * @return ButtonBean对象的列表（List），ButtonBean对象保存的是单个菜单项结构
	 * @see ButtonBean
	 */
	public List<ButtonBean> getButton() {
		return button;
	}

	/**
	 * @param button
	 *            ButtonBean对象的列表（List），ButtonBean对象保存的是单个菜单项结构
	 * @see ButtonBean
	 */
	public void setButton(List<ButtonBean> button) {
		this.button = button;
	}

}
