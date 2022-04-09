package com.baseapp.base_ui_kit.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.zIndex
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.baseapp.base_ui_kit.shimmers.blinkingDynamicAlpha

@ExperimentalCoilApi
@Composable
fun ImageByUrl(
    modifier: Modifier = Modifier.fillMaxSize(),
    url: String? = null,
    contentDescription: String? = "Load url: $url",
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
)
//old version not animation
{
    var needShowShimmer: Boolean by remember { mutableStateOf(true) }

    Box(modifier = modifier) {
        Image(
            modifier = Modifier
                .zIndex(0.5F)
                .matchParentSize(),
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            painter = rememberImagePainter(
                data = url,
                onExecute = { previous, current ->
                    needShowShimmer = (current.state !is ImagePainter.State.Success)

                    ImagePainter.ExecuteCallback.Default.invoke(previous, current)
                },
                builder = {
                    crossfade(200) //анимация не сработает если картинка в кеше
                }),
        )

        if (needShowShimmer) {
            Box(
                Modifier
                    .zIndex(0.01F)
                    .matchParentSize()
                    .background(MaterialTheme.colors.onPrimary.copy(alpha = blinkingDynamicAlpha()))
            )
        }
    }
}
//new version with animation (не всегда включается шиммер)
/*{
    val context = LocalContext.current
    CompositionLocalProvider(LocalImageLoader provides ImageLoader(context)) {
        Box(
            Modifier
                .background(MaterialTheme.colors.onPrimary.copy(alpha = blinkingDynamicAlpha()))
        )
    }

    Box(modifier = modifier) {
        Image(
            modifier = Modifier.matchParentSize(),
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            painter = rememberImagePainter(
                data = url,
                builder = {
                    crossfade(200) //анимация не сработает если картинка в кеше
                }
            ),
        )
    }
}*/
