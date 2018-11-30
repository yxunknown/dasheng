## 爱范儿大声板块REST API
说明，本api为通过Jsoup[https://github.com/jhy/jsoup]html解析开发的爱范儿网站大声板块文章，请大家前往https://www.ifanr.com/dasheng查看相关文章详情。 

## API
### 获取文章列表
* [地址]  *:8848/dasheng
* [方法] GET
* [参数] page int类型 必须
* [调用示例] localhost:8848/dasheng?page=1  
* [返回参数说明]  
  * code 请求响应代码
  * msg 消息。成功为空；错误时为错误消息
  * map 结果对象
  * last_update 最近更新时间
  * page 当前页数
  * articles 文章数组
  * id 文章编号
  * time 发布时间
  * quote 大声说内容
  * desc 文章描述
  * author 大声说主角  
  
  
返回示例  
```$xslt
// 20181130214341
// http://localhost:8848/dasheng?page=1

{
  "code": 200,
  "msg": "",
  "map": {
    "last_update": "2018-11-30",
    "page": 1,
    "articles": Array[10][
      {
        "id": "1133040",
        "time": "11-26 10:39",
        "quote": "为了登入一项本来就会从我获得经济收益的服务，我首先还得先给 Google 的无人车服务 Waymo 提供另一些没有报酬的劳动服务（完成 Captcha 给人工智能提供素材）。",
        "desc": "John Naughton 在首次登录一个账号时，平台为了检测他是否真正人类用户，让他做了一组 Captcha 测试（Completely Automated Public Turing test to tell Computers an...",
        "author": "—— John Naughton，专栏作家"
      },
      {
        "id": "1132784",
        "time": "11-23 14:55",
        "quote": "和快速学习相比，我们（在设计多邻国时）更看重能让人上瘾的内容。因为如果有人放弃了，那学习速度就为零了。",
        "desc": "学习一种新的语言是件压力挺大的事儿，而语言学习 app 游戏化模式却能让人感觉「要开始去学好像也没那么困难」。 书籍《别轻易相信专家》作者 David Freedman 是语言学习 app 多邻国（Duolingo）的用户，他去意大利旅行...",
        "author": "—— Luis von Ahn，多邻国 CEO"
      },
      {
        "id": "1130785",
        "time": "11-20 17:55",
        "quote": "当你将发现新播客（Podcast）和发现新音乐的服务相比，就会意识到前者简直还处于石器时代。我们觉得我们可以以特定播客来吸引新听众，然后用我们自有的音乐来将他们留下。",
        "desc": "流媒体为了保持竞争力，大量投资在音乐版权商上。以 Spotify 为例，就是一个因音乐版权费用太高，用户越多越活跃，公司亏损越严重的公司。最近，他们找到了一个新出路——音频播客（Podcast）。 当你将发现新播客（Podcast）和发...",
        "author": "—— Roger Lynch，音乐流媒体 Pandora 公司 CEO"
      },
      {
        "id": "1130056",
        "time": "11-19 09:46",
        "quote": "亚马逊并不是「大而不倒」。事实上，我预测亚马逊终有一天会失败。亚马逊将破产。",
        "desc": "亚马逊终于正式公布，即将在纽约长岛和北弗吉尼亚州水晶城共同设立公司的第二总部，预计将能为当地各自创造 2.5 万个新就业机会。就在这个公司正快速扩张的阶段，亚马逊内部员工却提出了一个问题：我们的未来方向在哪？ 这个问题并不是空穴来风。不久...",
        "author": "—— Jeff Bezos，亚马逊 CEO"
      },
      {
        "id": "1128228",
        "time": "11-15 10:19",
        "quote": "（设计城市时）孩子会为生物而设计，而不是为了汽车、虚荣心或是企业来设计。",
        "desc": "在进行城市规划时，我们都说要为后代着想，但却甚少真正聆听他们的声音。毕竟，他们是「未来」主人翁。 Mara Mintzer 是 Growing Up Boulder 项目的创始人之一。这个项目通过邀请孩子参与，设计一个更友好的城市。在两年...",
        "author": "—— Mara Mintzer"
      },
      {
        "id": "1126982",
        "time": "11-13 10:05",
        "quote": "我们不是在「注意控制身材」，而是「优化性能」；我们不只是在「吃沙拉」，而是做自己身体系统的「黑客」。",
        "desc": "「子弹咖啡」想优化你清晨的咖啡，提高你的工作效率和减少饥饿感；23andMe 想帮你根据基因来制定饮食和运动计划；Habit 承诺会根据你的个人生物标记来制定营养计划；要进行定期断食？There’s an app for that。 ...",
        "author": "—— Amanda Mull"
      },
      {
        "id": "1125388",
        "time": "11-09 10:22",
        "quote": "如何满足 45 亿人安全用厕蕴含着巨大的商机，这么大的商机并不常有。",
        "desc": "继「养鸡脱贫」，从「首富」变成「首善」的比尔·盖茨最近在努力宣传的主题是「用厕所改变世界」。 你可能在想，这个烧杯里装的是什么？没错，是人的粪便。但这么点儿粪便就能携带两百万亿个轮状病毒、两百亿个贺氏菌和十万个寄生虫卵。 ▲ 与大便同...",
        "author": "—— 比尔·盖茨，盖茨基金联合主席"
      },
      {
        "id": "1124987",
        "time": "11-08 15:49",
        "quote": "哪个比较容易赚钱：想方设法去「剥削」用户，还是研发出一款更好的产品？在现有人工智能等技术的帮助下，答案是去利用用户。",
        "desc": "诺贝尔经济学得主 Joseph Stiglitz 在近日接受《卫报》采访中表示，我们不能指望科技公司自行打造一套公正处理数据的规则。 哪个比较容易赚钱：想方设法去「剥削」用户，还是研发出一款更好的产品？在新人工智能技术的帮助下，答案应该是...",
        "author": "—— Joseph Stiglitz，诺奖经济学家"
      },
      {
        "id": "1124470",
        "time": "11-07 16:21",
        "quote": "世界上 50% 的人都住在水域附近，我们认为水下数据中心是未来进行扩张的方式。",
        "desc": "信息爆炸让数据中心成为一件非常烧钱的基建设备。据统计，2017 年北美地区用来建设数据中心的房产投资金额就已高达 200 亿美元。 微软想了个方法：把数据中心「扔」到海底。 因为 50% 的世界人口都住在水域附近，我们认为，这（水下数据中...",
        "author": "—— Satya Nadella，微软 CEO"
      },
      {
        "id": "1120340",
        "time": "10-30 17:02",
        "quote": "我不会说库克把技术创新放在首位，他成功地将苹果塑造成奢侈品牌。",
        "desc": "iPhone 自问世起，就与「便宜」二字不沾边，其高端定位在库克接手后更加明显，最新一代 iPhone，即使是相对「廉价」的 iPhone XR，价格已与苹果自家最便宜的电脑 Macbook Air 相差无几。这也就难怪前苹果 CEO 约翰...",
        "author": "—— 前苹果 CEO 约翰·斯卡利"
      }
    ]
  }
}
``` 

**说明** 由于爱范儿大声说分页请求的机制为请求下一页时要带上一页最后一篇文章的id，因此大家使用的时候，如果想保证结果的准确性，最好是页数逐页递增请求。返回结果中的最近更新时间表示请求第一页时的时间，以保证接下来的数据时爱范儿网站上最新的数据。
### 获取文章详细内容
* [地址]  *:8848/dasheng/{articleId}
* [方法] GET
* [参数] articleId 字符串类型 必须
* [调用示例] localhost:8848/dasheng/1133040 
* [返回参数说明]  
  * code  响应代码
  * msg 消息。成功为空；错误时为错误消息
  * map 内容对象，包含具体的结果
  * article 文章数据
  * id 文章id
  * quote 文章的大声说内容（参见爱范儿大声网站）
  * author 大声说主角
  * authorPic 大声说主角头像
  * html 文章html  
 
返回示例  
```$xslt
// 20181130214508
// http://localhost:8848/dasheng/1133040

{
  "code": 200,
  "msg": "",
  "map": {
    "article": {
      "id": "1133040",
      "quote": "为了登入一项本来就会从我获得经济收益的服务，我首先还得先给 Google 的无人车服务 Waymo 提供另一些没有报酬的劳动服务（完成 Captcha 给人工智能提供素材）。",
      "author": "—— John Naughton，专栏作家",
      "authorPic": "https://s3.ifanr.com/wp-content/uploads/2018/11/cae.jpg!260",
      "html": "<p>John Naughton 在首次登录一个账号时，平台为了检测他是否真正人类用户，让他做了一组 Captcha 测试（Completely Automated Public Turing test to tell Computers and Humans Apart，用于区别人和电脑的全自动公共图灵测试），也就是放一组图片出来，让你挑出其中包含的「汽车」「马路」或「停车标识」的图片。</p> \n<p><img class=\"aligncenter size-full wp-image-1133593\" src=\"https://s3.ifanr.com/wp-content/uploads/2018/11/n9hTsPQ.jpg!720\" alt=\"\" width=\"403\" height=\"583\"></p> \n<p>当 Naughton 完成后感到很不满，因为他在选择的过程中其实是作为免费劳动力，帮助自动驾驶项目的视觉识别系统生成可用于学习的数据（以区分马路上的东西）。</p> \n<blockquote>\n <p>所以说，为了登入一项将从我使用中获得经济收益的自动化服务，我首先还得先给 Google 的无人车服务 Waymo 提供另一些没有报酬的劳动服务。</p>\n</blockquote> \n<p>让他觉得的更反感的，是测试名字中的「图灵测试」部分。</p> \n<p><a href=\"https://zh.wikipedia.org/wiki/%E5%9B%BE%E7%81%B5%E6%B5%8B%E8%AF%95\">「图灵测试（Turing test）」</a>是一个于 1950 年由图灵提出的试验，以测试和判断机器是否能表现出和人一样（无法区分的）智能。</p> \n<p>这个原本由计算机之父研发出来测试机器是否能像人一样做出反应的工具，到了现在，却成为了机器用来测试人是否为人的工具，要求人类像机器人一样完成各种任务，简直本末倒置。</p> \n<p><img class=\"aligncenter size-full wp-image-1133587\" src=\"https://s3.ifanr.com/wp-content/uploads/2018/11/mu.gif!720\" alt=\"\" width=\"300\" height=\"192\"></p> \n<div class=\"editor-image-source\"> \n <p>▲ 木兰尼在《周末也夜现场》里的一个段子，图片截自<a href=\"https://tv.sohu.com/v/MjAxODA0MTYvbjYwMDQ4MTE1NC5zaHRtbA==.html\">搜狐视频</a></p> \n</div> \n<p>除了这些测试，作者还援引了书籍《Re-Engineering Humanity》，表示人类正在「温水煮青蛙」地被机器训练得越来越像机器人。譬如，冗长复杂的用户说明「训练」人在不阅读任何说明前就点击「是」，为机器带来更高效率，而不是为人类带来更好体验。</p> \n<p>当青蛙忽然被扔入沸腾的水里，它必然会挣扎跳出。但如果将其置于低温的水，并逐渐加热，那它很可能会意识不到当中改变并死于其中。而今天，我们每天都在被一个一个小「练习」锻炼得越来越像机器，为了机器的效率而改变自己。</p> \n<blockquote>\n <p>无缝和无摩擦对于机器优化来说很好，但对人类而言却不是。归根到底，机器服务的应该是人类。机器不会设置自己的目标，为它们设置目标的是人类，至少我们希望仍然是这样。</p>\n</blockquote> \n<p>Brett Frischmann 说道，他是《Re-Engineering Humanity》其中一位作者。在他看来，电脑和机器人是典型的「人类创造工具，然后工具反过来影响我们」的例子，但不应该动摇的，始终是机器应该以为人类服务为目标。</p> \n<p>Naughton 认为，从 Captcha 或是 Google 的整体商业模式看来，人类已经不再是服务的终极目标，而是他们达到其他目标，甚至只是训练机器时的工具手段。</p> \n<div class=\"editor-image-source\"></div>"
    }
  }
}
``` 

## 使用方法
git clone https://github.com/yxunknown/dasheng.git
cd dasheng  
mvn clean install  

此时在dasheng/target目录下会生成.jar文件  
java -jar xxx.jar 即可  
程序默认端口为8848
