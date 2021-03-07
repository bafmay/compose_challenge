package com.example.androiddevchallenge.ui.home.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.ui.TitleSection
import com.example.androiddevchallenge.utils.PuppyDataManager
import com.example.androiddevchallenge.utils.ThemedPreview

@Composable
fun MenuOptions(menuItems: List<MenuItem>) {
    val selectedIndex = remember { mutableStateOf(0) }
    Column {
        TitleSection(title = stringResource(id = R.string.categories))
        LazyRow {
            itemsIndexed(menuItems) { index, item ->
                MenuItem(
                    menuItem = item,
                    isSelected = index == selectedIndex.value,
                    onClick = { selectedIndex.value = index }
                )
            }
        }
    }
}

@Composable
fun MenuItem(
    menuItem: MenuItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)

    ) {
        Image(
            painter = painterResource(id = menuItem.imageSrc),
            contentDescription = null,
            alpha = if (isSelected) 1f else 0.3f,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .clickable(onClick = onClick)

        )
        Text(
            text = menuItem.name,
            modifier = Modifier.padding(vertical = 8.dp),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center
        )
    }
}

@Preview("MenuOptionsPreview")
@Composable
fun MenuOptionsPreview() {
    ThemedPreview {
        MenuOptions(PuppyDataManager.menuItems)
    }
}

@Preview("MenuItemPreview")
@Composable
fun MenuItemPreview() {
    ThemedPreview {
        MenuItem(PuppyDataManager.menuItems.first(), true){}
    }
}