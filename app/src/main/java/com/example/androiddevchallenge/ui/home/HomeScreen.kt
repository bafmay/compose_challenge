package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.home.menu.MenuItemViewModel
import com.example.androiddevchallenge.ui.home.menu.MenuItemViewState
import com.example.androiddevchallenge.ui.home.menu.MenuOptions
import com.example.androiddevchallenge.ui.home.newpets.NewPetSection
import com.example.androiddevchallenge.ui.home.pets.Pet
import com.example.androiddevchallenge.ui.home.pets.PetSection
import com.example.androiddevchallenge.ui.home.ui.CustomAppBar
import com.example.androiddevchallenge.ui.home.ui.SearchSection
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.PuppyDataManager
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(
    viewModel: MenuItemViewModel,
    modifier: Modifier = Modifier,
    navigateToDetail: (Pet) -> Unit
) {
    viewModel.getMenuItems()
    val viewState by viewModel.state.observeAsState()
    Surface {
        HomeSection(modifier, viewState,navigateToDetail)
    }
}

@Composable
private fun HomeSection(
    modifier: Modifier = Modifier,
    viewState: MenuItemViewState?,
    navigateToDetail: (Pet) -> Unit
) {
    LazyColumn(modifier = modifier.statusBarsPadding()) {
        item { CustomAppBar() }
        item { ShowMenu(viewState) }
        item { SearchSection() }
        item { PetSection(pets = PuppyDataManager.pets,navigateToDetail) }
        item { NewPetSection(newpets = PuppyDataManager.newPets){} }
    }
}

@Composable
fun ShowMenu(state: MenuItemViewState?) {
    when (state) {
        is MenuItemViewState.Success -> MenuOptions(state.items)
        else -> CircularProgressIndicator()
    }
}

@Preview("MenuOptionsPreview")
@Composable
fun MenuOptionsPreview() {
    val viewState = MenuItemViewState.Success(PuppyDataManager.menuItems)
    MyTheme {
        HomeSection(viewState = viewState){}
    }
}