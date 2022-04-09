package com.baseapp.base_ui_kit.forms

import android.text.TextUtils
import android.util.Patterns
import androidx.core.text.isDigitsOnly
import java.util.regex.Pattern


val patternsPassword: Pattern =
    Pattern.compile("^(?=.*[0-9|a-z|A-Z|!|||@|#|&|(|)|–|[{|}]|:|;|'|,|?|*|~|\$|^|+|=|<|>]).{8,30}\$")

val patternsPhone: Pattern =
    Pattern.compile("^(?=.*[0-9]).{0,10}\$")

fun CharSequence?.isValidNameText(): Boolean =
    this != null && !TextUtils.isEmpty(this)

fun CharSequence?.isValidEmailText(): Boolean =
    this != null && !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun CharSequence?.isValidPasswordText(): Boolean =
    this != null && !TextUtils.isEmpty(this) && patternsPassword.matcher(this.toString()).matches()

fun CharSequence?.isValidPhoneText(): Boolean =
    this != null && !TextUtils.isEmpty(this) && this.toString().length == 10 &&
            this.toString().isDigitsOnly()