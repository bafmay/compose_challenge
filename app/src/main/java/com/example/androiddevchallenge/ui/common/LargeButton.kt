package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun LargeButton(text: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.ds_padding_large)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF5A9FEA)),
        onClick = { }
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.ds_padding_normal)),
            color = Color.White,
            style = MaterialTheme.typography.caption,
        )
    }
}

@Preview
@Composable
fun LargeButtonPreview() {
    ThemedPreview {
        LargeButton(text = stringResource(id = R.string.adopt_me))
    }
}