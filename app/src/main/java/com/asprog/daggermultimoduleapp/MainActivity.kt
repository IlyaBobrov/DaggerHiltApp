package com.asprog.daggermultimoduleapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asprog.daggermultimoduleapp.navigation.Screen
import com.asprog.daggermultimoduleapp.ui.MainScreen
import com.asprog.featuredagger.ui.previewScreen.DaggerPreviewScreen
import com.asprog.featurehilt.ui.previewScreen.HiltPreviewScreen
import com.baseapp.base_ui_kit.theme.BaseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.AppScreen.route,
                    route = Screen.App.route
                ) {
                    composable(route = Screen.AppScreen.route) {
                        MainScreen(navController)
                    }
                    composable(route = Screen.HiltScreen.route) {
                        HiltPreviewScreen()
                    }
                    composable(route = Screen.DaggerScreen.route) {
                        DaggerPreviewScreen()
                    }
                }
            }
        }
    }
}