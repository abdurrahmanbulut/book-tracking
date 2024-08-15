package com.abdurrahmanbulut.composeAppBase.di

import com.abdurrahmanbulut.composeAppBase.ui.InsetsViewModel
import com.abdurrahmanbulut.composeAppBase.ui.main.MainScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.AllBooksScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.detail.BookDetailScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.main.home.HomeScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.main.plannedToRead.PlannedToReadScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule =
    module {
        viewModel { SplashViewModel(get()) }
        viewModel { HomeScreenVM() }
        viewModel { MainScreenVM() }
        viewModel { InsetsViewModel() }
        viewModel { PlannedToReadScreenVM() }
        viewModel { AllBooksScreenVM(get()) }
        viewModel { p -> BookDetailScreenVM(p[0]) }
    }
