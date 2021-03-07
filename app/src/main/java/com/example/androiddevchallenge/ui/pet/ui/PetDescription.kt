package com.example.androiddevchallenge.ui.pet.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.example.androiddevchallenge.R

@Composable
fun PetDescription(description: String) {
    Text(
        text = description,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.ds_padding_large)),
        style = MaterialTheme.typography.caption,
        color = Color.Gray,
        textAlign = TextAlign.Justify
    )
}