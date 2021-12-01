package com.github.kolya.module.remote.models

import com.google.gson.annotations.SerializedName

data class UserRemote constructor(
    @SerializedName("login")
    val login:String,
    @SerializedName("id")
    val id:Long,
    @SerializedName("html_url")
    val htmlUrl:String,
    @SerializedName("avatar_url")
    val avatarUrl:String,
)
/*
{
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