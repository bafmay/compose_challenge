package com.example.androiddevchallenge.ui.home.newpets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.ui.TitleSection
import com.example.androiddevchallenge.utils.PuppyDataManager
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun NewPetSection(newpets: List<NewPet>, onItemClick: (NewPet) -> Unit) {
    Column(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.ds_padding_large))) {
        TitleSection(
            title = stringResource(id = R.string.newest_pet_title),
            expandTitle = stringResource(id = R.string.view_all),
            onExpandClick = {}
        )

        LazyRow {
            item { Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.ds_padding_large))) }
            items(newpets) { newPet ->
                NewPetItem(
                    pet = newPet,
                    onItemClick = { onItemClick(newPet) })
            }
        }
    }
}

@Composable
fun NewPetItem(pet: NewPet, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(end = dimensionResource(id = R.dimen.ds_padding_large))
            .clickable(onClick = onItemClick),
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Image(
            painter = rememberImagePainter(pet.url),
            contentDescription = null,
            modifier = Modifier.height(200.dp),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black.copy(alpha = 0.5f))
        ) {

            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.ds_padding_normal))
            ) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = stringResource(
                        id = R.string.new_pet_label,
                        pet.city,
                        pet.distance.toString()
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption,
                    color = Color.White
                )
            }
        }

    }
}

@Preview
@Composable
fun NewPetSectionPreview() {
    ThemedPreview {
        NewPetSection(PuppyDataManager.newPets){}
    }
}

@Preview
@Composable
fun NewPetItemPreview() {
    Surface {
        NewPetItem(PuppyDataManager.newPets.first()){}
    }
}