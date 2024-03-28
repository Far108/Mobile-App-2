package com.example.movieappmad24.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieappmad24.R
import com.example.movieappmad24.model.Movie

@Composable
fun MovieRowAnimatedContent(movie: Movie, clicked: Boolean, padding: Dp) {
    AnimatedVisibility(
        visible = clicked,
        enter = expandVertically(expandFrom = Alignment.Top),
        exit = shrinkVertically(),
        modifier = Modifier.padding(padding)
    ) {
        Column {
            Text(text = "Director: ${movie.director}")
            Text(text = "Released: ${movie.year}")
            Text(text = "Genre: ${movie.genre}")
            Text(text = "Actors: ${movie.actors}")
            Text(text = "Rating: ${movie.rating}")
            Divider(modifier = Modifier.padding(padding))
            Text(text = "Plot: ${movie.plot}")
            Spacer(modifier = Modifier.height(padding))
        }
    }
}

@Composable
fun ToggleArrow(clicked: Boolean) {
    if (clicked) {
        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Arrow down")
    } else {
        Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Arrow up")
    }
}

@Composable
fun MovieImage(imageLink: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageLink)
            .placeholder(R.drawable.movie_image)
            .build(),
        contentDescription = null,
        modifier = Modifier
            .height(150.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}){
    var clicked by remember {
        mutableStateOf(false)
    }

    val padding = 6.dp

    Card(
        modifier = Modifier
            .padding(padding)
            .clickable { onItemClick(movie.id) }
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                MovieImage(movie.images[0])
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(padding)
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
                    .clickable(onClick = { clicked = !clicked })
            ) {
                Text(text = movie.title)
                ToggleArrow(clicked)
            }
            MovieRowAnimatedContent(movie, clicked, padding)
        }
    }
}