package com.baseapp.base_ui_kit.buttons

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baseapp.base_ui_kit.theme.palette

@Composable
fun NeonIconAndTextButton(
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    paddingBetweenIconAndText: Dp = 4.dp,
    text: String,
    iconPosFirst: Boolean = false,
    onClick: () -> Unit = {},
) {
    val color =
        if (enabled) MaterialTheme.palette.primary08
        else MaterialTheme.palette.grey08
    NeonButton(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.animateContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconPosFirst) {
                Icon(imageVector = imageVector, tint = color, contentDescription = text)
                Text(
                    text = text,
                    color = color,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = paddingBetweenIconAndText)
                )
            } else {
                Text(
                    text = text,
                    color = color,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = paddingBetweenIconAndText)
                )
                Icon(imageVector = imageVector, tint = color, contentDescription = text)
            }
        }
    }
}