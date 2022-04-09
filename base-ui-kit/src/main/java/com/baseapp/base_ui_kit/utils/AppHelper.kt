package com.baseapp.base_ui_kit.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.baseapp.base_ui_kit.theme.palette

object AppHelper {
    fun getEmojiCodeByString(key: String): String {
        val code = mapOfIcons[key]
        return code ?: "??"
    }

    fun getColorByCode(colorCode: String) = mapOfColors[colorCode] ?: Color.Black

    @Composable
    fun getColorByName(colorName: String?): Color = when (colorName) {
        "danger", "error" -> MaterialTheme.palette.danger08
        "success" -> MaterialTheme.palette.success08
        "warning" -> MaterialTheme.palette.warning08
        "info" -> MaterialTheme.palette.info08
        "primary" -> MaterialTheme.palette.primary08
        "secondary" -> MaterialTheme.palette.purple08
        "dark" -> MaterialTheme.palette.danger06
        "grey" -> MaterialTheme.palette.grey14
        else -> MaterialTheme.colors.onPrimary
    }

    @Composable
    fun getColorBackgroundByName(colorName: String?): Color = when (colorName) {
        "danger" -> MaterialTheme.palette.danger01
        "success" -> MaterialTheme.palette.success01
        "warning" -> MaterialTheme.palette.warning01
        "info" -> MaterialTheme.palette.info01
        "primary" -> MaterialTheme.palette.primary01
        "secondary" -> MaterialTheme.palette.purple01
        "dark" -> MaterialTheme.palette.danger06
        "grey" -> MaterialTheme.palette.grey06
        else -> MaterialTheme.colors.background
    }

}