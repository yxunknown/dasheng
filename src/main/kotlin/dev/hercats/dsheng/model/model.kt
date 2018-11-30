package dev.hercats.dsheng.model

data class Message(
        var code: Int = 0,
        var msg: String = "") {
    val map: MutableMap<String, Any> = mutableMapOf()

    fun map(key: String, value: Any) {
        map[key] = value
    }
}

data class Article(
        var id: String = "",
        var time: String = "",
        var quote: String = "",
        var desc: String = "",
        var author: String = "")

data class ArticleDetail(
        var id: String = "",
        var quote: String = "",
        var author: String = "",
        var authorPic: String = "",
        var html: String = "")