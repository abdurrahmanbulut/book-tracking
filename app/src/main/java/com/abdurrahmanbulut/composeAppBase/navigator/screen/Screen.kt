package com.abdurrahmanbulut.composeAppBase.navigator.screen

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")

    data object Main : Screen("main") {
        data object Home : Screen("mainHome")
    }
}
