package com.dz.mecroservice.samplemecroservice.datacontroller

import com.dz.mecroservice.samplemecroservice.BlogProperties
import com.dz.mecroservice.samplemecroservice.Ext.format
import com.dz.mecroservice.samplemecroservice.bo.Article
import com.dz.mecroservice.samplemecroservice.bo.Author
import com.dz.mecroservice.samplemecroservice.repository.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(
    private val repository: ArticleRepository,
    private val properties: BlogProperties
) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "blog"
    }

    fun Article.render() = RenderedArticle(
        slug,
        title,
        headline,
        content,
        author,
        addedAt.format()
    )

    data class RenderedArticle(
        val slug: String,
        val title: String,
        val headline: String,
        val content: String,
        val author: Author,
        val addedAt: String)

}
