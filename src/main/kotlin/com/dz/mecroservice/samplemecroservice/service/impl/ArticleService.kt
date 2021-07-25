package com.dz.mecroservice.samplemecroservice.service.impl

import com.dz.mecroservice.samplemecroservice.Ext.toLocalDate
import com.dz.mecroservice.samplemecroservice.bo.Article
import com.dz.mecroservice.samplemecroservice.bo.Author
import com.dz.mecroservice.samplemecroservice.repository.ArticleRepository
import com.dz.mecroservice.samplemecroservice.service.IArticleService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Repository
class ArticleService(
    private val repository: ArticleRepository
) : IArticleService {

    override fun save(t: Article): Article =
            repository.save(t)

    override fun update(id: Long, t: Article): Article {
        if (repository.existsById(id)) {
            return repository.save(t)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }

    override fun delete(id: Long): String {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            "Delete success"
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }

    override fun findById(id: Long): Article {
        return if (repository.existsById(id)) {
            repository.findById(id).get()
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "This id article does not exist")
        }
    }

    override fun findAll(): List<Article> =
            repository.findAll()

    override fun findBySlug(slug: String): Article? =
            repository.findBySlug(slug) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

    override fun findAllByOrderByAddedAtDesc(): List<Article> =
            repository.findAllByOrderByAddedAtDesc()

    override fun findByAuthor(idAuthor: Long): List<Article> {
        val author = Author("","","","",idAuthor)
        return repository.findByAuthor(author)
    }

    override fun findByAddedAtBetween(debut: String, fin: String) =
        repository.findByAddedAtBetween(debut.toLocalDate(), fin.toLocalDate())
}