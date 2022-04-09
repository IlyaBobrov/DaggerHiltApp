package com.baseapp.base_ui_kit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val bigShape: Dp = 8.dp
private val mediumShape: Dp = 4.dp
private val smallShape: Dp = 2.dp

val Shapes = Shapes(
    small = RoundedCornerShape(smallShape),
    medium = RoundedCornerShape(mediumShape),
    large = RoundedCornerShape(bigShape)
)