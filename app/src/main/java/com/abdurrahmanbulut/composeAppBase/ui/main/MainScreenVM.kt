package com.abdurrahmanbulut.composeAppBase.ui.main

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.sherlock.events.createEvent
import com.abdurrahmanbulut.sherlock.events.triggered
import com.abdurrahmanbulut.sherlock.navigation.Navigator

class MainScreenVM : ViewModel() {
    val onFirst = createEvent()
    val onSecond = createEvent()
    lateinit var navigator: Navigator

    fun onClickFirst() {
        onFirst.value = triggered
    }

    fun onClickSecond() {
        onSecond.value = triggered
    }
}
