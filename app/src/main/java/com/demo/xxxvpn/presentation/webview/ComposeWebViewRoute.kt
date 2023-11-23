package com.demo.xxxvpn.presentation.webview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.demo.xxxvpn.core.ui.component.DefaultToolbar
import com.demo.xxxvpn.core.ui.theme.AppUITheme
import com.demo.xxxvpn.core.ui.R as RCoreUI

/**
 * Route for [ComposeWebViewRoute]
 */
internal const val composeWebViewRoute = "webView"
internal const val urlArg = "url"
internal const val titleArg = "title"

/**
 * Composable destination for [ComposeWebViewRoute]
 */
fun NavGraphBuilder.composeWebViewScreen(
    onBackIconPressed: () -> Unit
) {
    composable(
        route = "$composeWebViewRoute?${urlArg}={$urlArg}&${titleArg}={$titleArg}",
        arguments = listOf(
            navArgument(urlArg) {
                type = NavType.StringType
            },
            navArgument(titleArg) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        ComposeWebViewRoute(
            onBackIconPressed = onBackIconPressed,
            title = navBackStackEntry.arguments?.getString(titleArg).orEmpty(),
            urlToLoad = navBackStackEntry.arguments?.getString(urlArg).orEmpty()
        )
    }
}

/**
 * Navigation for [ComposeWebViewScreen]
 */
fun NavController.navigateToComposeWebView(
    url: String,
    title: String,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = "$composeWebViewRoute?${urlArg}=$url&${titleArg}=$title",
        navOptions = navOptions
    )
}

@Composable
fun ComposeWebViewRoute(
    onBackIconPressed: () -> Unit,
    title: String,
    urlToLoad: String,
) {
    ComposeWebViewScreen(
        urlToLoad = urlToLoad,
        title = title,
        onBackIconPressed = onBackIconPressed,
    )
}

@Composable
fun ComposeWebViewScreen(
    urlToLoad: String,
    title: String,
    onBackIconPressed: () -> Unit
) {
    var rememberWebProgress: Int by remember { mutableIntStateOf(-1) }

    Column(
        modifier = Modifier
            .background(AppUITheme.colors.backgroundColor)
            .fillMaxSize()
    ) {
        DefaultToolbar(
            title = title,
            icon = painterResource(id = RCoreUI.drawable.ic_arrow_back),
            onIconClicked = onBackIconPressed
        )

        LinearProgressIndicator(
            progress = rememberWebProgress * 1.0F / 100F,
            color = Color(0xFF6F4CFF),
            modifier = Modifier
                .fillMaxWidth()
                .height(if (rememberWebProgress == 100) 0.dp else 2.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .alpha(if (rememberWebProgress == 100) 1f else 0f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            CustomWebView(modifier = Modifier.fillMaxSize(),
                url = urlToLoad,
                onProgressChange = { progress ->
                    rememberWebProgress = progress
                },
                initSettings = { settings ->
                    settings?.apply {
                        //支持js交互
                        javaScriptEnabled = true
                        //....
                    }
                }, onBack = { webView ->
                    //可根据需求处理此处
                    if (webView?.canGoBack() == true) {
                        //返回上一级页面
                        webView.goBack()
                    } else {
                        //关闭activity
                        onBackIconPressed()
                    }
                })
        }
    }
}