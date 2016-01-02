/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取图文群发总数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:22:43
 * @version
 * @since
 */
public class ArticleTotalBean extends ResultBean {

	private ArticleTotalData[] list;

	/**
	 * @return ArticleTotalData[] 在begin_date和end_date之间的群发文章的数据
	 */
	public ArticleTotalData[] getList() {
		return list;
	}

	/**
	 * @param ArticleTotalData[]
	 *            list 在begin_date和end_date之间的群发文章的数据
	 */
	public void setList(ArticleTotalData[] list) {
		this.list = list;
	}

}
