package com.baseapp.base_ui_kit.shimmers

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val SHIMMER_DEFAULT_TEXT_LINES = 1

class ShimmerBlockPadding(
    val start: Dp = 0.dp,
    val top: Dp = 0.dp,
    val end: Dp = 0.dp,
    val bottom: Dp = 0.dp,
)

data class ShimmerTextParams(
    val fontSize: Int = 16,
    val linesCount: Int = SHIMMER_DEFAULT_TEXT_LINES,
    val padding: ShimmerBlockPadding = ShimmerBlockPadding(),
    val modifier: Modifier = Modifier
)