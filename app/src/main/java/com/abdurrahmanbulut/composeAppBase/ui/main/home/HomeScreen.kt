package com.abdurrahmanbulut.composeAppBase.ui.main.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.abdurrahmanbulut.composeAppBase.navigator.LocalInsets
import com.abdurrahmanbulut.composeAppBase.ui.LocalNavigator
import com.abdurrahmanbulut.composeAppBase.ui.main.MainScreenVM
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(mainScreenVM: MainScreenVM) {
    val viewModel: HomeScreenVM = koinViewModel()
    val navigator = LocalNavigator.current
    val insets = LocalInsets.current
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(top = insets.statusBarHeight + 8.dp),
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Toolbar(viewModel.title, Modifier)

            Content()
        }
    }
}

@Composable
fun Content() {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        AsyncImage(
            model = "https://m.media-amazon.com/images/I/71oO1E-XPuL._AC_UF1000,1000_QL80_.jpg",
            contentDescription = "",
            imageLoader = ImageLoader(context),
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0XFFD0C7EA)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Kitap adı: Bişeyler", color = Color.Black)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0XFFD0C7EA)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Kitap yazarı: Bişeyler", color = Color.Black)
        }
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                progress = 80f,
                modifier = Modifier.size(120.dp),
                strokeWidth = 40f
            )

            Column(
                Modifier.width(120.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {

                Box(
                    modifier = Modifier
                        .height(52.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0XFFD0C7EA)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Sayfa Ekle", color = Color.Black)
                }
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .height(52.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0XFFD0C7EA)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Bitirdim", color = Color.Black)
                }
            }
        }
        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0XFFD0C7EA)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Başlama Tarihi : 01/01/2024", color = Color.Black)
        }


    }
}

@Composable
fun Toolbar(
    text: String,
    modifier: Modifier = Modifier,
    backIcon: Int? = null,
    onBack: (() -> Unit)? = null
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(52.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        backIcon?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "",
                Modifier
                    .size(40.dp)
                    .clickable { onBack?.invoke() })
            Spacer(modifier = Modifier.width(20.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0XFFD0C7EA)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = Color.Black)
        }
    }
}


@Composable
fun CircularProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Float = 8f
) {
    Box(
        modifier = modifier.size(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(120.dp)) {
            drawArc(
                color = Color(0XFFD0C7EA),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )

            val sweepAngle = progress * 360f / 100
            val color = Color.Green

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
        Text(
            text = "${progress.toInt()}%",
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}
