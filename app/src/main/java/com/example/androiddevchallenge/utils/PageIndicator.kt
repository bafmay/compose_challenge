package com.example.androiddevchallenge.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.wrapContentSize()) {
        for (i in 0 until pageCount) {
            val (bgColor,width) = if(i == currentPage) {
                color to 16.dp
            }else{
                color.copy(alpha = 0.5f) to 4.dp
            }
            Spacer(
                modifier = Modifier
                    .padding(4.dp)
                    .size(width = width, height = 4.dp)
                    .background(color = bgColor,shape = RoundedCornerShape(50))
            )
        }
    }
}

@Preview("Page Indicator Preview")
@Composable
fun PageIndicatorPreview() {
    ThemedPreview(modifier=Modifier.fillMaxWidth()) {
        PageIndicator(pageCount = 3, currentPage = 0, color = Color.Red)
    }
}