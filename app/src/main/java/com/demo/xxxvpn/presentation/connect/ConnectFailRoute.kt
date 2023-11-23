package com.demo.xxxvpn.presentation.connect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.xxxvpn.R
import com.demo.xxxvpn.core.ui.component.DefaultToolbar
import com.demo.xxxvpn.core.ui.component.ErrorStateView
import com.demo.xxxvpn.core.ui.preview.CombinedThemePreviews
import com.demo.xxxvpn.core.ui.theme.VpnThemePreview
import com.demo.xxxvpn.core.ui.R as RUI


const val connectionFailRoute = "connectionFail"

fun NavGraphBuilder.connectionFailRoute(
    onBackPressed: () -> Unit,
    onNavigateToSelectRegion: () -> Unit,
    onNavigateToReconnect: () -> Unit,
) {
    composable(connectionFailRoute) {
        ConnectionFailRoute(
            onBackPressed = onBackPressed,
            onNavigateToSelectRegion = onNavigateToSelectRegion,
            onNavigateToReconnect = onNavigateToReconnect
        )
    }
}

fun NavController.navigateToConnectionFail(navOptions: NavOptions? = null) {
    this.navigate(navOptions = navOptions, route = connectionFailRoute)
}

@Composable
internal fun ConnectionFailRoute(
    onBackPressed: () -> Unit,
    onNavigateToSelectRegion: () -> Unit,
    onNavigateToReconnect: () -> Unit,
) {
    ConnectionFailScreen(
        onBackPressed = onBackPressed,
        onNavigateToSelectRegion = onNavigateToSelectRegion,
        onNavigateToReconnect = onNavigateToReconnect
    )
}

@Composable
fun ConnectionFailScreen(
    onBackPressed: () -> Unit,
    onNavigateToSelectRegion: () -> Unit,
    onNavigateToReconnect: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultToolbar(
            title = "Connected Failed",
            icon = painterResource(id = RUI.drawable.ic_arrow_back)
        ) {
            onBackPressed()
        }

        ErrorStateView(
            modifier = Modifier.fillMaxSize(),
            imageId = R.drawable.img_connect_fail,
            title = "Connection failed",
            subTitle = "you can choose",
            topBtnText = "Switch server",
            onTopBtnClick = onNavigateToSelectRegion,
            bottomBtnText = "Reconnect",
            onBottomBtnClick = onNavigateToReconnect
        )
    }

}


@CombinedThemePreviews
@Composable
private fun ConnectionFailPreview() {
    VpnThemePreview {
        ConnectionFailRoute(
            onBackPressed = {},
            onNavigateToSelectRegion = {},
            onNavigateToReconnect = {}
        )
    }
}