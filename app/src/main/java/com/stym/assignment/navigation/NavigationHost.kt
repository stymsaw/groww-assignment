package com.stym.assignment.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.stym.assignment.ui.details_screen.DetailsScreen
import com.stym.assignment.ui.main_screen.MainScreen
import com.stym.assignment.ui.splash_screen.SplashScreen

enum class Pages {
    SPLASH, HOME, DETAILS_SCREEN
}

@Composable
fun NavigationHost(navController: NavHostController) {


    NavHost(
        navController = navController, startDestination = Pages.SPLASH.name,
    ) {


        composable(route = Pages.SPLASH.name) { SplashScreen(navController = navController) }
        composable(route = Pages.HOME.name) { MainScreen(navController = navController) }
        composable(route = Pages.DETAILS_SCREEN.name) {
            DetailsScreen(navController = navController)
        }

    }

}

