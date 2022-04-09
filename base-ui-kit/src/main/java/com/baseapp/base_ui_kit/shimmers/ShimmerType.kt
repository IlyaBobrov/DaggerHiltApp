package com.baseapp.base_ui_kit.shimmers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.baseapp.base_ui_kit.theme.palette

sealed class ShimmerType {
    companion object {
        val Default = AlphaBlinking
    }

    @Composable
    protected abstract fun getDefaultBoxModifier(): Modifier

    @Composable
    open fun ShimmerBox(modifier: Modifier = Modifier) {
        val defaultBoxModifier = getDefaultBoxModifier()

        Box(modifier = modifier.then(defaultBoxModifier))
    }

    object NonBlinking : ShimmerType() {
        @Composable
        override fun getDefaultBoxModifier() =
            Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.palette.grey10)
    }

    object AlphaBlinking : ShimmerType() {
        @Composable
        override fun getDefaultBoxModifier() =
            Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.onPrimary.copy(alpha = blinkingDynamicAlpha()))
    }
}
