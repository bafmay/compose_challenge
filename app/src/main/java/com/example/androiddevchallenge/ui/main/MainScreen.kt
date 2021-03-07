package com.example.androiddevchallenge.ui.main

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.favourite.FavouriteScreen
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.home.pets.Pet
import com.example.androiddevchallenge.ui.message.MessageScreen
import com.example.androiddevchallenge.ui.profile.ProfileScreen
import com.example.androiddevchallenge.utils.hiltNavGraphViewModel

@Composable
fun MainScreen(navigateTo: (Pet) -> Unit) {
    val navController = rememberNavController()
    val sections =
        listOf(MainSection.Home, MainSection.Favorite, MainSection.Chat, MainSection.Profile)
    Scaffold(
        bottomBar = { MainBottomNavigation(navController = navController, sections = sections) }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        NavHost(navController = navController, startDestination = MainSection.Home.route) {
            composable(MainSection.Home.route) {
                HomeScreen(it.hiltNavGraphViewModel(), modifier){ pet -> navigateTo(pet) }
            }
            composable(MainSection.Favorite.route) { FavouriteScreen(modifier) }
            composable(MainSection.Chat.route) { MessageScreen(modifier) }
            composable(MainSection.Profile.route) { ProfileScreen(modifier) }
        }
    }
}

@Composable
fun MainBottomNavigation(
    sections: List<MainSection>,
    navController: NavHostController
) {
    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        sections.forEach { section ->
            BottomNavigationItem(
                icon = { Icon(imageVector = section.icon, contentDescription = "") },
                label = { Text(stringResource(section.label)) },
                alwaysShowLabel = false,
                selected = currentRoute == section.route,
                onClick = {
                    navController.navigate(route = section.route) {
                        popUpTo(currentRoute.orEmpty()) { inclusive = true }
                    }
                }
            )
        }
    }
}

sealed class MainSection(val route: String, @StringRes val label: Int, val icon: ImageVector) {
    object Home : MainSection("home", R.string.label_home, Icons.Outlined.Home)
    object Profile : MainSection("profile", R.string.label_profile, Icons.Outlined.AccountCircle)
    object Favorite :
        MainSection("favorite", R.string.label_favorite, Icons.Outlined.FavoriteBorder)

    object Chat : MainSection("chat", R.string.label_chat, Icons.Outlined.Chat)
}