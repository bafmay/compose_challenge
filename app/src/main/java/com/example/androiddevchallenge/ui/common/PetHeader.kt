package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.PuppyDataManager
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun PetHeader(name: String, distance: Double, isFavourite: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.ds_padding_large)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(
                    id = R.string.distance_label,
                    distance.toString()
                ),
                style = MaterialTheme.typography.caption,
                color = Color.Black,
            )
        }
        IconButton(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = Color(0xFFF7F7F8)),
            onClick = {}
        ) {
            Icon(
                imageVector = if (isFavourite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                tint = Color.Red
            )
        }
    }
}

@Preview
@Composable
fun PetHeaderPreview() {
    val pet = PuppyDataManager.pets.first()
    ThemedPreview {
        PetHeader(name = pet.name, distance = pet.distance, isFavourite = pet.isFavourite)
    }
}