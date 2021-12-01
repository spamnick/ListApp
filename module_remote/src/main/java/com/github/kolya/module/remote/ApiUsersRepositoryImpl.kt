package com.github.kolya.module.remote

import com.github.kolya.module.data.ApiUsersRepository
import com.github.kolya.module.domain.models.UserDomain
import com.github.kolya.module.remote.models.UserRemote

class ApiUsersRepositoryImpl constructor(private val apiUsersService: ApiUsersService) : ApiUsersRepository {
    override suspend fun getUsers(): List<UserDomain> {
        return apiUsersService.getUsers().map { it.toUserDomain() }
    }

    override suspend fun getUserByUserName(username: String): UserDomain {
        return apiUsersService.getUserByUserName(username).toUserDomain()
    }
}

private fun UserRemote.toUserDomain(): UserDomain {
    return UserDomain(
        id = id,
        imageUrl = avatarUrl,
        name = login,
        link = htmlUrl,
    )
}
