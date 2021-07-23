package com.dz.mecroservice.samplemecroservice.service

import com.dz.mecroservice.samplemecroservice.bo.Article
import org.springframework.stereotype.Service

@Service
interface IArticleService : AbstractService<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
    fun findByAuthor(idAuthor: Long): Iterable<Article>
}