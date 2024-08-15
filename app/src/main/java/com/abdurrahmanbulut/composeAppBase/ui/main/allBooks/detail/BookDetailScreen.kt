package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.detail

import HandleEvent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.abdurrahmanbulut.composeAppBase.model.VolumeInfo
import com.abdurrahmanbulut.composeAppBase.navigator.LocalInsets
import com.abdurrahmanbulut.composeAppBase.ui.main.home.Toolbar
import com.abdurrahmanbulut.composeAppBase.ui.navigator
import com.abdurrahmanbulut.composeAppBase.ui.theme.drawables
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun BookDetail(detail: VolumeInfo?) {
    val viewModel: BookDetailScreenVM = koinViewModel { parametersOf(detail) }
    val insets = LocalInsets.current

    HandleEvents(viewModel)
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(top = insets.statusBarHeight + 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxSize()) {
            Toolbar(
                viewModel.title,
                Modifier.padding(horizontal = 32.dp),
                drawables.back,
                onBack = viewModel::onBack
            )
            Content(viewModel)
        }
    }
}

@Composable
fun HandleEvents(viewmodel: BookDetailScreenVM) {
    val navigator = navigator()
   HandleEvent(eventHandler = viewmodel.onBack) {
       navigator.pop()
   }
}


@Composable
fun Content(viewmodel: BookDetailScreenVM) {


    val context = LocalContext.current
    Column(
        Modifier
            .padding(horizontal = 32.dp, vertical = 12.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = viewmodel.detail?.volumeInfo?.imageLinks?.thumbnail?.replace("http://", "https://") ,
            contentDescription = "",
            imageLoader = ImageLoader(context),
            modifier = Modifier.height(200.dp).clip(RoundedCornerShape(12.dp))
        )
        Text(text = viewmodel.detail?.volumeInfo?.description ?: "Detay yok")

    }
}