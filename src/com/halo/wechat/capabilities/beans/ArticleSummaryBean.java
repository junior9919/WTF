package com.halo.wechat.capabilities.beans;

/**
 * 获取图文群发每日数据接口的返回JSON数据包
 * 
 * @author zyl
 * @date 2016年1月2日 下午6:52:50
 * @version
 * @since
 */
public class ArticleSummaryBean extends ResultBean {

	private ArticleSummaryData[] list;

	/**
	 * @return ArticleSummaryData[] 列出该日期内所有被阅读过的文章（仅包括群发的文章）在当天的阅读次数等数据
	 */
	public ArticleSummaryData[] getList() {
		return list;
	}

	/**
	 * @param ArticleSummaryData[]
	 *            list 列出该日期内所有被阅读过的文章（仅包括群发的文章）在当天的阅读次数等数据
	 */
	public void setList(ArticleSummaryData[] list) {
		this.list = list;
	}

}
