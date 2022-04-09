package com.baseapp.base_ui_kit.icons

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.baseapp.base_ui_kit.R
import com.baseapp.base_ui_kit.utils.AppHelper.getEmojiCodeByString

@Composable
fun IconFont(
    iconFontName: String,
    color: Color,
    modifier: Modifier = Modifier,
    iconSize: TextUnit = 21.sp
) {
    BasicText(
        text = getEmojiCodeByString(iconFontName),
        modifier = modifier,
        style = TextStyle(
            color = color,
            fontFamily = FontFamily(Font(R.font.rsticons)),
            fontSize = iconSize
        )
    )
}