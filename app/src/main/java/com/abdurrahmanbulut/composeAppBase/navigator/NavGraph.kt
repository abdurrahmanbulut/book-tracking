package com.abdurrahmanbulut.composeAppBase.navigator

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.abdurrahmanbulut.composeAppBase.navigator.screen.Screen
import com.abdurrahmanbulut.composeAppBase.ui.main.MainScreen
import com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.detail.BookDetail
import com.abdurrahmanbulut.composeAppBase.ui.splash.SplashScreen
import com.abdurrahmanbulut.sherlock.navigation.EnterTransitionCallback
import com.abdurrahmanbulut.sherlock.navigation.ExitTransitionCallback
import com.abdurrahmanbulut.sherlock.navigation.Navigation
import com.abdurrahmanbulut.sherlock.navigation.toNavArg

fun NavGraphBuilder.navGraph() {
    screen(Screen.Splash.route) { SplashScreen() }
    screen(Screen.Main.route) { MainScreen() }
    screen(Screen.BookDetail.route) { BookDetail(it.toNavArg()) }
}

fun NavGraphBuilder.screen(
    route: String,
    enterTransition: EnterTransitionCallback? = Navigation.enterTransition,
    exitTransition: ExitTransitionCallback? = Navigation.exitTransition,
    popEnterTransition: EnterTransitionCallback? = Navigation.popEnterTransition,
    popExitTransition: ExitTransitionCallback? = Navigation.popExitTransition,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    composable(
        route = "$route?navArg={navArg}",
        arguments = listOf(navArgument("navArg") { nullable = true }),
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
        content = content,
    )
}
