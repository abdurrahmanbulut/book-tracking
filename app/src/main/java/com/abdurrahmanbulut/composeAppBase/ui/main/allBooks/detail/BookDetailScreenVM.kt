package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.detail

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.composeAppBase.model.BookDetails
import com.abdurrahmanbulut.composeAppBase.model.VolumeInfo
import createEvent

class BookDetailScreenVM(val detail: VolumeInfo?): ViewModel(){
    val title = "Kitap Hakkında"
    val onBack = createEvent()

    fun onBack(){
        onBack.trigger()
    }
}