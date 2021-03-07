package com.example.androiddevchallenge.ui

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.ui.home.pets.Pet
import com.example.androiddevchallenge.ui.main.MainScreen
import com.example.androiddevchallenge.ui.onboarding.OnBoardingScreen
import com.example.androiddevchallenge.ui.pet.PetDetailScreen
import com.example.androiddevchallenge.utils.Routes
import com.example.androiddevchallenge.utils.hiltNavGraphViewModel
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@ExperimentalMaterialApi
@Composable
fun ComposeChallengeApp(
) {
    ProvideWindowInsets {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.onBoardingRoute) {
            composable(Routes.onBoardingRoute) {
                OnBoardingScreen(it.hiltNavGraphViewModel()) {
                    navController.navigate(route = Routes.homeRoute) {
                        popUpTo(Routes.onBoardingRoute) { inclusive = true }
                    }
                }
            }
            composable(
                Routes.homeRoute
            ) {
                MainScreen { pet ->
                    navController.currentBackStackEntry?.arguments?.putParcelable(
                        Routes.petItemId, pet
                    )
                    navController.navigate(route = Routes.petDetail)
                }
            }
            composable(Routes.petDetail) { _ ->
                val pet =
                    navController.previousBackStackEntry?.arguments?.getParcelable<Pet>(Routes.petItemId)

                pet?.let {
                    PetDetailScreen(
                        pet = it,
                        onBackPressed = { navController.navigateUp() })
                }

            }
        }
    }
}


