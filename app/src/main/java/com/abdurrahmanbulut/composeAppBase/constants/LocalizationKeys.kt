package com.abdurrahmanbulut.composeAppBase.constants

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.firstOrNull
import java.util.Locale

data object LocalizationKeys {
    const val WELCOME_MESSAGE = "welcome_message"
    const val GO_TO_HOME = "go_to_home"
    const val HOME_MESSAGE = "home_message"
    const val SELECT_LANGUAGE = "select_language"
}


val englishLocalization =
    mapOf(
        LocalizationKeys.WELCOME_MESSAGE to "WELCOME_MESSAGE",
        LocalizationKeys.GO_TO_HOME to "GO_TO_HOME",
        LocalizationKeys.HOME_MESSAGE to "HOME_MESSAGE",
        LocalizationKeys.SELECT_LANGUAGE to "SELECT_LANGUAGE",
    )

val turkishLocalization =
    mapOf(
        LocalizationKeys.WELCOME_MESSAGE to "WELCOME_MESSAGE",
        LocalizationKeys.GO_TO_HOME to "GO_TO_HOME",
        LocalizationKeys.HOME_MESSAGE to "HOME_MESSAGE",
        LocalizationKeys.SELECT_LANGUAGE to "SELECT_LANGUAGE",
    )

var localizationStrings by mutableStateOf(englishLocalization)
var language by mutableStateOf("en")

fun get(key: String): String {
    return localizationStrings[key] ?: key
}

suspend fun switchLanguage(
    language1: String,
    dataStoreHelper: DataStoreHelper,
) {
    when (language1) {
        "en" -> {
            localizationStrings = englishLocalization
            dataStoreHelper.saveLanguage("en")
            language = "en"
        }

        "tr" -> {
            localizationStrings = turkishLocalization
            dataStoreHelper.saveLanguage("tr")
            language = "tr"
        }

        else -> {
            localizationStrings = englishLocalization
            dataStoreHelper.saveLanguage("en")
            language = "en"
        }
    }
}

fun getDeviceLanguage(): String {
    return Locale.getDefault().language
}

suspend fun getInitialLocalizationStrings(dataStoreHelper: DataStoreHelper): Map<String, String> {
    val savedLanguage = dataStoreHelper.languageFlow.firstOrNull() ?: getDeviceLanguage()
    var temp: Map<String, String>? = null
    when (savedLanguage) {
        "en" -> {
            temp = englishLocalization
            language = "en"
        }

        "tr" -> {
            temp = turkishLocalization
            language = "tr"
        }

        else -> {
            temp = englishLocalization
            language = "en"
        }
    }
    return temp
}
