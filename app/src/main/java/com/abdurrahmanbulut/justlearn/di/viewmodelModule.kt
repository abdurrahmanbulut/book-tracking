package com.abdurrahmanbulut.justlearn.di

import com.abdurrahmanbulut.justlearn.ui.InsetsViewModel
import com.abdurrahmanbulut.justlearn.ui.MainViewModel
import com.abdurrahmanbulut.justlearn.ui.main.home.HomeScreenVM
import com.abdurrahmanbulut.justlearn.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { HomeScreenVM() }
    viewModel { MainViewModel() }
    viewModel { InsetsViewModel() }
}