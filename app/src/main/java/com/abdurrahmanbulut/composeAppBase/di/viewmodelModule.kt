package com.abdurrahmanbulut.composeAppBase.di

import com.abdurrahmanbulut.composeAppBase.ui.InsetsViewModel
import com.abdurrahmanbulut.composeAppBase.ui.main.MainScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.main.home.HomeScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule =
    module {
        viewModel { SplashViewModel(get()) }
        viewModel { HomeScreenVM(get()) }
        viewModel { MainScreenVM() }
        viewModel { InsetsViewModel() }
    }
