package com.github.kolya.listapp.di

import com.github.kolya.module.domain.GetUserDataByUserNameUseCase
import com.github.kolya.module.domain.GetUserListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<GetUserListUseCase> { GetUserListUseCase(get()) }
    single<GetUserDataByUserNameUseCase> { GetUserDataByUserNameUseCase(get()) }
}