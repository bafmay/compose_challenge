package com.example.androiddevchallenge.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.PageIndicator
import com.example.androiddevchallenge.utils.Pager
import com.example.androiddevchallenge.utils.PagerState
import com.example.androiddevchallenge.utils.PuppyDataManager
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel,
    onFinish: () -> Unit
) {
    val viewState by viewModel.state.observeAsState()
    viewModel.getOnBoardingItems()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ShowPager(
            state = viewState,
            onFinish = onFinish
        )
    }
}

@Composable
fun ShowPager(state: OnBoardingViewState?, onFinish: () -> Unit) {
    when (state) {
        is OnBoardingViewState.Success -> {
            val pagerState = remember { PagerState() }
            pagerState.maxPage = (state.items.size - 1).coerceAtLeast(0)
            Pager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) {
                val item = state.items[page]

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = item.backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    OnBoardingItem(
                        item,
                        modifier = Modifier.weight(1f),
                        onClick = {
                            if (pagerState.currentPage < state.items.size - 1)
                                pagerState.currentPage += 1
                            else
                                onFinish()
                        }
                    )

                    PageIndicator(
                        modifier = Modifier.padding(vertical = 16.dp),
                        pageCount = state.items.size,
                        currentPage = pagerState.currentPage,
                        color = Color.White
                    )
                }
            }
        }
        else -> CircularProgressIndicator()
    }

}

@Composable
fun OnBoardingItem(
    item: OnBoardingItem?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        CoilImage(
            data = item?.url.orEmpty(),
            contentDescription = null,
            modifier = Modifier
                .size(width = 250.dp, height = 250.dp),
            loading = {}
        )
        Text(
            text = item?.title.orEmpty(),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(vertical = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = item?.description.orEmpty(),
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )

        Button(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(width = 180.dp, height = 56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            onClick = onClick
        ) {
            Text(
                text = if (item?.page == 2) "Let's begin!" else "Next",
                style = MaterialTheme.typography.button,
                color = Color.Black
            )
        }
    }

}

@Preview
@Composable
fun OnBoardingItemPreview() {
    MyTheme {
        Surface {
            OnBoardingItem(PuppyDataManager.onBoardingItems.first()) {}
        }
    }
}