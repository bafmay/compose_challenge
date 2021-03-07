package com.example.androiddevchallenge.ui.pet.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.PuppyDataManager
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun PetInfoDetail(gender: String, age: Int, weight: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        PetInfoItem(
            modifier = Modifier.weight(1f),
            title = gender,
            description = "Sex",
            color = Color(0xFFE5F3CF)
        )
        Spacer(modifier = Modifier.size(24.dp))
        PetInfoItem(
            modifier = Modifier.weight(1f),
            title = stringResource(id = R.string.years_label, age),
            description = "Age",
            color = Color(0xFFFBE9C6)
        )
        Spacer(modifier = Modifier.size(24.dp))
        PetInfoItem(
            modifier = Modifier.weight(1f),
            title = stringResource(id = R.string.weight_label, weight),
            description = "Weight",
            color = Color(0xFFCAEAFD)
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Preview
@Composable
fun PetInfoDetailPreview() {
    val pet = PuppyDataManager.pets.first()
    ThemedPreview {
        PetInfoDetail(
            gender = pet.gender,
            age = pet.age,
            weight = pet.weight
        )
    }
}