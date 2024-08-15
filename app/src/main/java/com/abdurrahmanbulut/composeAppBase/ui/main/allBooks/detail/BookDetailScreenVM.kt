package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.detail

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.composeAppBase.model.BookItem
import createEvent

class BookDetailScreenVM(val detail: BookItem?): ViewModel(){
    val title = "Kitap Hakkında"
    val onBack = createEvent()

    fun onBack(){
        onBack.trigger()
    }
}