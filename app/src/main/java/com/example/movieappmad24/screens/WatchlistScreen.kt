package com.example.movieappmad24.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.widgets.MovieList
import com.example.movieappmad24.widgets.SimpleBottomAppBar
import com.example.movieappmad24.widgets.SimpleTopAppBar

@Composable
fun WatchlistScreen(navController: NavController){
    Scaffold (
        topBar = { SimpleTopAppBar(title = "Watchlist")},
        bottomBar = { SimpleBottomAppBar(navController = navController)}
    )
    {
            padding ->
        MovieList(padding, navController)
    }
}