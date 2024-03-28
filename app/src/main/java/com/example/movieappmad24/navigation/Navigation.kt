package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen

@Composable
fun Navigation(){
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route){
            HomeScreen(navigationController)
        }
        composable(Screen.WatchList.route){
            WatchlistScreen(navigationController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(name="movieId"){type = NavType.StringType})
        ){
                backStackEntry -> DetailScreen(navigationController, movieId = backStackEntry.arguments?.getString("movieId"))
        }
    }
}