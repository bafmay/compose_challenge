package com.example.androiddevchallenge.ui.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.label_profile),
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}