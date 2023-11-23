package com.demo.xxxvpn.presentation.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.demo.xxxvpn.presentation.about.aboutUsScreen
import com.demo.xxxvpn.presentation.about.navigateToAboutUs
import com.demo.xxxvpn.presentation.connect.connectionFailRoute
import com.demo.xxxvpn.presentation.connect.navigateToConnectionFail
import com.demo.xxxvpn.presentation.home.HomeViewModel.Companion.KEY_RECONNECT_FLAG
import com.demo.xxxvpn.presentation.home.homeRoute
import com.demo.xxxvpn.presentation.home.homeScreen
import com.demo.xxxvpn.presentation.region.navigateToRegion
import com.demo.xxxvpn.presentation.region.regionScreen
import com.demo.xxxvpn.presentation.webview.composeWebViewScreen
import com.demo.xxxvpn.presentation.webview.navigateToComposeWebView

private const val appGraph = "appGraph"

/**
 * Main NavGraph for the entire application
 * @param navHostController
 * You should add every feature NavGraph here
 */
@Composable
fun MainNavGraph(
    navHostController: NavHostController
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val slideDistance = rememberSlideDistance()

    AppScaffold(snackbarHostState) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navHostController,
            route = appGraph,
            startDestination = homeRoute,
            enterTransition = { materialSharedAxisXIn(!isRtl, slideDistance) },
            exitTransition = { materialSharedAxisXOut(!isRtl, slideDistance) },
            popEnterTransition = { materialSharedAxisXIn(isRtl, slideDistance) },
            popExitTransition = { materialSharedAxisXOut(isRtl, slideDistance) },
        ) {
            homeScreen(
                navigateToTellYourFriends = navHostController::navigateToComposeWebView,
                navigateToPrivacyPolicy = navHostController::navigateToComposeWebView,
                navigateToAboutUs = navHostController::navigateToAboutUs,
                navigateToRegion = navHostController::navigateToRegion,
                navigateToConnectFail = navHostController::navigateToConnectionFail
            )
            aboutUsScreen(onBackPressed = navHostController::popBackStack)
            regionScreen(onBackPressed = navHostController::popBackStack)
            connectionFailRoute(onBackPressed = navHostController::popBackStack,
                onNavigateToSelectRegion = {
                    navHostController.navigateToRegion(
                        navOptions = navOptions {
                            popUpTo(connectionFailRoute) { inclusive = true }
                        })
                },
                onNavigateToReconnect = {
                    navHostController.previousBackStackEntry?.savedStateHandle?.set(
                        KEY_RECONNECT_FLAG,
                        true
                    )
                    navHostController.popBackStack()
                })
            composeWebViewScreen(
                onBackIconPressed = navHostController::popBackStack,
            )
        }
    }
}