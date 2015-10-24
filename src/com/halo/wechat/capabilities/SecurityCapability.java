package com.halo.wechat.capabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;

import com.halo.http.utils.HttpUtilsException;
import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.abilities.SecurityAbility;
import com.halo.wechat.capabilities.beans.ResultBean;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.TextMessage;

/**
 * @author Junior
 * @date 2015年9月12日 下午8:32:19
 * @version 1.0
 * @since Wechat Framework 1.0
 */
public class SecurityCapability extends AbstractCapability implements SecurityAbility {

	private final String CHECK_SUBSCRIBER_URL = "http://115.159.67.204/WeChat/isSubscriber.do";

	private ResultBean resultBean;

	private boolean isSubscriber(String fromUserName, String toUserName) {
		Map<String, String> args = new HashMap<String, String>();
		args.put("from_user_name", fromUserName);
		args.put("to_user_name", toUserName);
		String resultStr = null;
		try {
			resultStr = this.getHttpTemplate().get(CHECK_SUBSCRIBER_URL, args);
		} catch (HttpUtilsException e) {
			return true;
		}

		resultBean = getJsonBean(new JSONUtils<ResultBean>(ResultBean.class), resultStr);

		return null != resultBean ? 1 == resultBean.getErrcode() : false;
	}

	public SecurityCapability() throws PropertiesException {

	}

	@Override
	public void messageSecurityCheck(JoinPoint jp) throws CapabilityException {
		Object[] args = jp.getArgs();
		if (args.length == 2 && null != args[1] && args[1] instanceof Message) {
			Message message = (Message) args[1];
			if (!isSubscriber(message.getFromUserName(), message.getToUserName())) {
				if (jp.getTarget() instanceof MessageCapability) {
					MessageCapability messageCapability = (MessageCapability) jp.getTarget();
					if (args[0] instanceof HttpServletResponse) {
						HttpServletResponse response = (HttpServletResponse) args[0];
						String content = "时间就是金钱，我的朋友！\r\n" + "别怪我啰嗦，开发这款地精科技产品我们可是花了不少时间！\r\n" + "关注我们的微信号吧，保证你再也听不到这些唠叨。\r\n\r\n" + "<a href='"
								+ "http://115.159.67.204/WeChat/images/subscribe_qrcode.jpg'>点击这里关注我们的微信号</a>";
						Random rand = new Random();
						long msgId = rand.nextLong();
						TextMessage responseMessage = new TextMessage(message.getToUserName(), message.getFromUserName(), System.currentTimeMillis(),
								MsgType.TEXT, content, msgId);
						try {
							messageCapability.responseMessage(response, responseMessage);
						} catch (NullSaoException e) {
							throw new CapabilityException("Response message caught an error.", e);
						}
					}
				}
				throw new CapabilityException("User response message canceled.");
			}
		}
	}

}
