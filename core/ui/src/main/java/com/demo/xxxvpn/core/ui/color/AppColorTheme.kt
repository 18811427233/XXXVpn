package com.demo.xxxvpn.core.ui.color

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun isLightTheme() = isSystemInDarkTheme().not()

/**
 * Brand Color
 */
@Composable
internal fun colorBrand(): Color = if (isLightTheme()) primary_600 else primary_500

/**
 * Text Color Primary for Composable
 */
@Composable
internal fun backgroundColor(): Color = /*if (isLightTheme()) white else*/ Color(0xff222222)

/**
 * Surface color variant 1
 */
@Composable
internal fun surfaceColorOne(): Color = if (isLightTheme()) neutral_025 else neutral_800

/**
 * Text Color Primary for Composable
 */
@Composable
internal fun textColorPrimary(): Color =/* if (isLightTheme()) neutral_800 else*/ neutral_050

/**
 * Text Color Secondary for Composable
 */
@Composable
internal fun textColorSecondary(): Color = /*if (isLightTheme()) neutral_600 else*/ neutral_300

/**
 * Text Color Accent for Composable
 */
@Composable
internal fun textColorAccent(): Color = if (isLightTheme()) accent_900 else accent_025

/**
 * Text Color Accent for Composable
 */
@Composable
internal fun textColorAccentInverse(): Color = if (isLightTheme()) accent_025 else accent_900

/**
 * Text Color Placeholder for Composable
 */
@Composable
internal fun textColorPlaceholder(): Color = if (isLightTheme()) neutral_600 else neutral_200

/**
 * Text Color Disabled for Composable
 */
@Composable
internal fun textColorDisabled(): Color = if (isLightTheme()) neutral_200 else neutral_500

/**
 * Background color for disabled
 */
@Composable
internal fun backgroundColorDisabled(): Color = if (isLightTheme()) black_010 else white_010


/**
 * Text Color Error for Composable
 */
@Composable
internal fun textColorError(): Color = if (isLightTheme()) error_600 else error_400

/**
 * Text Color Correct for Composable
 */
@Composable
internal fun textColorSuccess(): Color = if (isLightTheme()) success_600 else success_400

/**
 * Text Field Focus Border Color
 */
@Composable
internal fun borderColorFocused(): Color = if (isLightTheme()) accent_900 else accent_050

/**
 * Text Field Default Border Color
 */
@Composable
internal fun borderColorDefault(): Color = if (isLightTheme()) neutral_050 else neutral_800

/**
 * Disabled border color
 */
@Composable
internal fun borderColorDisabled(): Color = if (isLightTheme()) neutral_100 else neutral_700

/**
 * Button Primary background color
 */
@Composable
internal fun buttonColorPrimary(): Color = if (isLightTheme()) accent_900 else neutral_050

/**
 * Button Secondary background color
 */
@Composable
internal fun buttonColorSecondary(): Color = if (isLightTheme()) neutral_050 else neutral_700

/**
 * Button Primary background color
 */
@Composable
internal fun buttonColorPrimaryPressed(): Color = if (isLightTheme()) accent_600 else accent_200

/**
 * Button Primary text color
 */
@Composable
internal fun buttonTextColorPrimary(): Color = if (isLightTheme()) accent_025 else neutral_800

/**
 * Icon Primary color
 */
@Composable
internal fun iconColorPrimary(): Color = /*if (isLightTheme()) accent_900 else */white

/**
 * Icon Secondary color
 */
@Composable
internal fun iconColorSecondary(): Color = if (isLightTheme()) neutral_600 else neutral_300

/**
 * Link Primary color
 */
@Composable
internal fun linkColorPrimary(): Color = if (isLightTheme()) indigo_600 else indigo_400

/**
 * Link Pressed Primary color
 */
@Composable
internal fun linkColorPrimaryPressed(): Color = if (isLightTheme()) indigo_500 else indigo_300

/**
 * Notification Error color
 */
@Composable
internal fun notificationError(): Color = if (isLightTheme()) error_100 else error_900

/**
 * Notification Success color
 */
@Composable
internal fun notificationSuccess(): Color = if (isLightTheme()) success_100 else success_900

/**
 * Banner Info color
 */
@Composable
internal fun bannerInfo(): Color = if (isLightTheme()) blue_100 else blue_900

/**
 * Banner Success color
 */
@Composable
internal fun bannerSuccess(): Color = if (isLightTheme()) success_100 else success_900

/**
 * Banner Warning color
 */
@Composable
internal fun bannerWarning(): Color = if (isLightTheme()) warning_100 else warning_800

/**
 * Banner Error color
 */
@Composable
internal fun bannerError(): Color = if (isLightTheme()) error_100 else error_900

/**
 * Support Success color
 */
@Composable
internal fun supportSuccess(): Color = if (isLightTheme()) success_600 else success_500

/**
 * default avatar color
 */
@Composable
internal fun avatarColorDefault(): Color = if (isLightTheme()) red_600 else red_300

/**
 * Composable color [black] when light theme, [white] when dark theme
 */
@Composable
internal fun snackbarBackgroundColor(): Color = if (isLightTheme()) neutral_700 else neutral_200
