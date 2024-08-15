package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.composeAppBase.model.BookDetails
import com.abdurrahmanbulut.composeAppBase.model.BookResponse
import com.abdurrahmanbulut.composeAppBase.model.VolumeInfo
import com.abdurrahmanbulut.composeAppBase.network.repository.BookRepository
import createEventWithOneArg
import createEventWithTwoArg

class AllBooksScreenVM(private val bookRepository: BookRepository) : ViewModel() {
    val title = "Tüm Kitaplar"
    val navigateToDetail = createEventWithOneArg<VolumeInfo?>()
    var books by mutableStateOf<BookResponse?>(null)

    init {
//        getBooks()
        getMixBooks()
    }

    private fun getBooks(){
        bookRepository.getBooks(viewModelScope, "fiction")
            .success {
                books = it
            }
            .failure {
                println("failure")
            }
    }

    private fun getMixBooks(){
        val popularCategories = listOf("fiction", "nonfiction", "science", "history", "biography")
        val query = "subject:science"
        bookRepository.getBooks(viewModelScope, query).success {
            books = it
        }
    }

    fun onClickBook(detail: VolumeInfo?){
        navigateToDetail.trigger(detail)
    }
}
