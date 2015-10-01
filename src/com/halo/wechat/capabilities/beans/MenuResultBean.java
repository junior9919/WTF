package com.halo.wechat.capabilities.beans;

/**
 * 菜单查询接口返回的菜单结构必须用本类保存，因为菜单查询接口返回的json字符串结构跟菜单创建接口的json结构不同。<br>
 * 可以通过JSONUtils工具类从json字符串转换得到该类的对象。
 * 
 * @author Junior
 * @date 2015年9月10日 下午10:12:35
 * @version 1.0
 * @since Wechat Framework 1.0
 * @see JSONUtils\
 * @see MenuBean
 */
public class MenuResultBean extends ResultBean {

	private MenuBean menu;

	/**
	 * @return 实际上该属性中保存的就是MenuBean对象
	 */
	public MenuBean getMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            实际上该属性中保存的就是MenuBean对象
	 */
	public void setMenu(MenuBean menu) {
		this.menu = menu;
	}

}
