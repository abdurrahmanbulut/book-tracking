package com.abdurrahmanbulut.composeAppBase.navigator.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.abdurrahmanbulut.composeAppBase.ui.InsetsViewModel
import com.abdurrahmanbulut.composeAppBase.ui.LocalNavigator
import com.abdurrahmanbulut.sherlock.navigation.Navigation
import com.abdurrahmanbulut.sherlock.navigation.Navigator
import org.koin.androidx.compose.koinViewModel

val LocalInsets =
    compositionLocalOf<InsetsViewModel> { error("No InsetsViewModel provided") }

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navigator = remember { Navigator(navController) }
    val systemBarsPadding = WindowInsets.systemBars.asPaddingValues()
    val insets: InsetsViewModel = koinViewModel()

    insets.statusBarHeight = systemBarsPadding.calculateTopPadding()
    insets.navigationBarHeight = systemBarsPadding.calculateBottomPadding()

    CompositionLocalProvider(
        LocalNavigator provides navigator,
        LocalInsets provides insets,
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            enterTransition = Navigation.enterTransition,
            exitTransition = Navigation.exitTransition,
            popEnterTransition = Navigation.popEnterTransition,
            popExitTransition = Navigation.popExitTransition,
        ) {
            navGraph()
        }
    }
}
