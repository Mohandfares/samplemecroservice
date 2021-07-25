package com.dz.mecroservice.samplemecroservice.service

import com.dz.mecroservice.samplemecroservice.bo.Article
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
interface IArticleService : AbstractService<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): List<Article>
    fun findByAuthor(idAuthor: Long): List<Article>
    fun findByAddedAtBetween(debut: String, fin: String): List<Article>
}