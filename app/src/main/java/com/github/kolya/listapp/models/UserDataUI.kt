package com.github.kolya.listapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataUI(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val link: String,
) : Parcelable
