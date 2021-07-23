package com.dz.mecroservice.samplemecroservice.service

import com.dz.mecroservice.samplemecroservice.bo.Author
import org.springframework.stereotype.Service

@Service
interface IAuthorService : AbstractService<Author, Long> {
    fun findByLogin(login: String): Author?
}