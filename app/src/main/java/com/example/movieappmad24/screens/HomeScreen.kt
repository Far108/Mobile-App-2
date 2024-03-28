package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.widgets.MovieList
import com.example.movieappmad24.widgets.SimpleBottomAppBar
import com.example.movieappmad24.widgets.SimpleTopAppBar

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SimpleTopAppBar("Movie App")
        },
        bottomBar = {
            SimpleBottomAppBar(navController)
        }
    ) { paddingValue ->
        MovieList(paddingValue, navController)
    }
}



