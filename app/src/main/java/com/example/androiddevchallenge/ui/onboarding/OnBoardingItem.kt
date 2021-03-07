package com.example.androiddevchallenge.ui.onboarding

import androidx.compose.ui.graphics.Color

data class OnBoardingItem(
    val page: Int,
    val title: String,
    val description: String,
    val backgroundColor: Color,
    val url: String
)
