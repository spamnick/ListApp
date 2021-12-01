package com.github.kolya.listapp.di

import com.github.kolya.listapp.ui.details.UserDetailsViewModel
import com.github.kolya.listapp.ui.users.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserListViewModel(get(),get()) }
    viewModel { UserDetailsViewModel(get(),get(),get()) }
}