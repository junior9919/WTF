/**
 * 
 */
package com.halo.wechat.capabilities.abilities;

import java.io.File;

import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.beans.MaterialCountBean;
import com.halo.wechat.capabilities.beans.MaterialListBean;
import com.halo.wechat.capabilities.beans.MaterialResultBean;

/**
 * 公众号经常有需要用到一些临时性的多媒体素材的场景，例如在使用接口特别是发送消息时，对多媒体文件、多媒体消息的获取和调用等操作，
 * 是通过media_id来进行的。<br>
 * 素材管理接口对所有认证的订阅号和服务号开放（注：自定义菜单接口和素材管理接口向第三方平台旗下未认证订阅号开放）。<br>
 * 通过本接口，公众号可以管理临时和永久素材。
 * 
 * @author Junior
 * @date 2015年10月15日 下午9:33:04
 * @version 1.0
 * @since
 * @see
 */
public interface MaterialAbility {

	public final static String MATERIAL_TYPE_IMAGE = "image";

	public final static String MATERIAL_TYPE_VIDEO = "video";

	public final static String MATERIAL_TYPE_VOICE = "voice";

	public final static String MATERIAL_TYPE_NEWS = "news";

	/**
	 * 获取永久素材的总数<br>
	 * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材<br>
	 * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
	 * 
	 * @return MaterialCountBean
	 */
	public MaterialCountBean getMaterialCount() throws CapabilityException;

	/**
	 * 在新增了永久素材后，开发者可以分类型获取永久素材的列表。<br>
	 * 1、获取永久素材的列表，也会包含公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材<br>
	 * （但需要先通过获取素材列表来获知素材的media_id）<br>
	 * 2、临时素材无法通过本接口获取
	 * 
	 * @param type
	 *            素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）。<br>
	 *            本接口中定义了这几种类型的常量“MATERIAL_TYPE_IMAGE”、“MATERIAL_TYPE_VIDEO”、<br>
	 *            “MATERIAL_TYPE_VOICE”、“MATERIAL_TYPE_NEWS”
	 * @param offset
	 *            从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count
	 *            返回素材的数量，取值在1到20之间
	 * @return MaterialListBean <br>
	 *         获取的图文、图片或视频素材都通过MaterialListBean的getItem()方法获得，<br>
	 *         该方法返回一个List，可能有多个元素，每个元素都是一个Item对象。<br>
	 *         图文素材的具体内容通过Item对象的getContent()方法获得，<br>
	 *         其他素材通过getName()、getUrl()方法获得名称和下载地址。
	 */
	public MaterialListBean batchGetMaterial(String type, short offset, short count) throws CapabilityException;

	/**
	 * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件）。请注意，视频文件不支持https下载，调用该接口需http协议。
	 * 
	 * @param mediaId
	 *            媒体文件ID
	 * @return 下载的媒体文件（File），可以用renameTo方法将文件另存到指定的位置。
	 * @throws CapabilityException
	 */
	public File getMedia(String mediaId) throws CapabilityException;

	/**
	 * 
	 * 在新增了永久素材后，开发者可以根据media_id来获取永久素材。<br>
	 * 请注意：<br>
	 * 1、获取永久素材也可以获取公众号在公众平台官网素材管理模块中新建的图文消息、图片、语音、视频等素材<br>
	 * （但需要先通过获取素材列表来获知素材的media_id）<br>
	 * 2、临时素材无法通过本接口获取<br>
	 * 3、除图文、视频以外其他类型的素材，需通过downloadMaterial()方法下载
	 * 
	 * @param mediaId
	 *            媒体文件ID
	 * @return MaterialResultBean的对象。<br>
	 *         如果请求的素材为图文消息，则图文内容通过MaterialResultBean的getNews_item()方法获得，
	 *         getNews_item()方法返回一个List，其中可能包括多条图文内容。<br>
	 *         如果请求的是视频消息素材，则通过MaterialResultBean的getTitle()、getDescription()、
	 *         getDown_url()方法分别获得视频素材的标题、描述和下载地址。<br>
	 * 
	 * @throws CapabilityException
	 */
	public MaterialResultBean getMaterial(String mediaId) throws CapabilityException;

	/**
	 * 
	 * 除图文、视频以外其他类型的素材消息，则响应的直接为素材的内容，开发者可以自行保存为文件。
	 * 
	 * @param mediaId
	 *            媒体文件ID
	 * @return 下载的素材文件（File），可以用renameTo方法将文件另存到指定的位置。
	 * @throws CapabilityException
	 */
	public File downloadMaterial(String mediaId) throws CapabilityException;

}
