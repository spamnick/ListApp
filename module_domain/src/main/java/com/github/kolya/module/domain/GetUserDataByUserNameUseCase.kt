package com.github.kolya.module.domain

import com.github.kolya.module.domain.models.UserDomain
import com.github.kolya.module.domain.repository.UsersRepository

class GetUserDataByUserNameUseCase(private val usersRepository: UsersRepository){
    suspend operator fun invoke(username: String): UserDomain {
        return usersRepository.getUserByUserName(username)
    }
}
