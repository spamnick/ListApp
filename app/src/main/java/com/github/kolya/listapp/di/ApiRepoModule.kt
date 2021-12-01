package com.github.kolya.listapp.di

import com.github.kolya.module.data.ApiUsersRepository
import com.github.kolya.module.remote.ApiConstants.BASE_URL
import com.github.kolya.module.remote.ApiUsersService
import com.github.kolya.module.remote.ApiUsersRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiRepoModule = module {
    single<ApiUsersService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiUsersService::class.java)
    }
    single<ApiUsersRepository> { ApiUsersRepositoryImpl(get()) }
}