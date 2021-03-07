package com.example.androiddevchallenge.utils

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
internal fun ThemedPreview(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MyTheme(darkTheme = darkTheme) {
        Surface(modifier = modifier) {
            content()
        }
    }
}