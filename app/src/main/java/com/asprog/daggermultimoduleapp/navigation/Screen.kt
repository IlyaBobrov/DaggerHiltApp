package com.asprog.daggermultimoduleapp.navigation

sealed class Screen(
    val route: String,
    val name: String
) {
    object App : Screen("App", "App")
    object AppScreen : Screen("AppScreen", "AppScreen")
    object HiltScreen : Screen("HiltScreen", "HiltScreen")
    object DaggerScreen : Screen("DaggerScreen", "DaggerScreen")
}