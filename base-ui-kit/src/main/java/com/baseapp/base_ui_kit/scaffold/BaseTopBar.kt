package com.baseapp.base_ui_kit.scaffold

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun BaseTopBar(
    titleString: String = "",
    elevation: Dp = 1.dp,
    background: Color = MaterialTheme.colors.background,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    onClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            AnimatedContent(targetState = titleString) { targetTitle ->
                Text(
                    text = targetTitle,
                    color = MaterialTheme.colors.onPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h3.merge(
                        TextStyle(fontWeight = FontWeight.SemiBold)
                    )
                )
            }
        },
        modifier = Modifier
            .focusable(false)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = { onClick() }
            ),
        backgroundColor = background,
        navigationIcon = navigationIcon,
        actions = actions,
        elevation = elevation
    )
}