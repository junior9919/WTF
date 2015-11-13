# WTF
WechaT Framework（微信开发框架，简称WTF）能帮助开发者快速搭建微信公众号开发环境，开发者在自己的微信公众号开发项目中引入本框架后，仅需简单的几步配置即可获得消息接收、解析、回复等功能，同时还有菜单创建，二维码请求等功能供开发者调用。

WTF使得开发者能够集中精力关注自身业务能力的开发，省去对Http、Xml、Json等大量基础能力模块的理解和构建，节省大量人力和时间。引入WTF使得微信公众号开发变成一件快速而简单的工作，尤其适合个人公众号，以及非软件研发专业公司的营销公众号的快速开发。

仅需四步，就能完成微信公众号的接入、鉴权、菜单创建、消息接收与回复等核心功能。

第一步：将WTF的4个jar包拷贝到项目的lib目录下；

第二步：在项目的web.xml文件中增加spring上下文配置；

第三步：在项目的classpath目录下加入配置文件“wechat.properties”，配置app_id、app_secret和token；

第四步：实现WTF框架中的com.halo.wechat.mvc.commands.Command接口。


关于WTF的详细配置与功能，请访问“Wechat Framework开发者指南”：http://115.159.67.204/Tutorial/tutorial.htm
