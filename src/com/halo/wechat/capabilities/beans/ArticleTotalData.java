/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取图文群发总数据接口的返回数据
 * 
 * @author zyl
 * @date 2016年1月2日 下午7:07:03
 * @version
 * @since
 */
public class ArticleTotalData {

	private String ref_date;

	private String msgid;

	private String title;

	private ArticleTotalDetail[] details;

	/**
	 * @return String 数据的日期
	 */
	public String getRef_date() {
		return ref_date;
	}

	/**
	 * @param String
	 *            ref_date 数据的日期
	 */
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	/**
	 * @return String
	 *         请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（
	 *         消息次序索引）组成，<br>
	 *         例如12003_3， 其中12003是msgid，即一次群发的消息的id；
	 *         3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	public String getMsgid() {
		return msgid;
	}

	/**
	 * @param String
	 *            msgid
	 *            请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index
	 *            （消息次序索引）组成，<br>
	 *            例如12003_3， 其中12003是msgid，即一次群发的消息的id；
	 *            3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	/**
	 * @return String 图文消息的标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param String
	 *            title 图文消息的标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return ArticleTotalDatail[] details中，每天对应的数值为该文章到该日为止的总量（而不是当日的量）
	 */
	public ArticleTotalDetail[] getDetails() {
		return details;
	}

	/**
	 * @param ArticleTotalDatail[]
	 *            details details中，每天对应的数值为该文章到该日为止的总量（而不是当日的量）
	 */
	public void setDetails(ArticleTotalDetail[] details) {
		this.details = details;
	}

}
