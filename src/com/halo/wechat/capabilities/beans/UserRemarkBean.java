package com.halo.wechat.capabilities.beans;

/**
 * 
 * @author zyl
 *
 */
public class UserRemarkBean {

	private String openid;

	private String remark;

	/**
	 * @return String 用户标识
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param String
	 *            openid 用户标识
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return String 新的备注名，长度必须小于30字符
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param String
	 *            remark 新的备注名，长度必须小于30字符
	 * @throws LengthExceedsException
	 */
	public void setRemark(String remark) {
		if (30 < remark.length()) {
			throw new LengthExceedsException("Length of remark exceeds the maximum limit of 30 characters.");
		}
		this.remark = remark;
	}

}
