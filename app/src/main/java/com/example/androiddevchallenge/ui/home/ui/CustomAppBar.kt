package com.example.androiddevchallenge.ui.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun CustomAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier= Modifier.weight(1f)) {
            Row {
                Text(
                    text = "Location",
                    color= Color.Gray,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.alpha(0.6f)
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = null,
                    tint= Color.Black,
                    modifier = Modifier.size(15.dp)
                )
            }
            Row {
                Text(
                    text = "Lima, ",
                    color= Color.Black,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Perú",
                    color= Color.Black,
                    style = MaterialTheme.typography.h6
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.nala),
            contentDescription = null,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        )
    }
}