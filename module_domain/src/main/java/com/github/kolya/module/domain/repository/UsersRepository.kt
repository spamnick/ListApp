package com.github.kolya.module.domain.repository

import com.github.kolya.module.domain.models.UserDomain

interface UsersRepository {
    suspend fun getUsers(): List<UserDomain>
    suspend fun getUserByUserName(username: String): UserDomain
}