package com.abdurrahmanbulut.composeAppBase.network.repository

import com.abdurrahmanbulut.composeAppBase.model.CatFact
import com.abdurrahmanbulut.composeAppBase.network.api.SplashApi
import com.abdurrahmanbulut.sherlock.network.CallHandler
import com.abdurrahmanbulut.sherlock.network.Service.call
import kotlinx.coroutines.CoroutineScope

class SplashRepository(private val api: SplashApi) {
    fun getFacts(coroutineScope: CoroutineScope): CallHandler<CatFact> {
        return coroutineScope.call(
            repositoryCall = {
                api.getFacts()
            },
        )
    }
}
