package com.github.kolya.module.domain

import com.github.kolya.module.domain.models.UserDomain
import com.github.kolya.module.domain.repository.UsersRepository

class GetUserListUseCase(private val usersRepository: UsersRepository) {
    suspend operator fun invoke(): List<UserDomain> {
        return usersRepository.getUsers()
    }
}

/*
*
* {
    "login": "mojombo",
    "id": 1,
    "node_id": "MDQ6VXNlcjE=",
    "avatar_url": "https://avatars.githubusercontent.com/u/1?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/mojombo",
    "html_url": "https://github.com/mojombo",
    "followers_url": "https://api.github.com/users/mojombo/followers",
    "following_url": "https://api.github.com/users/mojombo/following{/other_user}
* */