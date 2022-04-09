package com.baseapp.base_ui_kit.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.baseapp.base_ui_kit.theme.palette
import com.google.accompanist.placeholder.PlaceholderDefaults
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.color
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@ExperimentalCoilApi
@Composable
fun ImageByUrlLight(
    url: String?,
    modifier: Modifier,
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader(context)
    val request = ImageRequest.Builder(context)
        .data(url)
        .build()

    val painter = rememberImagePainter(
        request = request,
        imageLoader = imageLoader,
        onExecute = { previous, current ->
            ImagePainter.ExecuteCallback.Default.invoke(previous, current)
        }
    )

    val state = painter.state

    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
                .zIndex(1F)
                .placeholder(
                    visible = state is ImagePainter.State.Loading,
                    color = PlaceholderDefaults.color(
                        backgroundColor = MaterialTheme.palette.grey06,
                    ),
                    highlight = PlaceholderHighlight.shimmer(),
                ),
            contentScale = ContentScale.Crop
        )
    }

}