package com.github.kolya.listapp.models.mapper

import com.github.kolya.listapp.models.UserDataUI
import com.github.kolya.module.domain.models.UserDomain

fun UserDomain.toUserDataUI(): UserDataUI {
    return UserDataUI(
        id = id,
        imageUrl = imageUrl,
        name = name,
        link = link
    )
}