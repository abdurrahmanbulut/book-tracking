package com.abdurrahmanbulut.composeAppBase.network.api

import com.abdurrahmanbulut.composeAppBase.model.Breeds
import com.abdurrahmanbulut.composeAppBase.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}
