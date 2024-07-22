package com.abdurrahmanbulut.composeAppBase.ui.main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.composeAppBase.navigator.LocalInsets
import com.abdurrahmanbulut.composeAppBase.ui.LocalNavigator
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeScreenVM = koinViewModel()
    val navigator = LocalNavigator.current
    val insets = LocalInsets.current
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = insets.statusBarHeight)
                .clickable { navigator.pop() },
    ) {
        Text(
            text = viewModel.test,
            modifier = Modifier.padding(bottom = 20.dp),
        )
    }
}
