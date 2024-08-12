package com.abdurrahmanbulut.composeAppBase.constants

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import java.util.Locale

object LanguageManager {
    private const val LANGUAGE_KEY = "language_key"

    fun setLocale(
        context: Context,
        language: String,
    ) {
        persistLanguage(context, language)
        updateResources(context, language)
    }

    private fun persistLanguage(
        context: Context,
        language: String,
    ) {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString(LANGUAGE_KEY, language).apply()
    }

    fun getLocale(context: Context): String {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        return prefs.getString(LANGUAGE_KEY, Locale.getDefault().language) ?: Locale.getDefault().language
    }

    private fun updateResources(
        context: Context,
        language: String,
    ) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res: Resources = context.resources
        val config: Configuration = res.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
    }
}
