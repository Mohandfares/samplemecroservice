package com.dz.mecroservice.samplemecroservice.repository

import com.dz.mecroservice.samplemecroservice.bo.Article
import com.dz.mecroservice.samplemecroservice.bo.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime


interface ArticleRepository : JpaRepository<Article, Long> {

    @Query("SELECT * FROM Article WHERE slug = :slug ORDER BY id DESC LIMIT 1",nativeQuery = true)
    fun findBySlug(@Param("slug") slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): List<Article>
    fun findByAuthor(author: Author): List<Article>
    fun findByAddedAtBetween(debut: LocalDateTime, fin: LocalDateTime): List<Article>
}

interface AuthorRepository : JpaRepository<Author, Long> {
    fun findByLogin(login: String): Author?
}

interface AuthorJpaRepository : JpaRepository<Author, Long> {
    @Query("FROM Author WHERE login = :login")
    fun findAllByLogin(@Param("login") login: String): List<Author>
}