package com.baseapp.base_ui_kit.shimmers

import androidx.compose.animation.core.RepeatMode

object ShimmersConfig {
    const val initialValue = 0.07f
    const val targetValue = 1f
    const val durationMillis = 1000
    const val startValue = 0.2f
    const val endValue = 1000
    val repeatMode = RepeatMode.Reverse
}