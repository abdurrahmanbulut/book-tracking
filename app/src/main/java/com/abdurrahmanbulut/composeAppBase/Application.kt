package com.abdurrahmanbulut.composeAppBase

import android.app.Application
import com.abdurrahmanbulut.composeAppBase.constants.DataStoreHelper
import com.abdurrahmanbulut.composeAppBase.constants.getInitialLocalizationStrings
import com.abdurrahmanbulut.composeAppBase.constants.localizationStrings
import com.abdurrahmanbulut.composeAppBase.di.apiModule
import com.abdurrahmanbulut.composeAppBase.di.repositoryModule
import com.abdurrahmanbulut.composeAppBase.di.viewmodelModule
import com.abdurrahmanbulut.composeAppBase.ui.theme.DrawablesLight
import com.abdurrahmanbulut.composeAppBase.ui.theme.drawables
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            val modules = listOf(repositoryModule, viewmodelModule, apiModule)
            androidLogger()
            androidContext(this@Application)
            koin.loadModules(modules)
        }

        val dataStoreHelper: DataStoreHelper by inject<DataStoreHelper>()
        drawables = DrawablesLight()
        MainScope().launch {
            localizationStrings = getInitialLocalizationStrings(dataStoreHelper = dataStoreHelper)
        }
    }
}
