package com.baseapp.base_ui_kit.shimmers

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun BoxShimmer(
    modifier: Modifier = Modifier
) {
    val defaultModifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.onPrimary.copy(alpha = blinkingDynamicAlpha()))

    Box(modifier = defaultModifier.then(modifier))
}

@Composable
fun blinkingDynamicAlpha(): Float {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = ShimmersConfig.initialValue,
        targetValue = ShimmersConfig.targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = ShimmersConfig.durationMillis
                ShimmersConfig.startValue at ShimmersConfig.endValue
            },
            repeatMode = ShimmersConfig.repeatMode
        )
    )
    return alpha
}