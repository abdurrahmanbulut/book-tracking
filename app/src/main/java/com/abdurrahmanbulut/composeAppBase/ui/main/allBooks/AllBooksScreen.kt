package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks

import HandleEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.abdurrahmanbulut.composeAppBase.navigator.LocalInsets
import com.abdurrahmanbulut.composeAppBase.navigator.screen.Screen
import com.abdurrahmanbulut.composeAppBase.ui.LocalNavigator
import com.abdurrahmanbulut.composeAppBase.ui.main.MainScreenVM
import com.abdurrahmanbulut.composeAppBase.ui.main.home.Toolbar
import com.abdurrahmanbulut.composeAppBase.ui.navigator
import org.koin.androidx.compose.koinViewModel

@Composable
fun AllBooksScreen(mainScreenVM: MainScreenVM) {
    val viewModel: AllBooksScreenVM = koinViewModel()
    val navigator = LocalNavigator.current
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
            Toolbar(viewModel.title, Modifier.padding(horizontal = 32.dp))
            Categories(viewModel)
            Content(viewModel)
        }
    }
}

@Composable
fun HandleEvents(viewmodel: AllBooksScreenVM) {
    val navigator = navigator()

    HandleEvent(eventHandler = viewmodel.navigateToDetail) {
        navigator.navigate(Screen.BookDetail.route, arg = it)
    }
}

@Composable
fun Categories(viewmodel: AllBooksScreenVM) {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)) {
        itemsIndexed(viewmodel.bookCategories) { index, item ->
            Box(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        end = if (index == viewmodel.bookCategories.lastIndex) 32.dp else 12.dp,
                        start = if (index == 0) 32.dp else 0.dp
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0XFFD0C7EA))
                    .clickable { viewmodel.onClickCategory(item) }
            ) {
                Text(text = item, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            }
        }
        item {
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun Content(viewmodel: AllBooksScreenVM) {
    val context = LocalContext.current


    LazyColumn(modifier = Modifier.padding(top = 4.dp, bottom = 12.dp)) {
        items(viewmodel.books?.items ?: emptyList()) {
            val detail = it.volumeInfo
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0XFFD0C7EA))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .clickable { viewmodel.onClickBook(it) },
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(Modifier.weight(0.5f)) {
                    Text(text = detail.title)
                    Text(text = detail.authors?.get(0) ?: "")
                    Text(text = detail.pageCount.toString() + " sayfa")
                }
                Spacer(modifier = Modifier.width(12.dp))
                AsyncImage(
                    model = detail.imageLinks?.thumbnail?.replace("http://", "https://"),
                    contentDescription = "",
                    imageLoader = ImageLoader(context),
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),

                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}
