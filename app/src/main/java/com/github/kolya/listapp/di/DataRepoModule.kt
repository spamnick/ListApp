package com.github.kolya.listapp.di

import com.github.kolya.module.data.UsersRepositoryImpl
import com.github.kolya.module.domain.repository.UsersRepository
import org.koin.dsl.module

val dataRepoModule = module {
    single<UsersRepository> { UsersRepositoryImpl(get()) }
}