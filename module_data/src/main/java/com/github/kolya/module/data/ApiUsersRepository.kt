package com.github.kolya.module.data

import com.github.kolya.module.domain.models.UserDomain

interface ApiUsersRepository {
    suspend fun getUsers(): List<UserDomain>
    suspend fun getUserByUserName(username: String): UserDomain
}