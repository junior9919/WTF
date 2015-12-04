/**
 * 
 */
package com.halo.wechat.capabilities.abilities;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.ResultBean;
import com.halo.wechat.capabilities.beans.UserInfoBean;
import com.halo.wechat.capabilities.beans.UserListBean;

/**
 * 用户管理相关接口，包括：<br>
 * 用户分组管理、设置用户备注名、获取用户基本信息、获取用户列表、获取用户地理位置、网页授权获取用户基本信息
 * 
 * @author zyl
 *
 */
public interface UserManagementAbility {

	/**
	 * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID组成。<br>
	 * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
	 * 
	 * @param String
	 *            nextOpenId 第一个拉取的OPENID，为null时默认从头开始拉取
	 * @return UserListBean 关注者列表数据
	 * @throws CapabilityException
	 */
	public UserListBean getUserList(String nextOpenId) throws CapabilityException;

	/**
	 * 开发者可以通过该接口对指定用户设置备注名，该接口暂时开放给微信认证的服务号。
	 * 
	 * @param String
	 *            openId 用户标识
	 * @param String
	 *            remark 新的备注名，长度必须小于30字符
	 * @return 微信公众平台接口调用返回码和详细说明
	 */
	public ResultBean updateRemark(String openId, String remark) throws CapabilityException;

	/**
	 * 公众号可通过本接口来根据OpenID获取用户基本信息，包括昵称、头像、性别、所在城市、语言和关注时间。
	 * 
	 * @param String
	 *            openId 普通用户的标识，对当前公众号唯一
	 * @param String
	 *            lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return 获取用户基本信息接口返回的用户信息，错误时微信会返回错误码等信息
	 */
	public UserInfoBean getUserInfo(String openId, String lang) throws CapabilityException;

}
