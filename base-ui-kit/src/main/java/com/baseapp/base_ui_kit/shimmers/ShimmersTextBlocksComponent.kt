package com.baseapp.base_ui_kit.shimmers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun ShimmersTextBlocksComponent(
    vararg shimmerTextParams: ShimmerTextParams
) {
    shimmerTextParams.forEach { textParams ->
        ShimmerTextBlock(
            fontSize = textParams.fontSize,
            linesCount = textParams.linesCount,
            padding = textParams.padding, //todo rudiment
            modifier = textParams.modifier
        )
    }
}

@Composable
private fun ShimmerTextBlock(
    fontSize: Int = 0,
    linesCount: Int = 1,
    padding: ShimmerBlockPadding,
    modifier: Modifier = Modifier
) {
    val modifierCard = if (modifier == Modifier) {
        Modifier
            .fillMaxWidth()
            .height((getTextHeightFromSpToDp(fontSize) * linesCount).dp)
            .padding(
                start = padding.start,
                top = padding.top,
                end = padding.end,
                bottom = padding.bottom
            )
            .clip(RoundedCornerShape(4.dp))
    } else
        modifier

    Card(
        elevation = 0.dp,
        modifier = modifierCard,
        shape = RoundedCornerShape(0.dp),
        content = {
            BoxShimmer()
        }
    )
}

fun getTextHeightFromSpToDp(sizeInSp: Int): Int = when (sizeInSp) {
    11 -> 13
    12 -> 16
    13 -> 18
    14 -> 20
    15 -> 22
    16 -> 24
    17 -> 22
    20 -> 24
    else -> (sizeInSp * 1.5).roundToInt()
}