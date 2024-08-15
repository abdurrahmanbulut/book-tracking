package com.abdurrahmanbulut.composeAppBase.di

import com.abdurrahmanbulut.composeAppBase.network.api.BookApi
import com.abdurrahmanbulut.composeAppBase.network.api.SplashApi
import com.abdurrahmanbulut.sherlock.network.provideLoggingInterceptor
import com.abdurrahmanbulut.sherlock.network.provideOkHttpClient
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val key = "AIzaSyAWUvRf87egoNHSNXU1ZAaJiBjD3XxSPwY"
const val baseUrl = "https://www.googleapis.com/books/v1/"

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun splashApi(retrofit: Retrofit): SplashApi {
    return retrofit.create(SplashApi::class.java)
}

fun bookApi(retrofit: Retrofit): BookApi {
    return retrofit.create(BookApi::class.java)
}

val apiModule =
    module {
        single { provideLoggingInterceptor() }
        single { provideOkHttpClient(get()) }
        single { provideRetrofit(get()) }
        single { splashApi(get()) }
        single { bookApi(get()) }
    }
