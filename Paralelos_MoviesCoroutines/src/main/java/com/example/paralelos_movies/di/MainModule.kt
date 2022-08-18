package com.example.paralelos_movies.di

import com.example.paralelos_movies.ui.main.MainRepository
import com.example.paralelos_movies.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single {
        MainRepository()
    }

    viewModel {
        MainViewModel(
            repository = get()
        )
    }

}