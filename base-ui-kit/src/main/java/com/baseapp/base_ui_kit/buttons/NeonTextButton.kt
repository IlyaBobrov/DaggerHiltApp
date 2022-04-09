package com.baseapp.base_ui_kit.buttons

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baseapp.base_ui_kit.theme.BaseAppTheme
import com.baseapp.base_ui_kit.theme.palette

@Composable
fun NeonTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val borderColor =
        if (enabled) MaterialTheme.palette.primary04
        else MaterialTheme.palette.grey06

    Button(
        modifier = modifier.height(40.dp),
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.palette.primary08,
            backgroundColor = MaterialTheme.palette.primary01,
            disabledBackgroundColor = MaterialTheme.palette.grey05,
            disabledContentColor = MaterialTheme.palette.grey11,
        ),
        border = BorderStroke(1.dp, borderColor),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = text,
            color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
            style = MaterialTheme.typography.body1.merge(TextStyle(fontWeight = FontWeight.Medium))
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark")
@Composable
private fun NeonTextButtonPreview() {
    BaseAppTheme {
        NeonTextButton(text = "Текст") {}
    }
}