package com.example.androiddevchallenge.ui.pet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun PetInfoItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    color: Color = Color.White,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        backgroundColor = color
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.ds_padding_large)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
            Text(
                text = description,
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PetInfoItemPreview() {
    ThemedPreview {
        PetInfoItem(title= "Male", description = "Sex", color = Color.Green)
    }
}