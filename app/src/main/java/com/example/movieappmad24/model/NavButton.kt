package com.example.movieappmad24.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.movieappmad24.navigation.Screen

data class NavButton(val screen: Screen, val title: String, val icon: ImageVector)

fun getNavButtons(): List<NavButton>
{
    return listOf(
        NavButton(
            screen = Screen.Home,
            title = "Home",
            icon = Icons.Default.Home
        ),
        NavButton(
            screen = Screen.WatchList,
            title = "Watchlist",
            icon = Icons.Default.Star
        )
    )
}