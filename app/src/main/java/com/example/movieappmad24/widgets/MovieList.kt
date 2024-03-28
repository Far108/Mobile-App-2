package com.example.movieappmad24.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.model.getMovies
import com.example.movieappmad24.navigation.Screen

@Composable
fun MovieList(padding: PaddingValues, navController: NavController) {
    val movies = getMovies()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        color = MaterialTheme.colorScheme.background

    ) {
        LazyColumn {
            items(movies) { movie ->
                MovieRow(movie) {
                    navController.navigate(Screen.Detail.createRoute(movie.id))
                }
            }
        }
    }
}