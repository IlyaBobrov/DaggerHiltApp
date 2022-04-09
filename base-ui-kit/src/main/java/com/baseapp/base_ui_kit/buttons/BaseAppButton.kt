package com.baseapp.base_ui_kit.buttons

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.baseapp.base_ui_kit.theme.palette

@Composable
fun BaseAppButton(
    text: String,
    loading: Boolean = false,
    enabled: Boolean = true,
    height: Dp = 40.dp,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    paddingValues: PaddingValues = PaddingValues(0.dp),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .animateContentSize()
            .height(height),
        shape = shape,
        enabled = !loading && enabled,
        onClick = { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .animateContentSize()
                .fillMaxSize()
        ) {
            if (loading)
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .size(20.dp),
                    strokeWidth = 2.dp,
                )
            else
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(TextStyle(fontWeight = FontWeight.Medium)),
                    color = MaterialTheme.palette.grey04
                )
        }
    }
}