package com.abdurrahmanbulut.composeAppBase.constants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocalizationViewModel() : ViewModel() {
    private val _localizationStrings = MutableStateFlow<Map<String, String>>(emptyMap())
    val localizationStrings: StateFlow<Map<String, String>> = _localizationStrings

    fun loadLocalizationStrings(lang: String) {
        viewModelScope.launch {
//            val strings = repository.fetchLocalizationStrings(lang)
//            _localizationStrings.value = strings.associate { it.key to it.value }
        }
    }

    infix fun get(key: String): String {
        return _localizationStrings.value[key] ?: key
    }
}
