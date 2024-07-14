package com.abdurrahmanbulut.composeAppBase.di

import com.abdurrahmanbulut.composeAppBase.network.repository.SplashRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
    }
