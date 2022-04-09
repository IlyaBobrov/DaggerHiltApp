package com.asprog.daggermultimoduleapp.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.asprog.daggermultimoduleapp.navigation.Screen
import com.baseapp.base_ui_kit.extensions.padding
import com.baseapp.base_ui_kit.scaffold.BaseTopBar
import com.baseapp.base_ui_kit.scaffold.SpacerVertical

@ExperimentalAnimationApi
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = { BaseTopBar(titleString = "Main screen") }
    ) { paddings ->
        Column(
            modifier = Modifier
                .padding(paddings)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerVertical(height = 80.dp)
            Text(text = "App", style = MaterialTheme.typography.h2)
            SpacerVertical(height = 80.dp)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = {
                    navController.navigate(Screen.HiltScreen.route)
                }) {
                    Text(text = "Hilt feature")
                }
                Button(onClick = {
                    navController.navigate(Screen.DaggerScreen.route)
                }) {
                    Text(text = "Dagger feature")
                }
            }
        }
    }
}
