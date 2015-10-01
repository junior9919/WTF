/**
 * 
 */
package com.user.wechat.mvc.commands;

import java.sql.Timestamp;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.halo.wechat.messages.ClickEvent;
import com.halo.wechat.messages.Event;
import com.halo.wechat.messages.LocationEvent;
import com.halo.wechat.messages.LocationMessage;
import com.halo.wechat.messages.Message;
import com.halo.wechat.messages.MsgType;
import com.halo.wechat.messages.SubscribeEvent;
import com.halo.wechat.messages.TextMessage;
import com.halo.wechat.mvc.commands.Command;
import com.halo.wechat.mvc.commands.CommandException;

/**
 * @file UserCommand.java
 * @author Junior
 * @date 2015年8月9日 上午11:21:44
 * @version 1.0
 */
@Component
public class UserCommand implements Command {

	@Override
	public Message processMessage(Message receiveMessage) throws CommandException {
		Message responseMessage = null;
		System.out.println("Receive a " + receiveMessage.getClass().getSimpleName() + " type " + receiveMessage.getMsgType());

		Random rand = new Random();
		long msgId = rand.nextLong();
		String responseText = "你好啊!";
		if (MsgType.LOCATION.equals(receiveMessage.getMsgType())) {
			LocationMessage locationMsg = (LocationMessage) receiveMessage;
			responseText = "你目前位于东经" + String.valueOf(locationMsg.getLocation_Y()) + "度，北纬" + String.valueOf(locationMsg.getLocation_X()) + "度。地点："
					+ locationMsg.getLabel();
		}

		responseMessage = new TextMessage(receiveMessage.getFromUserName(), receiveMessage.getToUserName(), new Timestamp(System.currentTimeMillis()),
				MsgType.TEXT, responseText, msgId);
		return responseMessage;
	}

	@Override
	public Message processEvent(Event receiveEvent) throws CommandException {
		Message responseMessage = null;
		String responseText = "建设中...";
		if (receiveEvent instanceof ClickEvent) {
			ClickEvent clickEvent = (ClickEvent) receiveEvent;
			if ("tip".equals(clickEvent.getEventKey())) {
				responseText = "<img src='http://115.159.67.204/Halo/images/goblin.jpg' height='80' />" + "时间就是金钱，我的朋友！\r\n" + "我可是货真价实，童叟无欺！\r\n\r\n\r\n"
						+ "<a href='http://115.159.67.204/Halo/images/1.png'>就这几个铜板了，你都拿去，我想静静！</a>\r\n\r\n"
						+ "<a href='http://115.159.67.204/Halo/images/5.png'>这些碎银子拿去，给大爷唱个Java小曲儿</a>\r\n\r\n"
						+ "<a href='http://115.159.67.204/Halo/images/10.png'>说书的，来讲一段儿设计模式。讲的好这些银两都是你的！</a>\r\n\r\n"
						+ "<a href='http://115.159.67.204/Halo/images/100.png'>有本事就把这块奥金锭拿走！</a>";
			}
		} else if (receiveEvent instanceof SubscribeEvent) {
			responseText = "<img src='http://115.159.67.204/Halo/images/goblin.jpg' height='80' />" + "啊，又一个潜在的客户！\r\n"
					+ "请随便逛逛，我们的地精科技产品你用上了吗？觉得好用就打赏几文吧。我们还有更多地精科技正在研发！\r\n\r\n\r\n"
					+ "<a href='http://115.159.67.204/Halo/images/1.png'>就这几个铜板了，你都拿去，我想静静！</a>\r\n\r\n"
					+ "<a href='http://115.159.67.204/Halo/images/5.png'>这些碎银子拿去，给大爷唱个Java小曲儿</a>\r\n\r\n"
					+ "<a href='http://115.159.67.204/Halo/images/10.png'>说书的，来讲一段儿设计模式。讲的好这些银两都是你的！</a>\r\n\r\n"
					+ "<a href='http://115.159.67.204/Halo/images/100.png'>有本事就把这块奥金锭拿走！</a>";
		} else if (receiveEvent instanceof LocationEvent) {
			LocationEvent lctnEvnt = (LocationEvent) receiveEvent;
			responseText = "你目前位于东经" + String.valueOf(lctnEvnt.getLongitude()) + "度，北纬" + String.valueOf(lctnEvnt.getLatitude()) + "度。";
		}

		Random rand = new Random();
		long msgId = rand.nextLong();
		responseMessage = new TextMessage(receiveEvent.getFromUserName(), receiveEvent.getToUserName(), new Timestamp(System.currentTimeMillis()),
				MsgType.TEXT, responseText, msgId);
		return responseMessage;
	}

}
