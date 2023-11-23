package com.demo.xxxvpn.presentation.core

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Returns the provided [Dp] as an [Int] value by the [LocalDensity].
 *
 * @param slideDistance Value to the slide distance dimension, 30dp by default.
 */
@Composable
fun rememberSlideDistance(
): Int {
    val density = LocalDensity.current
    return remember(density, 30.dp) {
        with(density) { 30.dp.roundToPx() }
    }
}

private const val ProgressThreshold = 0.35f

private val Int.ForOutgoing: Int
    get() = (this * ProgressThreshold).toInt()

private val Int.ForIncoming: Int
    get() = this - this.ForOutgoing

/**
 * [materialSharedAxisXIn] allows to switch a layout with shared X-axis enter transition.
 *
 * @param forward whether the direction of the animation is forward.
 * @param slideDistance the slide distance of the enter transition.
 * @param durationMillis the duration of the enter transition.
 */
fun materialSharedAxisXIn(
    forward: Boolean,
    slideDistance: Int,
    durationMillis: Int = 300,
): EnterTransition = slideInHorizontally(
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing
    ),
    initialOffsetX = {
        if (forward) slideDistance else -slideDistance
    }
) + fadeIn(
    animationSpec = tween(
        durationMillis = durationMillis.ForIncoming,
        delayMillis = durationMillis.ForOutgoing,
        easing = LinearOutSlowInEasing
    )
)

/**
 * [materialSharedAxisXOut] allows to switch a layout with shared X-axis exit transition.
 *
 * @param forward whether the direction of the animation is forward.
 * @param slideDistance the slide distance of the exit transition.
 * @param durationMillis the duration of the exit transition.
 */
fun materialSharedAxisXOut(
    forward: Boolean,
    slideDistance: Int,
    durationMillis: Int = 300,
): ExitTransition = slideOutHorizontally(
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = FastOutSlowInEasing
    ),
    targetOffsetX = {
        if (forward) -slideDistance else slideDistance
    }
) + fadeOut(
    animationSpec = tween(
        durationMillis = durationMillis.ForOutgoing,
        delayMillis = 0,
        easing = FastOutLinearInEasing
    )
)