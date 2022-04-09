package com.baseapp.base_ui_kit.forms.fields

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.baseapp.base_ui_kit.theme.palette
import com.google.accompanist.insets.navigationBarsWithImePadding

@Composable
fun textFieldColors() = TextFieldDefaults.textFieldColors(
    textColor = MaterialTheme.palette.grey20,
    disabledTextColor = MaterialTheme.palette.grey05,
    backgroundColor = MaterialTheme.palette.grey06,
    cursorColor = MaterialTheme.palette.grey20,
    errorCursorColor = MaterialTheme.palette.danger08,

    focusedIndicatorColor = MaterialTheme.palette.primary08,
    unfocusedIndicatorColor = MaterialTheme.palette.grey08,
    disabledIndicatorColor = MaterialTheme.palette.grey05,
    errorIndicatorColor = MaterialTheme.palette.danger08,

    leadingIconColor = MaterialTheme.palette.grey14,
    disabledLeadingIconColor = MaterialTheme.palette.grey05,
    errorLeadingIconColor = MaterialTheme.palette.danger08,

    trailingIconColor = MaterialTheme.palette.grey14,
    disabledTrailingIconColor = MaterialTheme.palette.grey05,
    errorTrailingIconColor = MaterialTheme.palette.danger08,

    focusedLabelColor = MaterialTheme.palette.grey20,
    unfocusedLabelColor = MaterialTheme.palette.grey14,
    disabledLabelColor = MaterialTheme.palette.grey05,
    errorLabelColor = MaterialTheme.palette.grey20,

    placeholderColor = MaterialTheme.palette.grey14,
    disabledPlaceholderColor = MaterialTheme.palette.grey05
)

@Composable
fun FormField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    contentError: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(
        topStart = 8.dp,
        topEnd = 8.dp,
        bottomEnd = 0.dp,
        bottomStart = 0.dp,
    ),
    isError: Boolean = false,
    colors: TextFieldColors = textFieldColors(),
) {
    val focusManager = LocalFocusManager.current

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.navigationBarsWithImePadding(),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions =
        if (ImeAction.Done == imeAction)
            KeyboardActions(onDone = { focusManager.clearFocus() })
        else
            keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
    )
    if (isError) contentError?.let { it() }
}