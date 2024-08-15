package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks.detail

import HandleEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.abdurrahmanbulut.composeAppBase.model.BookItem
import com.abdurrahmanbulut.composeAppBase.navigator.LocalInsets
import com.abdurrahmanbulut.composeAppBase.ui.main.home.Toolbar
import com.abdurrahmanbulut.composeAppBase.ui.navigator
import com.abdurrahmanbulut.composeAppBase.ui.theme.drawables
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun BookDetail(detail: BookItem?) {
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
    val volumeInfo = viewmodel.detail?.volumeInfo
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 12.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AsyncImage(
            model = viewmodel.detail?.volumeInfo?.imageLinks?.thumbnail?.replace(
                "http://",
                "https://"
            ),
            contentDescription = "",
            imageLoader = ImageLoader(context),
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),

            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextRow("Kitap Adı: ${volumeInfo?.title}")
        Spacer(modifier = Modifier.height(8.dp))

        val authors =  volumeInfo?.authors?.joinToString(separator = ", ")
        TextRow(text = "Yazar Adı: $authors")
        Spacer(modifier = Modifier.height(8.dp))

        val categories =  volumeInfo?.categories?.joinToString(separator = ", ")

        TextRow("Kitap Türü: $categories")

        Spacer(modifier = Modifier.height(8.dp))
        TextRow("Sayfa Sayısı: ${volumeInfo?.pageCount ?: "-"}")

        Spacer(modifier = Modifier.height(8.dp))
        TextRow("Yayınlanma Tarihi: ${volumeInfo?.publishedDate ?: "-"}")

        Spacer(modifier = Modifier.height(12.dp))

        TextRow(volumeInfo?.description, Modifier.heightIn(min = 160.dp))

    }
}

@Composable
fun TextRow(text: String?, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0XFFD0C7EA))
    ) {

        Text(text = text ?: "", modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
    }
}