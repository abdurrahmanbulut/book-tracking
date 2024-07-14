package com.abdurrahmanbulut.composeAppBase.ui.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.composeAppBase.model.CatFact
import com.abdurrahmanbulut.composeAppBase.network.repository.SplashRepository
import com.abdurrahmanbulut.composeAppBase.ui.splash.TestData
import com.abdurrahmanbulut.sherlock.network.ServiceResult

class HomeScreenVM(private val splashRepository: SplashRepository, val data: TestData?) : ViewModel() {
    val test = "Home Screen"

    val catFact: MutableState<ServiceResult<CatFact>> = mutableStateOf(ServiceResult.Loading)

    init {
        getFacts()
        println(data)
    }

    private fun getFacts() {
        splashRepository.getFacts(viewModelScope, catFact)
    }
}
