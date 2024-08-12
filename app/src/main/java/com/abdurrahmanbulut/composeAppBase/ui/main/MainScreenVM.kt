package com.abdurrahmanbulut.composeAppBase.ui.main

import EventHandler
import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.sherlock.navigation.Navigator

class MainScreenVM : ViewModel() {
    val navigateToHome = EventHandler<Unit>()
    val navigateToPlannedToRead = EventHandler<Unit>()
    val navigateToAllBooks = EventHandler<Unit>()
    lateinit var navigator: Navigator

    fun onClickHome() {
        navigateToHome.trigger()
    }

    fun onClickPlannedToRead() {
        navigateToPlannedToRead.trigger()
    }

    fun onClickAllBooks() {
        navigateToAllBooks.trigger()
    }
}
