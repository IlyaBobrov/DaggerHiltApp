package com.baseapp.base_ui_kit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightColorPalette = lightColors(
    primary = LightPalette.primary08,
    primaryVariant = LightPalette.primary10,
    secondary = CommonColors.white,
    background = CommonColors.white,
    surface = CommonColors.white,
    onPrimary = LightPalette.grey20,
    onBackground = LightPalette.grey20,
    onSecondary = LightPalette.grey20,
    onSurface = LightPalette.grey20,
    error = LightPalette.danger08,
    onError = LightPalette.danger10
)

private val darkColorPalette = darkColors(
    primary = DarkPalette.primary08,
    primaryVariant = CommonColors.white,
    secondary = LightPalette.grey20,
    background = DarkPalette.grey01,
    surface = LightPalette.grey20,
    onPrimary = CommonColors.white,
    onSecondary = CommonColors.white,
    onBackground = CommonColors.white,
    onSurface = CommonColors.white,
    error = DarkPalette.danger08,
    onError = DarkPalette.danger10
)

inline val MaterialTheme.palette: ThemePalette
    @Composable get() =
        if (isSystemInDarkTheme()) DarkPalette else LightPalette

@Composable
fun BaseAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) darkColorPalette else lightColorPalette

    MaterialTheme(
        colors = colors,
        typography = TypographyFigma,
        shapes = Shapes,
        content = content
    )
}
