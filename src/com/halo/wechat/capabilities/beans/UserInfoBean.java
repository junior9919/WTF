/**
 * 
 */
package com.halo.wechat.capabilities.beans;

/**
 * 获取用户基本信息接口返回的用户信息
 * 
 * @author zyl
 *
 */
public class UserInfoBean extends ResultBean {

	private short subscribe;

	private String openid;

	private String nickname;

	private short sex;

	private String language;

	private String city;

	private String province;

	private String country;

	private String headimgurl;

	private long subscribe_time;

	private String unionid;

	private String remark;

	private short groupid;

	/**
	 * @return short 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	public short getSubscribe() {
		return subscribe;
	}

	/**
	 * @param short
	 *            subscribe 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	public void setSubscribe(short subscribe) {
		this.subscribe = subscribe;
	}

	/**
	 * @return String 用户的标识，对当前公众号唯一
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param String
	 *            openid 用户的标识，对当前公众号唯一
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return String 用户的昵称
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param String
	 *            nickname 用户的昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return short 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	public short getSex() {
		return sex;
	}

	/**
	 * @param short
	 *            sex 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	public void setSex(short sex) {
		this.sex = sex;
	}

	/**
	 * @return String 用户的语言，简体中文为zh_CN
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param String
	 *            language 用户的语言，简体中文为zh_CN
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return String 用户所在城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param String
	 *            city 用户所在城市
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return String 用户所在省份
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param String
	 *            province 用户所在省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return String 用户所在国家
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param String
	 *            country 用户所在国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return String 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
	 *         用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * @param String
	 *            headimgurl
	 *            用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
	 *            用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * @return long 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 */
	public long getSubscribe_time() {
		return subscribe_time;
	}

	/**
	 * @param long
	 *            subscribe_time 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 */
	public void setSubscribe_time(long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	/**
	 * @return String 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param String
	 *            unionid 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * @return String 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param String
	 *            remark 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return short 用户所在的分组ID
	 */
	public short getGroupid() {
		return groupid;
	}

	/**
	 * @param short
	 *            groupid 用户所在的分组ID
	 */
	public void setGroupid(short groupid) {
		this.groupid = groupid;
	}

}
