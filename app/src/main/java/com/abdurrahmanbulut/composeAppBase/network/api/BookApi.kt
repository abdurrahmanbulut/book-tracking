package com.abdurrahmanbulut.composeAppBase.network.api

import com.abdurrahmanbulut.composeAppBase.di.key
import com.abdurrahmanbulut.composeAppBase.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("orderBy") orderBy: String = "relevance",
        @Query("maxResults") maxResults: Int = 40,
        @Query("langRestrict") langRestrict: String = "tr",
        @Query("key") apiKey: String = key
    ): BookResponse
}
