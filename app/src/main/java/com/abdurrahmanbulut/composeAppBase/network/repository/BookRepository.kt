package com.abdurrahmanbulut.composeAppBase.network.repository

import com.abdurrahmanbulut.composeAppBase.model.BookResponse
import com.abdurrahmanbulut.composeAppBase.network.api.BookApi
import com.abdurrahmanbulut.sherlock.network.CallHandler
import com.abdurrahmanbulut.sherlock.network.Service.call
import kotlinx.coroutines.CoroutineScope

class BookRepository(private val api: BookApi) {
    fun getBooks(
        coroutineScope: CoroutineScope,
        query: String
    ): CallHandler<BookResponse> {
        return coroutineScope.call(repositoryCall = {
            api.getBooks(
                query
            )
        })
    }
}
