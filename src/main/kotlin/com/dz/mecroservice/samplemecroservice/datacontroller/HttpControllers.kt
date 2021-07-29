package com.dz.mecroservice.samplemecroservice.datacontroller

import com.dz.mecroservice.samplemecroservice.bo.Article
import com.dz.mecroservice.samplemecroservice.bo.Author
import com.dz.mecroservice.samplemecroservice.repository.AuthorJpaRepository
import com.dz.mecroservice.samplemecroservice.service.IArticleService
import com.dz.mecroservice.samplemecroservice.service.IAuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/article")
class ArticleController {

    @Autowired
    lateinit var repository: IArticleService

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/findBySlug/{slug}")
    fun findOne(@PathVariable slug: String) =
        repository.findBySlug(slug)

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long) =
        repository.findById(id)

    @GetMapping("/articlesByUser/{idAuthor}")
    fun findByAuthor(@PathVariable idAuthor: Long) =
        repository.findByAuthor(idAuthor)

    @GetMapping("/addedAtBetween/{debut}/{fin}")
    fun findByAddedAtBetween(
        @PathVariable debut: String,
        @PathVariable fin: String
    ) = repository.findByAddedAtBetween(debut, fin)

    @PostMapping("/save")
    fun save(@RequestBody article: Article): Article =
            repository.save(article)

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody article: Article
    ): Article = repository.update(id,article)


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String =
            repository.delete(id)
}

@RestController
@RequestMapping("/api/author")
class AuthorController {

    @Autowired
    lateinit var repository: IAuthorService

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/findByLogin/{login}")
    fun findOne(@PathVariable login: String) =
        repository.findByLogin(login)

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long) =
        repository.findById(id)

    @PostMapping("/save")
    fun save(@RequestBody user: Author): Author =
        repository.save(user)

    @PutMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody user: Author
    ): Author = repository.update(id,user)

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String =
            repository.delete(id)
}
