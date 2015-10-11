/**
 * 
 */
package com.halo.wechat.xml.utils.converters;

import org.w3c.dom.Node;

import com.halo.wechat.messages.NewsMessage;
import com.halo.wechat.xml.utils.XmlConvertException;

/**
 * @author Junior
 * @date 2015年10月10日 下午9:35:18
 * @version 1.0
 * @since
 * @see
 */
public class ArticlesConverter extends NodeConverter {

	@Override
	public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
		return null;
	}

	@Override
	public String reverse(Object obj) throws XmlConvertException {
		if (obj instanceof NewsMessage.Articles) {
			String xml = "";
			NewsMessage.Articles articles = (NewsMessage.Articles) obj;
			for (NewsMessage.Item item : articles.getItems()) {
				xml += "\t<item>\r\n";
				xml += "\t\t<Title><![CDATA[" + item.getTitle() + "]]></Title>\r\n";
				xml += "\t\t<Description><![CDATA[" + item.getDescription() + "]]></Description>\r\n";
				xml += "\t\t<PicUrl><![CDATA[" + item.getPicUrl() + "]]></PicUrl>\r\n";
				xml += "\t\t<Url><![CDATA[" + item.getUrl() + "]]></Url>\r\n";
				xml += "\t</item>\r\n";
			}
			return xml;
		} else {
			if (null != this.getNextConverter()) {
				return this.getNextConverter().reverse(obj);
			} else {
				return "";
			}
		}
	}

}
