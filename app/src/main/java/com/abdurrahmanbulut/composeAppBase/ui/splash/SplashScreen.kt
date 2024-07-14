package com.abdurrahmanbulut.composeAppBase.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.composeAppBase.R
import com.abdurrahmanbulut.composeAppBase.navigator.screen.Screen
import com.abdurrahmanbulut.composeAppBase.ui.LocalNavigator
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen() {
    val navigator = LocalNavigator.current
    val viewModel: SplashViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        delay(3000)
        navigator.navigate(Screen.Home.route, TestData())
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Content()
    }
}

data class TestData(
    val a: Int = 5,
    val b: String = "text123",
    val c: Boolean = false,
)

@Composable
fun Content() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    LottieAnimation(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp),
        composition = composition,
    )
}
