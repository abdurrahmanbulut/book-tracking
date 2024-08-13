package com.abdurrahmanbulut.composeAppBase.ui.main

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.sherlock.navigation.Navigator
import createEvent

class MainScreenVM : ViewModel() {
    val navigateToHome = createEvent()
    val navigateToPlannedToRead = createEvent()
    val navigateToAllBooks = createEvent()

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
