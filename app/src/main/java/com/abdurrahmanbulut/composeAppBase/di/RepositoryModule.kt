package com.abdurrahmanbulut.composeAppBase.di

import com.abdurrahmanbulut.composeAppBase.constants.DataStoreHelper
import com.abdurrahmanbulut.composeAppBase.network.repository.SplashRepository
import com.abdurrahmanbulut.composeAppBase.network.repository.BookRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
        single { DataStoreHelper(get()) }
        single { BookRepository(get()) }
    }
