package com.abdurrahmanbulut.composeAppBase.ui.main

import EventHandler
import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.sherlock.navigation.Navigator

class MainScreenVM : ViewModel() {
    val onFirst = EventHandler<Unit>()
    val onSecond = EventHandler<Unit>()
    val test1 = EventHandler<String>()
    val test2 = EventHandler<Pair<String, String>>()
    val test3 = EventHandler<Triple<String, String, String>>()
    lateinit var navigator: Navigator

    fun onClickFirst() {
        test1.trigger("test1")
    }

    fun onClickSecond() {
        test3.trigger("test1", "test2", "test3")
    }
}
