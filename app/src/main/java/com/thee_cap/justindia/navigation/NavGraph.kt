package com.thee_cap.justindia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thee_cap.justindia.ui.screens.StateScreen
import com.thee_cap.justindia.ui.screens.SpotListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "states") {
        composable("states") {
            StateScreen(navController)
        }
        composable("spots/{stateName}") { backStackEntry ->
            val stateName = backStackEntry.arguments?.getString("stateName") ?: ""
            SpotListScreen(stateName)
        }
    }
}
