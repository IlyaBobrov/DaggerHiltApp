package com.baseapp.base_ui_kit.icons

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun IconButtonNavigateBack(onClick: () -> Unit) {
    IconButton(onClick = { onClick() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = MaterialTheme.colors.onPrimary,
            contentDescription = "Navigate back"
        )
    }
}

