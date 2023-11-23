package com.demo.xxxvpn.core.ui.compose.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class Color(
    val colorBrand: Color,
    val backgroundColor: Color,
    val surfaceColorOne: Color,
    val snackbarColor: Color,
    val backgroundColorDisabled: Color,
    val textColorPrimary: Color,
    val textColorSecondary: Color,
    val textColorAccent: Color,
    val textColorAccentInverse: Color,
    val textColorError: Color,
    val textColorSuccess: Color,
    val textColorPlaceholder: Color,
    val textColorDisabled: Color,
    val borderColorFocused: Color,
    val borderColorDefault: Color,
    val borderColorDisabled: Color,
    val linkColorPrimary: Color,
    val linkColorPrimaryPressed: Color,
    val buttonColorPrimary: Color,
    val buttonColorPrimaryPressed: Color,
    val buttonTextColorPrimary: Color,
    val buttonColorSecondary: Color,
    val iconColorPrimary: Color,
    val iconColorSecondary: Color,
    val notificationError: Color,
    val notificationSuccess: Color,
    val supportSuccess: Color,
    val avatarColorDefault: Color,
    val bannerInfo: Color,
    val bannerSuccess: Color,
    val bannerWarning: Color,
    val bannerError: Color,
)