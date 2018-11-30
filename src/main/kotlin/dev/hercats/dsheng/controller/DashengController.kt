package dev.hercats.dsheng.controller

import dev.hercats.dsheng.model.Article
import dev.hercats.dsheng.model.ArticleDetail
import dev.hercats.dsheng.model.Message
import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.text.SimpleDateFormat
import java.util.*

@RestController
class DashengController(@Autowired val restTemplate: RestTemplate) {

    private val BASE_URL = "https://www.ifanr.com/dasheng"

    private val pageCache = mutableMapOf<Int, List<Article>>()

    private var dateCache: String = ""

    @RequestMapping(value = ["/dasheng", "/dasheng/"], method = [RequestMethod.GET])
    fun dasheng(page: Int = 1): Message {
        val msg = Message()
        msg.code = 200

        if (isNeedRequest(page)) {
            getArticle(page)
        }
        msg.map("last_update", dateCache)
        msg.map("page", page)
        msg.map("articles", pageCache[page] ?: "")
        return msg
    }

    @RequestMapping(value = ["/dasheng/{id}", "/dasheng/{id}/"], method = [RequestMethod.GET])
    fun article(@PathVariable("id") id: String): Message {
        val msg = Message()
        val html = restTemplate.getForObject("$BASE_URL/$id", String::class.java) ?: ""
        if (html.isBlank()) {
            msg.code = 500
            msg.msg = "请求爱范儿服务器出错"
        } else {
            val doc = Jsoup.parse(html)
            val articleWrapper = doc.select(".o-single-content")[0]
            val header = articleWrapper.child(0)
            val pic = header.child(0)
                    .attr("style")
                    .substringAfter("'")
                    .substringBefore("'")
            val quote = header.child(1).child(0).text()
            val author = header.child(1).child(1).text()
            val content = articleWrapper.getElementsByTag("article").html()
            val articleContent = ArticleDetail(
                    id = id,
                    author = author,
                    quote = quote,
                    html = content,
                    authorPic = pic)
            msg.code = 200
            msg.map("article", articleContent)
        }
        return msg
    }


    @RequestMapping(value = ["dasheng/"])

    @Synchronized fun getArticle(page: Int) {
        val articles = mutableListOf<Article>()
        val html = if (page == 1) {
            restTemplate.getForObject(BASE_URL, String::class.java) ?: ""
        } else {
            val id = pageCache[page - 1]?.last()?.id ?: 0
            val url = "$BASE_URL?page=$page&pajax=1&post_id__lt=$id"
            restTemplate.getForObject(url, String::class.java) ?: ""
        }
        if (html.isNotBlank()) {
            val doc = Jsoup.parse(html)
            val articleCollection = doc.select("#articles-collection")
            val articleDoms = if (page == 1) {
                articleCollection[0].children()
            } else {
                doc.getElementsByClass("c-bricks__brick")
            }
            articleDoms.forEach {div ->
                val a = div.getElementsByTag("a")[0]
                val id = a.attr("data-post-id")
                val quote = a.child(0).child(0).text()
                val author = a.child(0).child(1).text()
                val desc = a.child(1).text()
                val time = a.child(2).child(0).text()
                articles.add(Article(
                        id = id,
                        time = time,
                        quote = quote,
                        author = author,
                        desc = desc))
            }
        }
        // set page cache
        pageCache[page] = articles
    }

    @Synchronized fun isNeedRequest(page: Int): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
        val today = dateFormat.format(Date())
        return when {
            dateCache != today -> {
                // change date cache
                dateCache = today
                pageCache.clear()
                true
            }
            pageCache[page] == null -> {
                true
            }
            // dateCache is equal to today and cacheOfToday is not empty
            else -> false
        }
    }
}