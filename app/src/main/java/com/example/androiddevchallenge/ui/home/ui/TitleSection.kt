package com.example.androiddevchallenge.ui.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun TitleSection(title: String, expandTitle: String = "", onExpandClick: () -> Unit = {}) {
    Row(
        modifier = Modifier.padding(
            start = dimensionResource(id = R.dimen.ds_padding_large),
            bottom = dimensionResource(id = R.dimen.ds_padding_large),
            end = dimensionResource(id = R.dimen.ds_padding_large)
        )
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.weight(1f)
        )
        if (expandTitle.isNotEmpty())
            Row(
                modifier = Modifier.clickable(onClick = onExpandClick),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = expandTitle,
                    color = Color.Black,
                    modifier = Modifier.alpha(0.6f),
                    style = MaterialTheme.typography.caption
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(15.dp)
                )
            }

    }
}

@Preview
@Composable
fun TitleSectionPreview() {
    ThemedPreview {
        TitleSection("Pruebita", "View All") {}
    }
}