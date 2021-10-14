package com.example.androiddevchallenge.ui.pet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.ContactButton
import com.example.androiddevchallenge.ui.common.LargeButton
import com.example.androiddevchallenge.ui.common.PetHeader
import com.example.androiddevchallenge.ui.home.pets.Pet
import com.example.androiddevchallenge.ui.pet.ui.OwnerContact
import com.example.androiddevchallenge.ui.pet.ui.PetDescription
import com.example.androiddevchallenge.ui.pet.ui.PetInfoDetail
import com.example.androiddevchallenge.utils.*

@ExperimentalMaterialApi
@Composable
fun PetDetailScreen(pet: Pet, onBackPressed: () -> Unit) {
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)
    BackdropScaffold(
        appBar = { },
        backLayerContent = { PetGalleryPager(pet, onBackPressed) },
        frontLayerContent = { PetDetailInformation(pet) },
        frontLayerScrimColor = Color.Transparent,
        peekHeight = 125.dp,
        backLayerBackgroundColor = Color.Transparent,
        scaffoldState = scaffoldState,
    )
}

@Composable
fun PetGalleryPager(pet: Pet, onBackPressed: () -> Unit) {
    val pagerState = remember { PagerState() }
    pagerState.maxPage = (pet.images.size - 1).coerceAtLeast(0)

    ConstraintLayout {
        val (pager, pageIndicator, backButton, moreInfo) = createRefs()

        Pager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .constrainAs(pager) {
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        top = parent.top,
                        bottom = parent.bottom
                    )
                },
        ) {
            val item = pet.images[page]
            Image(
                painter = rememberImagePainter(item),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        PageIndicator(
            modifier = Modifier.constrainAs(pageIndicator) {
                bottom.linkTo(
                    parent.bottom,
                    margin = 16.dp
                )
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            pageCount = pet.images.size,
            currentPage = pagerState.currentPage,
            color = Color.White
        )

        ContactButton(
            modifier = Modifier.constrainAs(backButton) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            },
            imageVector = Icons.Filled.ArrowBack,
            buttonColor = Color.Black,
            backgroundColor = Color.White,
            onClick = onBackPressed
        )

        ContactButton(
            modifier = Modifier.constrainAs(moreInfo) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            },
            imageVector = Icons.Filled.MoreHoriz,
            buttonColor = Color.Black,
            backgroundColor = Color.White
        )

    }

}

@Composable
fun PetDetailInformation(pet: Pet) {
    Column {
        PetHeader(
            name = pet.name,
            distance = pet.distance,
            isFavourite = pet.isFavourite
        )
        PetInfoDetail(
            gender = pet.gender,
            age = pet.age,
            weight = pet.weight
        )
        OwnerContact(
            owner = pet.owner,
            petName = pet.name
        )
        PetDescription(
            description = pet.description
        )
        LargeButton(
            text = stringResource(id = R.string.adopt_me)
        )

    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PetDetailScreenPreview() {
    ThemedPreview {
        PetDetailScreen(PuppyDataManager.pets.first()) {}
    }
}
