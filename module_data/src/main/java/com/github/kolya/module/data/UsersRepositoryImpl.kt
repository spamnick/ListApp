package com.github.kolya.module.data

import com.github.kolya.module.domain.models.UserDomain
import com.github.kolya.module.domain.repository.UsersRepository

class UsersRepositoryImpl(private val apiUsersRepository:ApiUsersRepository): UsersRepository {
    override suspend fun getUsers(): List<UserDomain> {
        return apiUsersRepository.getUsers()
    }

    override suspend fun getUserByUserName(username: String): UserDomain {
        return apiUsersRepository.getUserByUserName(username)
    }
}