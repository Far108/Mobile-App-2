package com.example.movieappmad24.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.navigation.Screen

@Composable
fun DetailTopAppBar(navController: NavController, title: String) {
    Box (
        modifier = Modifier.fillMaxWidth()
    ){
        SimpleTopAppBar(title = title)
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
        ){
            IconButton(
                onClick = {
                    // to avoid double click on back button
                    if (navController.currentDestination?.route != Screen.Home.route) {
                        navController.popBackStack()
                    }
                }
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back button")
            }
        }
    }
}