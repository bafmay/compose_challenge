package com.example.androiddevchallenge.ui.pet.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.ContactButton
import com.example.androiddevchallenge.utils.PuppyDataManager
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun OwnerContact(owner: String, petName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.ds_padding_large))
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(id = R.dimen.ds_padding_large)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = owner,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = stringResource(id = R.string.owner_label, petName),
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )
        }

        ContactButton(
            imageVector = Icons.Outlined.Message,
            buttonColor = Color(0xFF5FA1EB),
            backgroundColor = Color(0xFFF1F7FD)
        )

        Spacer(modifier = Modifier.size(16.dp))

        ContactButton(
            imageVector = Icons.Filled.Call,
            buttonColor = Color(0xFFE95952),
            backgroundColor = Color(0xFFFCEDEC)
        )
    }
}

@Preview
@Composable
fun OwnerContactPreview() {
    val pet = PuppyDataManager.pets.first()
    ThemedPreview {
        OwnerContact(
            owner = pet.owner,
            petName = stringResource(id = R.string.owner_label, pet.name)
        )
    }
}