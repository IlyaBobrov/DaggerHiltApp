package com.baseapp.base_ui_kit.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGradient(isDarkTheme: Boolean, code: String): Brush {
    return getGradientMap(isDarkTheme)[code] ?: errorGradient
}

private fun getGradientMap(isDarkTheme: Boolean): Map<String, Brush> {
    return if (isDarkTheme) darkGradientMap else lightGradientMap
}

/**Градиент под наклоном 45 градусов*/
@Stable
fun Brush.Companion.tilted45DegreesGradient(
    colors: List<Color>
): Brush = linearGradient(
    colors = colors,
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

/**Градиент под наклоном 135 градусов*/
@Stable
fun Brush.Companion.tilted135DegreesGradient(
    colors: List<Color>
): Brush = linearGradient(
    colors = colors,
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
)

/**Настройка градиента*/
@Stable
fun Brush.Companion.tiltedGradient(
    colors: List<Color>
): Brush = Brush.tilted135DegreesGradient(
    colors = colors
)

val errorGradient = Brush.tiltedGradient(
    colors = listOf(
        Color(0xFFFFFFFF),
        Color(0xFF000000)
    )
)

val lightGradientMap = mapOf(
    "g-01" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFFFF3459),
            Color(0xFFB9493C)
        )
    ),
    "g-02" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF5B3CDC),
            Color(0xFF0CA9B3)
        )
    ),
    "g-03" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF0CE6E2),
            Color(0xFF5B1220)
        )
    ),
    "g-04" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF3E1451),
            Color(0xFFA788F5)
        )
    ),
    "g-05" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF98D9E4),
            Color(0xFFEE32B9)
        )
    ),
    "g-06" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF0AAD75),
            Color(0xFF617D85)
        )
    ),
    "g-07" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF415E8D),
            Color(0xFFD160D8)
        )
    ),
    "g-08" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF5371D4),
            Color(0xFF55E7D2)
        )
    ),
    "g-09" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF5E56F0),
            Color(0xFF1D2FA0)
        )
    ),
    "g-10" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFFE23817),
            Color(0xFFFC7411)
        )
    ),
    "g-11" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF485563),
            Color(0xFF29323C)
        )
    ),
    "g-12" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF457FCA),
            Color(0xFF5691C8)
        )
    ),
    "g-13" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFFFE8C00),
            Color(0xFFF83600)
        )
    ),
    "g-14" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFFAF5941),
            Color(0xFF7253A7)
        )
    ),
    "g-15" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF3875E4),
            Color(0xFFE124AA)
        )
    ),
    "g-16" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF558DEC),
            Color(0xFF2DB0D6)
        )
    ),
    "g-17" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF0718B6),
            Color(0xFF1E674A)
        )
    ),
    "g-18" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF1D976C),
            Color(0xFF93F9B9)
        )
    ),
    "g-19" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFFF09819),
            Color(0xFFEDDE5D)
        )
    ),
    "g-20" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF1A81FA),
            Color(0xFF0450AA)
        )
    )
)

val darkGradientMap = mapOf(
    "g-01" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF99001C),
            Color(0xFF1F0C0A)
        )
    ),
    "g-02" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF331B97),
            Color(0xFF097A81)
        )
    ),
    "g-03" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF0CE6E2),
            Color(0xFF5B1220)
        )
    ),
    "g-04" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF3E1451),
            Color(0xFFA788F5)
        )
    ),
    "g-05" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF98D9E4),
            Color(0xFFEE32B9)
        )
    ),
    "g-06" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF0AAD75),
            Color(0xFF617D85)
        )
    ),
    "g-07" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF101723),
            Color(0xFF791F7F)
        )
    ),
    "g-08" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF121F49),
            Color(0xFF138676)
        )
    ),
    "g-09" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF06042F),
            Color(0xFF1D2FA0)
        )
    ),
    "g-10" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF8B220E),
            Color(0xFFD95D03)
        )
    ),
    "g-11" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF15191E),
            Color(0xFF343F4C)
        )
    ),
    "g-12" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF254E83),
            Color(0xFF3A77B1)
        )
    ),
    "g-13" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFFe4a501),
            Color(0xFFe03100)
        )
    ),
    "g-14" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF8A4633),
            Color(0xFF5B4285)
        )
    ),
    "g-15" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF1647A2),
            Color(0xFF8B1368)
        )
    ),
    "g-16" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF1657C5),
            Color(0xFF11495A)
        )
    ),
    "g-17" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF051185),
            Color(0xFF1E674A)
        )
    ),
    "g-18" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF082B1F),
            Color(0xFF088C39)
        )
    ),
    "g-19" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF995f0a),
            Color(0xFFe5d01a)
        )
    ),
    "g-20" to Brush.tiltedGradient(
        colors = listOf(
            Color(0xFF161717),
            Color(0xFF1374A6)
        )
    )
)

