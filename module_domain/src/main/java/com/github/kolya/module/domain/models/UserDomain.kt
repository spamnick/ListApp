package com.github.kolya.module.domain.models

data class UserDomain constructor(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val link: String,
)
