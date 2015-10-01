package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.halo.wechat.mvc.controllers.ControllerException;
import com.halo.wechat.mvc.controllers.WeChatMessageController;

@RunWith(Parameterized.class)
public class WeChatMessageControllerTest extends BaseTest {

	private WeChatMessageController controller;

	private String msg;

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{
						"msg",
						"<xml>" + "<ToUserName><![CDATA[toUser]]></ToUserName>" + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
								+ "<CreateTime>1348831860</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
								+ "<Content><![CDATA[this is a test]]></Content>" + "<MsgId>1234567890123456</MsgId>" + "</xml>" },
				{
						"msg",
						"<xml>" + "<ToUserName><![CDATA[toUser]]></ToUserName>" + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
								+ "<CreateTime>1348831860</CreateTime>" + "<MsgType><![CDATA[image]]></MsgType>" + "<PicUrl><![CDATA[this is a url]]></PicUrl>"
								+ "<MediaId><![CDATA[media_id]]></MediaId>" + "<MsgId>1234567890123456</MsgId>" + "</xml>" }, { "msg", "" }, { "msg", null } });
	}

	public WeChatMessageControllerTest(String name, String msg) {
		this.msg = msg;
	}

	@Before
	public void setUp() throws Exception {
		controller = applicationServletContext.getBean(WeChatMessageController.class);
	}

	@Test
	public void testHandleRequest() {
		IMocksControl control = EasyMock.createControl();
		HttpServletRequest request = control.createMock(HttpServletRequest.class);
		HttpServletResponse response = control.createMock(HttpServletResponse.class);

		EasyMock.expect(request.getRemoteHost()).andReturn("192.168.0.4");
		EasyMock.expect(request.getParameter("msg")).andReturn(msg).times(0, 1);
		Cookie[] cookies = new Cookie[] { new Cookie("accessTokenCookie", "") };
		EasyMock.expect(request.getCookies()).andReturn(cookies);
		response.addCookie(new Cookie("accessTokenCookie", ""));
		EasyMock.expectLastCall().times(0, 1);
		PrintWriter writer;
		try {
			writer = new PrintWriter("");
			EasyMock.expect(response.getWriter()).andReturn(writer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		control.replay();

		try {
			controller.handleRequest(request, response);
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		control.verify();
	}

}
