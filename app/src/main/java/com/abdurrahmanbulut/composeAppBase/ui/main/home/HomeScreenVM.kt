package com.abdurrahmanbulut.composeAppBase.ui.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.composeAppBase.model.CatFact
import com.abdurrahmanbulut.composeAppBase.network.repository.SplashRepository

class HomeScreenVM(private val splashRepository: SplashRepository) : ViewModel() {
    val test = "Home Screen"

    val catFact: MutableState<CatFact?> = mutableStateOf(null)

    init {
        getFacts()
    }

    private fun getFacts() {
        splashRepository.getFacts(viewModelScope)
            .success {
                println(it)
            }
            .failure {
                println(it)
            }
    }
}
