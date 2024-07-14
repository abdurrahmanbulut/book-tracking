package com.abdurrahmanbulut.composeAppBase.ui.splash

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.composeAppBase.network.repository.SplashRepository
import org.koin.core.component.KoinComponent

class SplashViewModel(private val repository: SplashRepository) : ViewModel(), KoinComponent
