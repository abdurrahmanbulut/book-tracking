package com.abdurrahmanbulut.composeAppBase.network.api

import com.abdurrahmanbulut.composeAppBase.constants.LocalizationKeys
import retrofit2.http.GET
import retrofit2.http.Query

interface LocalizationApi {
    @GET("localization")
    suspend fun getLocalizationStrings(
        @Query("lang") lang: String,
    ): List<LocalizationKeys>
}
