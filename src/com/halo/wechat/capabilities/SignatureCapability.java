package com.halo.wechat.capabilities;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halo.wechat.capabilities.abilities.SignatureAbility;

/**
 * 验证服务器地址的有效性，开发者第一次在微信公众平台上提交服务器地址配置信息后，微信服务器将发送GET请求到填写的服务器地址URL上，GET请求携带四个参数
 * ：<br>
 * signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。<br>
 * timestamp 时间戳<br>
 * nonce 随机数<br>
 * echostr 随机字符串<br>
 * 开发者通过检验signature对请求进行校验,校验方式详见微信公众平台开发者文档--接入指南<br>
 * 本类提供了检验signature的方法，微信开发框架会在用户第一次接入微信公众平台时调用本类的方法。用户也可以在自己的项目中实例化本类并调用检验方法。
 * 
 * @author Junior
 * @date 2015年9月4日 下午8:48:24
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class SignatureCapability extends AbstractCapability implements SignatureAbility {

	private final String TOKEN = "token";

	private String sha1Encode(String origin) throws CapabilityException {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
			digest.update(origin.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new CapabilityException("Encode error: " + e.getMessage());
		}
	}

	private String getSignatureParameter(HttpServletRequest request, String signatureParameterName) throws CapabilityException {
		String signatureParameterValue = request.getParameter(signatureParameterName);
		if (null == signatureParameterValue) {
			throw new CapabilityException("Missing " + signatureParameterName + " parameter in request, perhaps request isn't come from wechat server.");
		}
		return signatureParameterValue;
	}

	private String encodeParameters(String token, String timestamp, String nonce) throws CapabilityException {
		List<String> checkParameters = new ArrayList<String>();
		checkParameters.add(token);
		checkParameters.add(timestamp);
		checkParameters.add(nonce);
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(checkParameters, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		return sha1Encode(checkParameters.get(0) + checkParameters.get(1) + checkParameters.get(2));
	}

	private boolean compareSignature(String orginSignature, String compareToSignature, String echoStr, HttpServletResponse response) throws CapabilityException {
		if (orginSignature.equals(compareToSignature)) {
			try {
				response.getWriter().write(echoStr);
				return true;
			} catch (IOException e) {
				throw new CapabilityException("Write response echostr error: " + e.getMessage());
			}
		} else {
			return false;
		}
	}

	/**
	 * 无参构造方法，会自动调用AbstractCapability的无参构造方法，初始化"wechat.properties"配置文件。<br>
	 * 如果配置文件不存在或非法格式， 构造方法抛出CapabilityException异常
	 * 
	 * @throws CapabilityException
	 *             加载"wechat.properties"配置文件失败抛出的异常
	 */
	public SignatureCapability() throws CapabilityException {

	}

	/**
	 * 从参数文件中获取用户设置的Token（对signature加密的密钥，详见微信公众平台开发者文档--接入指南）
	 * 
	 * @return 用户设置的Token
	 * @throws CapabilityException
	 *             token参数在配置文件中不存在，或未设置值。
	 */
	public String getToken() throws CapabilityException {
		return getProperty(TOKEN);
	}

	/**
	 * 开发者通过检验signature对请求进行校验。若确认此次GET请求来自微信服务器，原样返回echostr参数内容。<br>
	 * 则接入生效，成为开发者成功，否则接入失败。
	 * 
	 * @param request
	 *            HttpServletRequest对象，从中获取微信公众平台发来的signature等参数
	 * @param response
	 *            HttpServletResponse对象，通过该对象向微信公众平台回复校验结果
	 * @return boolean 校验通过返回true，否则返回false
	 * @throws CapabilityException
	 *             获取参数失败，加密签名失败，校验失败都会抛出该异常
	 */
	@Override
	public boolean checkSignature(HttpServletRequest request, HttpServletResponse response) throws CapabilityException {
		String signature = getSignatureParameter(request, "signature");
		String timestamp = getSignatureParameter(request, "timestamp");
		String nonce = getSignatureParameter(request, "nonce");
		String echoStr = getSignatureParameter(request, "echostr");
		String token = getToken();

		String compareToSignature = encodeParameters(token, timestamp, nonce);

		return compareSignature(signature, compareToSignature, echoStr, response);
	}

}
