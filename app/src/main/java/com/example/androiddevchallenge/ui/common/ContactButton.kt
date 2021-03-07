package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ContactButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    buttonColor: Color,
    backgroundColor: Color,
    onClick : () -> Unit = {}
) {
    IconButton(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(color = backgroundColor),
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = buttonColor
        )
    }
}