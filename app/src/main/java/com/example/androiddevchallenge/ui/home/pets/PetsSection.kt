package com.example.androiddevchallenge.ui.home.pets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.PetHeader
import com.example.androiddevchallenge.ui.home.ui.TitleSection
import com.example.androiddevchallenge.utils.PuppyDataManager
import com.example.androiddevchallenge.utils.ThemedPreview


@Composable
fun PetSection(pets: List<Pet>, navigateToDetail: (Pet) -> Unit) {

    Column(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.ds_padding_large))) {
        TitleSection(
            title = stringResource(id = R.string.adopt_pet_label),
            expandTitle = stringResource(id = R.string.view_all),
            onExpandClick = {}
        )

        LazyRow {
            item { Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.ds_padding_large))) }
            items(pets) { pet -> PetItem(pet = pet, onClick = { navigateToDetail(pet) }) }
        }
    }

}

@Composable
fun PetItem(pet: Pet, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(end = dimensionResource(id = R.dimen.ds_padding_large))
            .width(250.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
        ) {
            PetHeader(
                name = pet.name,
                distance = pet.distance,
                isFavourite = pet.isFavourite
            )
            Image(
                painter= rememberImagePainter( pet.images.first()),
                contentDescription = null,
                modifier = Modifier.height(150.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun PetSectionPreview() {
    ThemedPreview {
        PetSection(PuppyDataManager.pets) {}
    }
}

@Preview
@Composable
fun PetItemPreview() {
    ThemedPreview {
        PetItem(PuppyDataManager.pets.first()) {}
    }
}