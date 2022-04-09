package com.baseapp.base_ui_kit.buttons

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baseapp.base_ui_kit.theme.BaseAppTheme
import com.baseapp.base_ui_kit.theme.palette

@Composable
fun NeonButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    withoutBorder: Boolean = false,
    elevation: ButtonElevation? = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
    content: @Composable RowScope.() -> Unit,
) {
    val borderColor =
        if (enabled) MaterialTheme.palette.primary04
        else MaterialTheme.palette.grey06
    val border = if (withoutBorder) {
        null
    } else {
        BorderStroke(1.dp, borderColor)
    }

    Button(
        modifier = modifier.height(40.dp),
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        elevation = elevation,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.palette.primary08,
            backgroundColor = MaterialTheme.palette.primary01,
            disabledBackgroundColor = MaterialTheme.palette.grey05,
            disabledContentColor = MaterialTheme.palette.grey11,
        ),
        border = border,
        content = content
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark")
@Composable
private fun NeonTextButtonPreview() {
    BaseAppTheme {
        NeonButton {}
    }
}