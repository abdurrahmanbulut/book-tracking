package com.abdurrahmanbulut.composeAppBase.ui.main

import HandleEvent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.abdurrahmanbulut.composeAppBase.navigator.screen
import com.abdurrahmanbulut.composeAppBase.navigator.screen.Screen
import com.abdurrahmanbulut.composeAppBase.ui.main.home.HomeScreen
import com.abdurrahmanbulut.composeAppBase.ui.navigator
import com.abdurrahmanbulut.sherlock.navigation.Navigation
import com.abdurrahmanbulut.sherlock.navigation.Navigator
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainScreen(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    screen(
        route = route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() },
        content = content,
    )
}

fun NavGraphBuilder.mainNavGraph(mainScreenVM: MainScreenVM) {
    mainScreen(Screen.Main.Home.route) { HomeScreen(mainScreenVM) }
//    mainScreen(Screen.Main.Settings.route) { SettingsScreen(mainScreenVM) }
}

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainScreenVM>()
    val navController = rememberNavController()

    Observe(viewModel)
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet =
            ConstraintSet {
                val navHost = createRefFor("navHost")
                val navigationBar = createRefFor("navigationBar")

                constrain(navHost) {
                    top.linkTo(parent.top)
                    bottom.linkTo(navigationBar.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                constrain(navigationBar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            },
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Main.Home.route,
            enterTransition = Navigation.enterTransition,
            exitTransition = Navigation.exitTransition,
            popEnterTransition = Navigation.popEnterTransition,
            popExitTransition = Navigation.popExitTransition,
            modifier = Modifier.layoutId("navHost"),
        ) {
            viewModel.navigator = Navigator(navController)
            mainNavGraph(viewModel)
        }
        NavigationBar(viewModel, Modifier.layoutId("navigationBar"))
    }
}

@Composable
fun Observe(viewmodel: MainScreenVM) {
    val navigator = navigator()
    HandleEvent(viewmodel.test1) {
    }

    HandleEvent(viewmodel.test2) { p1, p2 ->
    }
    HandleEvent(viewmodel.test3) { p1, p2, p3 ->
    }
}

@Composable
fun NavigationBar(
    viewmodel: MainScreenVM,
    modifier: Modifier,
) {
    Row(
        modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(100.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .zIndex(1f)
                    .background(Color.Blue)
                    .clickable { viewmodel.onClickFirst() },
        )
        Box(
            modifier =
                Modifier
                    .weight(1f)
                    .zIndex(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
                    .clickable { viewmodel.onClickSecond() },
        )
    }
}
