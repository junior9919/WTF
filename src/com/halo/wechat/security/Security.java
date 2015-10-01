/**
 * 
 */
package com.halo.wechat.security;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.MessageCapability;
import com.halo.wechat.messages.BaseMessage;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.TextMessage;

/**
 * @author Junior
 * @date 2015年9月11日 下午9:38:25
 * @version 1.0
 * @since
 * @see
 */
public class Security {

	private boolean isUserASubscriber(String fromUserName) {
		return false;
	}

	public void messageSecurityCheck(JoinPoint jp) throws Exception {
		Object[] args = jp.getArgs();
		if (args.length == 2 && args[1] instanceof BaseMessage) {
			BaseMessage message = (BaseMessage) args[1];
			if (!isUserASubscriber(message.getFromUserName())) {
				if (jp.getTarget() instanceof MessageCapability) {
					MessageCapability messageCapability = (MessageCapability) jp.getTarget();
					if (args[0] instanceof HttpServletResponse) {
						HttpServletResponse response = (HttpServletResponse) args[0];
						String content = "时间就是金钱，我的朋友！\r\n" + "开发这款地精科技产品我们可是花了不少时间！\r\n" + "关注我们的微信号，我保证你就再也听不到这些的唠叨。\r\n\r\n"
								+ "<a href='http://115.159.67.204/Halo/images/subscribe.jpg'>点击这里关注我们的微信号</a>";
						Random rand = new Random();
						long msgId = rand.nextLong();
						TextMessage responseMessage = new TextMessage(message.getToUserName(), message.getFromUserName(), System.currentTimeMillis(),
								MsgType.TEXT, content, msgId);
						try {
							messageCapability.responseMessage(response, responseMessage);
						} catch (CapabilityException e) {

						}
					}
				}
				throw new Exception("User response message canceled.");
			}
		}

	}
}
