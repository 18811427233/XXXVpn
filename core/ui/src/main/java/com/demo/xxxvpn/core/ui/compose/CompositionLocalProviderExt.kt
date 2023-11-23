package com.demo.xxxvpn.core.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.demo.xxxvpn.core.ui.color.avatarColorDefault
import com.demo.xxxvpn.core.ui.color.backgroundColor
import com.demo.xxxvpn.core.ui.color.backgroundColorDisabled
import com.demo.xxxvpn.core.ui.color.bannerError
import com.demo.xxxvpn.core.ui.color.bannerInfo
import com.demo.xxxvpn.core.ui.color.bannerSuccess
import com.demo.xxxvpn.core.ui.color.bannerWarning
import com.demo.xxxvpn.core.ui.color.borderColorDefault
import com.demo.xxxvpn.core.ui.color.borderColorDisabled
import com.demo.xxxvpn.core.ui.color.borderColorFocused
import com.demo.xxxvpn.core.ui.color.buttonColorPrimary
import com.demo.xxxvpn.core.ui.color.buttonColorPrimaryPressed
import com.demo.xxxvpn.core.ui.color.buttonColorSecondary
import com.demo.xxxvpn.core.ui.color.buttonTextColorPrimary
import com.demo.xxxvpn.core.ui.color.colorBrand
import com.demo.xxxvpn.core.ui.color.iconColorPrimary
import com.demo.xxxvpn.core.ui.color.iconColorSecondary
import com.demo.xxxvpn.core.ui.color.linkColorPrimary
import com.demo.xxxvpn.core.ui.color.linkColorPrimaryPressed
import com.demo.xxxvpn.core.ui.color.notificationError
import com.demo.xxxvpn.core.ui.color.notificationSuccess
import com.demo.xxxvpn.core.ui.color.snackbarBackgroundColor
import com.demo.xxxvpn.core.ui.color.supportSuccess
import com.demo.xxxvpn.core.ui.color.surfaceColorOne
import com.demo.xxxvpn.core.ui.color.textColorAccent
import com.demo.xxxvpn.core.ui.color.textColorAccentInverse
import com.demo.xxxvpn.core.ui.color.textColorDisabled
import com.demo.xxxvpn.core.ui.color.textColorError
import com.demo.xxxvpn.core.ui.color.textColorPlaceholder
import com.demo.xxxvpn.core.ui.color.textColorPrimary
import com.demo.xxxvpn.core.ui.color.textColorSecondary
import com.demo.xxxvpn.core.ui.color.textColorSuccess
import com.demo.xxxvpn.core.ui.compose.model.Spacing
import com.demo.xxxvpn.core.ui.compose.model.Color as VPNColor

internal val LocalColorPalette = staticCompositionLocalOf {
    VPNColor(
        colorBrand = Color.Unspecified,
        backgroundColor = Color.Unspecified,
        surfaceColorOne = Color.Unspecified,
        snackbarColor = Color.Unspecified,
        backgroundColorDisabled = Color.Unspecified,
        textColorPrimary = Color.Unspecified,
        textColorSecondary = Color.Unspecified,
        textColorAccent = Color.Unspecified,
        textColorAccentInverse = Color.Unspecified,
        textColorSuccess = Color.Unspecified,
        textColorError = Color.Unspecified,
        textColorPlaceholder = Color.Unspecified,
        textColorDisabled = Color.Unspecified,
        borderColorFocused = Color.Unspecified,
        borderColorDefault = Color.Unspecified,
        linkColorPrimary = Color.Unspecified,
        linkColorPrimaryPressed = Color.Unspecified,
        buttonColorPrimary = Color.Unspecified,
        buttonColorPrimaryPressed = Color.Unspecified,
        buttonTextColorPrimary = Color.Unspecified,
        buttonColorSecondary = Color.Unspecified,
        borderColorDisabled = Color.Unspecified,
        iconColorPrimary = Color.Unspecified,
        iconColorSecondary = Color.Unspecified,
        notificationError = Color.Unspecified,
        notificationSuccess = Color.Unspecified,
        supportSuccess = Color.Unspecified,
        avatarColorDefault = Color.Unspecified,
        bannerInfo = Color.Unspecified,
        bannerSuccess = Color.Unspecified,
        bannerWarning = Color.Unspecified,
        bannerError = Color.Unspecified,
    )
}

internal val LocalSpacing = staticCompositionLocalOf {
    Spacing(
        x2 = Dp.Unspecified,
        x4 = Dp.Unspecified,
        x6 = Dp.Unspecified,
        x8 = Dp.Unspecified,
        x12 = Dp.Unspecified,
        x16 = Dp.Unspecified,
        x20 = Dp.Unspecified,
        x24 = Dp.Unspecified,
        x28 = Dp.Unspecified,
        x32 = Dp.Unspecified,
        x36 = Dp.Unspecified,
        x40 = Dp.Unspecified,
        x44 = Dp.Unspecified,
        x48 = Dp.Unspecified,
        x56 = Dp.Unspecified,
        x64 = Dp.Unspecified,
        x72 = Dp.Unspecified,
        x80 = Dp.Unspecified,
    )
}

@Composable
internal fun colorPalette() = VPNColor(
    colorBrand = colorBrand(),
    backgroundColor = backgroundColor(),
    surfaceColorOne = surfaceColorOne(),
    snackbarColor = snackbarBackgroundColor(),
    backgroundColorDisabled = backgroundColorDisabled(),
    textColorPrimary = textColorPrimary(),
    textColorSecondary = textColorSecondary(),
    textColorAccent = textColorAccent(),
    textColorAccentInverse = textColorAccentInverse(),
    textColorError = textColorError(),
    textColorSuccess = textColorSuccess(),
    textColorPlaceholder = textColorPlaceholder(),
    textColorDisabled = textColorDisabled(),
    borderColorFocused = borderColorFocused(),
    borderColorDefault = borderColorDefault(),
    linkColorPrimary = linkColorPrimary(),
    linkColorPrimaryPressed = linkColorPrimaryPressed(),
    buttonColorPrimary = buttonColorPrimary(),
    buttonColorPrimaryPressed = buttonColorPrimaryPressed(),
    buttonTextColorPrimary = buttonTextColorPrimary(),
    buttonColorSecondary = buttonColorSecondary(),
    borderColorDisabled = borderColorDisabled(),
    iconColorPrimary = iconColorPrimary(),
    iconColorSecondary = iconColorSecondary(),
    notificationError = notificationError(),
    notificationSuccess = notificationSuccess(),
    supportSuccess = supportSuccess(),
    avatarColorDefault = avatarColorDefault(),
    bannerInfo = bannerInfo(),
    bannerSuccess = bannerSuccess(),
    bannerWarning = bannerWarning(),
    bannerError = bannerError(),
)

internal val spacing = Spacing(
    x2 = 2.dp,
    x4 = 4.dp,
    x6 = 6.dp,
    x8 = 8.dp,
    x12 = 12.dp,
    x16 = 16.dp,
    x20 = 20.dp,
    x24 = 24.dp,
    x28 = 28.dp,
    x32 = 32.dp,
    x36 = 36.dp,
    x40 = 40.dp,
    x44 = 44.dp,
    x48 = 48.dp,
    x56 = 56.dp,
    x64 = 64.dp,
    x72 = 72.dp,
    x80 = 80.dp,
)