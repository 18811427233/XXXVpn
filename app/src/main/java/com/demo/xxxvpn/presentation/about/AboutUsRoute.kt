package com.demo.xxxvpn.presentation.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.xxxvpn.BuildConfig
import com.demo.xxxvpn.R
import com.demo.xxxvpn.core.ui.component.DefaultToolbar
import com.demo.xxxvpn.core.ui.preview.CombinedThemePreviews
import com.demo.xxxvpn.core.ui.theme.AppUITheme
import com.demo.xxxvpn.core.ui.theme.VpnThemePreview
import com.demo.xxxvpn.core.ui.R as RUI


const val aboutUsRoute = "aboutUs"

fun NavGraphBuilder.aboutUsScreen(
    onBackPressed: () -> Unit
) {
    composable(aboutUsRoute) {
        AboutUsRoute(onBackPressed = onBackPressed)
    }
}

fun NavController.navigateToAboutUs(navOptions: NavOptions? = null) {
    this.navigate(navOptions = navOptions, route = aboutUsRoute)
}

@Composable
internal fun AboutUsRoute(
    onBackPressed: () -> Unit
) {
    AboutUsScreen(onBackPressed = onBackPressed)
}

@Composable
fun AboutUsScreen(onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultToolbar(
            title = "About Us",
            icon = painterResource(id = RUI.drawable.ic_arrow_back)
        ) {
            onBackPressed()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 132.dp)
                    .size(96.dp),
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = "App Icon"
            )

            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = stringResource(id = R.string.app_name),
                color = AppUITheme.colors.textColorPrimary,
                style = AppUITheme.typography.headlineSmall
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = BuildConfig.VERSION_NAME,
                color = AppUITheme.colors.textColorPrimary,
                style = AppUITheme.typography.titleLarge
            )
        }

        Text(
            modifier = Modifier
                .padding(bottom = 22.dp),
            text = "Contact us\nmastervpnproxy2023@gmail.com",
            color = AppUITheme.colors.textColorSecondary,
            style = AppUITheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )
    }

}


@CombinedThemePreviews
@Composable
private fun AboutUsScreenPreview() {
    VpnThemePreview {
        AboutUsRoute(
            onBackPressed = {}
        )
    }
}