package com.demo.xxxvpn.presentation.region

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.xxxvpn.R
import com.demo.xxxvpn.core.ui.component.DefaultToolbar
import com.demo.xxxvpn.core.ui.component.ErrorStateView
import com.demo.xxxvpn.core.ui.component.LoadingView
import com.demo.xxxvpn.core.ui.preview.CombinedThemePreviews
import com.demo.xxxvpn.core.ui.theme.AppUITheme
import com.demo.xxxvpn.core.ui.theme.VpnThemePreview
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.core.ui.R as RUI


const val regionRoute = "region"

fun NavGraphBuilder.regionScreen(
    onBackPressed: () -> Unit
) {
    composable(regionRoute) {
        RegionRoute(onBackPressed = onBackPressed)
    }
}

fun NavController.navigateToRegion(navOptions: NavOptions? = null) {
    this.navigate(navOptions = navOptions, route = regionRoute)
}

@Composable
internal fun RegionRoute(
    viewModel: RegionViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RegionScreen(
        uiState = uiState,
        onBackPressed = onBackPressed,
        selectRegionClick = viewModel::selectRegionClick
    )
}

@Composable
fun RegionScreen(
    uiState: RegionUIState,
    onBackPressed: () -> Unit,
    selectRegionClick: (Region?) -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultToolbar(
            title = "Select a country and region",
            icon = painterResource(id = RUI.drawable.ic_arrow_back)
        ) {
            onBackPressed()
        }

        if (!uiState.showError) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(uiState.regions?.size ?: 0) {
                    RegionItem(
                        region = uiState.regions?.get(it),
                        selectRegionClick = selectRegionClick,
                        onBackPressed = onBackPressed
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(62.dp)
            )
        } else {
            ErrorStateView(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                imageId = R.drawable.img_data_load_fail,
                title = context.getString(uiState.errorTitle),
                subTitle = context.getString(uiState.errorSubTitle),
                topBtnText = context.getString(uiState.errorBtnText),
                onTopBtnClick = uiState.errorClick,
            )
        }

        if (uiState.isLoading) {
            LoadingView()
        }
    }

}

@Composable
fun RegionItem(
    region: Region?,
    selectRegionClick: (Region?) -> Unit,
    onBackPressed: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                selectRegionClick(region)
                onBackPressed()
            }
            .padding(
                horizontal = AppUITheme.spacing.x16,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val icon = region?.id?.countryCardPair() ?: 0
        if (icon != 0) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        AppUITheme.colors.bannerSuccess,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = icon),
                contentDescription = "Region Icon",
            )
        } else {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xff6244f6)
                    )
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_global),
                    contentDescription = "Global",
                    tint = AppUITheme.colors.textColorPrimary
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f),
            text = region?.name.orEmpty(),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                color = AppUITheme.colors.textColorPrimary,
            )
        )
    }
}


@CombinedThemePreviews
@Composable
private fun AboutUsScreenPreview() {
    VpnThemePreview {
        RegionScreen(
            uiState = RegionUIState(),
            onBackPressed = {},
            selectRegionClick = {}
        )
    }
}