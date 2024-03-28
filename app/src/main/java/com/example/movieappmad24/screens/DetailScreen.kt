package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieappmad24.R
import com.example.movieappmad24.model.Movie
import com.example.movieappmad24.model.getMovies
import com.example.movieappmad24.widgets.DetailTopAppBar
import com.example.movieappmad24.widgets.MovieRow

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val movieById = getMovies().find { it.id == movieId }

    if (movieById == null) {
        navController.popBackStack()
    } else {
        Scaffold(
            topBar = { DetailTopAppBar(navController, movieById.title) }
        ) { paddingValue ->
            DetailScreenContent(movieById, paddingValue)
        }
    }
}


@Composable
fun DetailScreenContent(movie: Movie, paddingValues: PaddingValues) {
    Surface(
        modifier = Modifier.padding(paddingValues)
    ) {
        Column {
            MovieRow(movie = movie)
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            )
            {
                items(movie.images) { image ->
                    ImageCard(image)
                }

            }
        }
    }
}

@Composable
fun ImageCard(imageUrl: String) {
    val sideSize = 200.dp
    Card(
        modifier = Modifier
            .padding(6.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .placeholder(R.drawable.movie_image)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .height(sideSize)
                .width(sideSize), // don't sure about the height. looks like on task image
            contentScale = ContentScale.Crop
        )
    }
}