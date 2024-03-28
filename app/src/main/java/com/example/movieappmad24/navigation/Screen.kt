package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    object Home: Screen("homeScreen")
    object Detail: Screen("detailScreen/{movieId}"){
        fun createRoute(movieId: String) = "detailScreen/${movieId}"
    }
    object WatchList: Screen("watchlistScreen")
}