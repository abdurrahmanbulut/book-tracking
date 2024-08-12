package com.abdurrahmanbulut.composeAppBase.network.repository

import com.abdurrahmanbulut.composeAppBase.network.api.StockApi
import com.abdurrahmanbulut.sherlock.network.CallHandler
import com.abdurrahmanbulut.sherlock.network.Service.call
import kotlinx.coroutines.CoroutineScope

class StockRepository(private val api: StockApi) {
    fun getStockPrice(
        coroutineScope: CoroutineScope,
        symbol: String,
    ): CallHandler<Any> {
        return coroutineScope.call(
            repositoryCall = {
                api.getStockPrice(
                    function = "GLOBAL_QUOTE",
                    symbol = symbol,
                    apiKey = "GUUGH1WRKYZZD4GF",
                )
            },
        )
    }
}
