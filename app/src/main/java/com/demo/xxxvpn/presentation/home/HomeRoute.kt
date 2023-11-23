package com.demo.xxxvpn.presentation.home

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.net.VpnService
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.xxxvpn.R
import com.demo.xxxvpn.core.ui.preview.CombinedThemePreviews
import com.demo.xxxvpn.core.ui.theme.AppUITheme
import com.demo.xxxvpn.core.ui.theme.VpnThemePreview
import com.demo.xxxvpn.data.UserFlowHelper
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.tunnel.ConnectState
import com.demo.xxxvpn.presentation.home.HomeViewModel.Companion.KEY_RECONNECT_FLAG
import com.demo.xxxvpn.presentation.region.countryCardPair
import com.example.myapplication.boxShadow
import de.palm.composestateevents.EventEffect
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.concurrent.TimeUnit
import com.demo.xxxvpn.core.ui.R as RCoreUI

/**
 * Route for [HomeRoute]
 */
internal const val homeRoute = "home"

/**
 * Composable destination for [HomeRoute]
 */
fun NavGraphBuilder.homeScreen(
    navigateToTellYourFriends: (url: String, title: String) -> Unit,
    navigateToPrivacyPolicy: (url: String, title: String) -> Unit,
    navigateToAboutUs: () -> Unit,
    navigateToRegion: () -> Unit,
    navigateToConnectFail: () -> Unit
) {
    composable(homeRoute) {
        HomeRoute(
            savedStateHandle = it.savedStateHandle,
            navigateToTellYourFriends = navigateToTellYourFriends,
            navigateToPrivacyPolicy = navigateToPrivacyPolicy,
            navigateToAboutUs = navigateToAboutUs,
            navigateToRegion = navigateToRegion,
            navigateToConnectFail = navigateToConnectFail
        )
    }
}

/**
 * Navigation for [HomeRoute]
 */
fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(navOptions = navOptions, route = homeRoute)
}

private const val COUNTER_INTERVAL = 1000L

enum class TransferType(var description: String) {
    Download("Download"),
    Upload("Upload"),
    LeftOver("Left Over"),
    CurrentUse("Current Use");
}

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    savedStateHandle: SavedStateHandle,
    navigateToTellYourFriends: (url: String, title: String) -> Unit,
    navigateToPrivacyPolicy: (url: String, title: String) -> Unit,
    navigateToAboutUs: () -> Unit,
    navigateToRegion: () -> Unit,
    navigateToConnectFail: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        savedStateHandle = savedStateHandle,
        navigateToTellYourFriends = navigateToTellYourFriends,
        navigateToPrivacyPolicy = navigateToPrivacyPolicy,
        navigateToAboutUs = navigateToAboutUs,
        navigationToRegion = navigateToRegion,
        navigateToConnectFail = navigateToConnectFail,
        navigateToShowAd = viewModel::showSpeedAd,
        onClickPointAccess = viewModel::onClickPointAccess,
        onStartVpnTunnelService = viewModel::toggleTunnel,
        onStopVpnTunnelService = viewModel::resetToNormalConnection,
        resetNotifySelectRegionEvent = viewModel::resetNotifySelectRegionEvent,
        resetConnectFailEvent = viewModel::resetConnectFailEvent,
        onDismissADDialog = viewModel::onDismissADDialog,
        onClickWatchAD = viewModel::onClickWatchAD
    )
}

@Composable
internal fun HomeScreen(
    uiState: HomeUIState,
    savedStateHandle: SavedStateHandle,
    navigateToTellYourFriends: (url: String, title: String) -> Unit,
    navigateToPrivacyPolicy: (url: String, title: String) -> Unit,
    navigateToAboutUs: () -> Unit,
    navigationToRegion: () -> Unit,
    navigateToConnectFail: () -> Unit,
    navigateToShowAd: () -> Unit,
    onClickPointAccess: () -> Unit,
    onStartVpnTunnelService: () -> Unit,
    onStopVpnTunnelService: () -> Unit,
    resetNotifySelectRegionEvent: () -> Unit,
    resetConnectFailEvent: () -> Unit,
    onDismissADDialog: () -> Unit,
    onClickWatchAD: () -> Unit
) {
    val context = LocalContext.current
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val vpnPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            if (it.resultCode == RESULT_OK) {
                onStartVpnTunnelService()
            }
        }
    )
    val connectFlag = savedStateHandle.getStateFlow(KEY_RECONNECT_FLAG, false)
        .collectAsStateWithLifecycle()
    if (connectFlag.value) {
        savedStateHandle.remove<Boolean>(KEY_RECONNECT_FLAG)
        onStartVpnTunnelService()
    }

    EventEffect(
        event = uiState.notifySelectRegionEvent,
        onConsumed = resetNotifySelectRegionEvent
    ) {
        navigationToRegion()
    }

    EventEffect(
        event = uiState.connectFailEvent,
        onConsumed = resetConnectFailEvent
    ) {
        navigateToConnectFail()
    }

    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        scrimColor = Color.Black.copy(alpha = 0.33f),
        drawerContent = {
            DrawerContentView(
                navigateToTellYourFriends = navigateToTellYourFriends,
                navigateToPrivacyPolicy = navigateToPrivacyPolicy,
                navigateToAboutUs = navigateToAboutUs,
            )
        },
        drawerState = drawerState
    ) {
        Box {
            Column {
                TopBarView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    clickDrawerListener = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                )

                VpnToggleView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    recommendRegion = uiState.selectRegion,
                    connectState = uiState.connectionHealth,
                    lastRunningTimeStamp = uiState.lastRunningTimeStamp,
                    downloadSpeed = uiState.downloadSpeed,
                    uploadSpeed = uiState.uploadSpeed,
                    useFlow = uiState.useFlow,
                    rewardCount = uiState.rewardCount,
                    rewardFlow = uiState.rewardFlow,
                    rewardName = uiState.rewardName,
                    flow = uiState.flow,
                    showAD = uiState.showAD,
                    onClickConnectVPN = {
                        context.prepareVpnConnection(
                            onPermissionDenied = {
                                vpnPermissionLauncher.launch(it)
                            },
                            onPermissionGranted = {
                                when (uiState.connectionHealth) {
                                    is ConnectState.Disconnected -> {
                                        onStartVpnTunnelService()
                                    }

                                    else -> onStopVpnTunnelService()
                                }
                            }
                        )
                    },
                    navigationToRegion = navigationToRegion,
                    onClickPointAccess = onClickPointAccess,
                    navigateToShowAd = navigateToShowAd
                )

            }

            if (uiState.showADDialog) {
                WatchADDialog(onDismiss = {
                    onDismissADDialog()
                }, onClickWatchAD = {
                    onClickWatchAD()
                })
            }
        }
    }
}

@Composable
fun DrawerContentView(
    navigateToTellYourFriends: (url: String, title: String) -> Unit,
    navigateToPrivacyPolicy: (url: String, title: String) -> Unit,
    navigateToAboutUs: () -> Unit,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .width(280.dp)
            .fillMaxHeight()
            .background(AppUITheme.colors.backgroundColor)
            .padding(top = 28.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable {
                    context.openGPStore()
                }
                .padding(horizontal = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_tell_your_friend),
                contentDescription = "Tell your friends",
                tint = AppUITheme.colors.iconColorPrimary
            )

            Text(
                modifier = Modifier.padding(start = 14.dp),
                text = "Tell your friends",
                style = TextStyle(fontSize = 16.sp),
                color = AppUITheme.colors.textColorPrimary
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navigateToPrivacyPolicy(
                        "https://app.mastervpnapp.com/",
                        "Privacy policy"
                    )
                }
                .height(60.dp)
                .padding(horizontal = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_privacy_policy),
                contentDescription = "Privacy policy",
                tint = AppUITheme.colors.iconColorPrimary
            )

            Text(
                modifier = Modifier.padding(start = 14.dp),
                text = "Privacy policy",
                style = TextStyle(fontSize = 16.sp),
                color = AppUITheme.colors.textColorPrimary
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clickable {
                    navigateToAboutUs()
                    Toast
                        .makeText(context, "navigateToAboutUs", Toast.LENGTH_LONG)
                        .show();
                }
                .padding(horizontal = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_about_us),
                contentDescription = "About us",
                tint = AppUITheme.colors.iconColorPrimary
            )

            Text(
                modifier = Modifier.padding(start = 14.dp),
                text = "About us",
                style = TextStyle(fontSize = 16.sp),
                color = AppUITheme.colors.textColorPrimary
            )
        }
    }
}

@Composable
fun TopBarView(
    modifier: Modifier,
    clickDrawerListener: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp),
            onClick = {
                clickDrawerListener()
            }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = AppUITheme.colors.textColorPrimary
            )
        }

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = stringResource(id = R.string.app_name),
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppUITheme.colors.textColorPrimary
            )
        )
    }
}

@Composable
fun VpnToggleView(
    onClickConnectVPN: () -> Unit,
    navigationToRegion: () -> Unit,
    navigateToShowAd: () -> Unit,
    onClickPointAccess: () -> Unit,
    modifier: Modifier,
    recommendRegion: Region?,
    connectState: ConnectState,
    lastRunningTimeStamp: Long,
    downloadSpeed: String,
    uploadSpeed: String,
    useFlow: String,
    rewardFlow: String,
    rewardName: String,
    rewardCount: Int,
    flow: String,
    showAD: Boolean,
) {
    var elapsedTime by remember { mutableLongStateOf(0L) }

    LaunchedEffect(key1 = lastRunningTimeStamp) {
        var currentTimeInMillis = Calendar.getInstance().timeInMillis

        while (lastRunningTimeStamp > 0) {
            elapsedTime = currentTimeInMillis - lastRunningTimeStamp
            currentTimeInMillis += COUNTER_INTERVAL
            delay(COUNTER_INTERVAL)
        }

        elapsedTime = 0
    }

    Column(
        modifier = modifier.padding(top = AppUITheme.spacing.x24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
            ),
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    navigationToRegion()
                },
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(
                        vertical = AppUITheme.spacing.x12,
                        horizontal = AppUITheme.spacing.x16
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val icon = recommendRegion?.id?.countryCardPair() ?: 0
                if (icon != 0) {
                    Image(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        painter = painterResource(id = icon),
                        contentDescription = "Menu",
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
                    modifier = Modifier.padding(start = 16.dp),
                    text = recommendRegion?.name ?: "Select Server",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = AppUITheme.colors.textColorPrimary
                    )
                )
            }
        }

        Text(
            modifier = Modifier
                .alpha(if (connectState is ConnectState.Connected) 1f else 0f),
            text = elapsedTime.toElapsedTimeFormat(),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(900),
                color = AppUITheme.colors.textColorPrimary,
                textAlign = TextAlign.Center,
                letterSpacing = 0.1.sp,
            )
        )

        VpnToggleCircleView(
            connectState = connectState,
            onClickConnectVPN = onClickConnectVPN
        )

        BottomSpace(
            showBottom = connectState is ConnectState.Connected,
            showAD = showAD,
            onClickBandWidthAd = navigateToShowAd,
            onClickPointAccess = onClickPointAccess,
            downloadSpeed = downloadSpeed,
            useFlow = useFlow,
            rewardCount = rewardCount,
            rewardName = rewardName,
            rewardFlow = rewardFlow,
            flow = flow,
            uploadBytes = uploadSpeed
        )

    }
}

@Composable
fun BottomSpace(
    showBottom: Boolean,
    showAD: Boolean,
    onClickBandWidthAd: () -> Unit,
    onClickPointAccess: () -> Unit,
    downloadSpeed: String,
    useFlow: String,
    rewardFlow: String,
    rewardName: String,
    rewardCount: Int,
    flow: String,
    uploadBytes: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(1f)
            .padding(top = AppUITheme.spacing.x16)
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        val isButtonPressed by interactionSource.collectIsPressedAsState()
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            TransferStatisticItem(
                modifier = Modifier
                    .width(120.dp)
                    .clickable(
                        onClick = {

                        }
                    )
                    .wrapContentHeight(),
                transferType = TransferType.LeftOver,
                formattedBandwidth = if (flow.isEmpty()) "0 KB" else flow

            )
            TransferStatisticItem(
                modifier = Modifier
                    .padding(start = AppUITheme.spacing.x16)
                    .width(120.dp)
                    .wrapContentHeight(),
                transferType = TransferType.CurrentUse,
                formattedBandwidth = if (useFlow.isEmpty()) "0 KB" else useFlow
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(1f)
            .padding(top = AppUITheme.spacing.x40)
            .padding(horizontal = 52.dp)
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        val isButtonPressed by interactionSource.collectIsPressedAsState()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(1f)
                .height(60.dp)
                .background(
                    color = if (isButtonPressed) Color(0xFF5144E9) else Color(0xFF5144E9),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable(
                    onClick = {

                        onClickPointAccess()

                    },
                    indication = null,
                    interactionSource = interactionSource
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = R.drawable.icon_reward_ad),
                contentDescription = "Watch AD"
            )

            Text(
                modifier = Modifier.padding(horizontal = AppUITheme.spacing.x8),
                text = "+" + rewardFlow,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.5.sp,
                )
            )

            Image(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = R.drawable.icon_reward_paly),
                contentDescription = "Watch AD"
            )

        }

        Box(
            modifier = Modifier
                .width(26.dp)
                .align(Alignment.TopEnd)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(13.dp)
                )
                .height(26.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                text = rewardCount.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF5144E9)
                )
            )

        }

    }
    Text(
        modifier = Modifier
            .wrapContentWidth()
            .padding(top = AppUITheme.spacing.x6)
            .wrapContentHeight(),
        text = rewardName,
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFFFFFFFF)
        )
    )

//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .alpha(1f)
//            .padding(top = AppUITheme.spacing.x40)
//    ) {
//        val interactionSource = remember { MutableInteractionSource() }
//        val isButtonPressed by interactionSource.collectIsPressedAsState()
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .alpha(if (showAD) 1f else 0f)
//                .padding(horizontal = 52.dp)
//                .border(
//                    width = 2.dp,
//                    color = if (isButtonPressed) Color(0x806F4CFF) else Color(0xFF6F4CFF),
//                    shape = RoundedCornerShape(9.dp)
//                )
//                .background(
//                    color = if (isButtonPressed) Color(0x804E4E4E) else Color(0xFF4E4E4E),
//                    shape = RoundedCornerShape(8.dp)
//                )
//                .clickable(
//                    onClick = {
//                        if (showBottom && showAD) {
//                            onClickBandWidthAd()
//                        }
//                    },
//                    indication = null,
//                    interactionSource = interactionSource
//                ),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                modifier = Modifier
//                    .size(72.dp)
//                    .padding(start = 4.dp),
//                painter = painterResource(id = R.drawable.img_watch_ad),
//                contentDescription = "Watch AD"
//            )
//
//            Text(
//                modifier = Modifier.padding(horizontal = AppUITheme.spacing.x8),
//                text = "View current speed after browsing advertisements",
//                style = TextStyle(
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight(400),
//                    color = Color(0xFFFFFFFF),
//                    letterSpacing = 0.5.sp,
//                )
//            )
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .alpha(1f),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            TransferStatisticItem(
//                modifier = Modifier
//                    .width(120.dp)
//                    .wrapContentHeight(),
//                transferType = TransferType.Download,
//                formattedBandwidth = downloadSpeed
//            )
//
//            TransferStatisticItem(
//                modifier = Modifier
//                    .padding(start = AppUITheme.spacing.x16)
//                    .width(120.dp)
//                    .wrapContentHeight(),
//                transferType = TransferType.Upload,
//                formattedBandwidth = uploadBytes
//            )
//        }
//    }
}

@Composable
fun VpnToggleCircleView(
    connectState: ConnectState,
    onClickConnectVPN: () -> Unit
) {
    val rotate = rememberInfiniteTransition(label = "Rotate")
    val rotationAnimValue by rotate.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                2000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ), label = "Rotate"
    )
    val blur = rememberInfiniteTransition(label = "Blur")
    val blurAnimValue by blur.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "Blur"
    )

    Box(
        modifier = Modifier
            .padding(top = AppUITheme.spacing.x20)
            .wrapContentSize()
    ) {
        Canvas(
            modifier = Modifier
                .size(240.dp),
        ) {
            val size = size.width.coerceAtMost(size.height) // 取Canvas宽高中较小的值
            val center = Offset(size / 2, size / 2)
            val radius = (size - 40.dp.value) / 2 // 考虑线条宽度

            if (connectState == ConnectState.Connecting) {
                val gradientBrush = Brush.sweepGradient(
                    colors = listOf(Color.Transparent, Color(0Xff5144E9)),
                )
                val rotationAngle = rotationAnimValue * 360f
                rotate(rotationAngle, pivot = center) {
                    drawCircle(
                        brush = gradientBrush,
                        center = center,
                        radius = radius,
                        style = Stroke(
                            width = 20.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    )
                }
            } else {
                val color =
                    if (connectState == ConnectState.Disconnected) 0xff2E2F3C else 0Xff5144E9
                drawCircle(
                    color = Color(color), // 圆环的颜色
                    center = center,
                    radius = radius,
                    style = Stroke(
                        width = 20.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
        }
        val blurRadius = (blurAnimValue * 36).toInt()
        val alpha = if (connectState is ConnectState.Disconnected) 0.3f else 0.5f

        Box(
            Modifier
                .size(176.dp)
                .boxShadow(
                    clip = true,
                    color = Color(0xff5282FF).copy(alpha = alpha),
                    shape = RoundedCornerShape(88.dp),
                    blurRadius = blurRadius.dp
                )
                .align(Alignment.Center)
        )

        val interactionSource = remember { MutableInteractionSource() }
        val isButtonPressed by interactionSource.collectIsPressedAsState()
        val brush = when {
            isButtonPressed -> Brush.verticalGradient(
                listOf(
                    Color(0xff3124C6),
                    AppUITheme.colors.backgroundColor
                )
            )

            else -> Brush.verticalGradient(
                listOf(
                    Color(0xff5144E9),
                    AppUITheme.colors.backgroundColor
                )
            )
        }

        Column(
            Modifier
                .size(176.dp)
                .clip(RoundedCornerShape(88.dp))
                .background(
                    brush = brush,
                    shape = RoundedCornerShape(88.dp)
                )
                .clickable(
                    onClick = {
                        onClickConnectVPN()
                    },
                    indication = null,
                    interactionSource = interactionSource
                )
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val icon = if (connectState is ConnectState.Connected)
                R.drawable.ic_connected_lighting
            else R.drawable.ic_normal_lighting

            Icon(
                painterResource(id = icon),
                tint = AppUITheme.colors.textColorPrimary,
                contentDescription = "Connection"
            )

            val state = when (connectState) {
                is ConnectState.Connected -> "Connected"
                is ConnectState.Connecting -> "Connecting"
                is ConnectState.Reconnecting -> "Reconnecting"
                else -> "Quick Connect"
            }

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = state,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = AppUITheme.colors.textColorPrimary,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.15.sp,
                )
            )
        }
    }
}

@Composable
private fun TransferStatisticItem(
    modifier: Modifier,
    transferType: TransferType,
    formattedBandwidth: String

) {
    val icon = if (transferType == TransferType.Download)
        RCoreUI.drawable.ic_arrow_down_circle
    else if (transferType == TransferType.Upload)
        RCoreUI.drawable.ic_arrow_up_circle
    else if (transferType == TransferType.LeftOver)
        RCoreUI.drawable.ic_arrow_flow_circle
    else
        RCoreUI.drawable.ic_arrow_use_circle

    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = icon),
            contentDescription = transferType.description,
            tint = AppUITheme.colors.textColorPrimary
        )

        Text(
            modifier = Modifier
                .padding(top = AppUITheme.spacing.x4)
                .height(24.dp)
                .align(Alignment.CenterHorizontally),
            text = formattedBandwidth,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(900),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 0.5.sp,
            ),
            color = AppUITheme.colors.textColorPrimary
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = transferType.description,
            style = AppUITheme.typography.bodyMedium,
            color = AppUITheme.colors.textColorPrimary
        )
    }
}

@Composable
fun WatchADDialog(
    onDismiss: () -> Unit,
    onClickWatchAD: () -> Unit
) {
    Dialog(
        onDismissRequest = { },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppUITheme.spacing.x8)
                .wrapContentHeight()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xff714DFF),
                            Color(0xffF14DFF)
                        )
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .alpha(0.5f),
                onClick = { onDismiss() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Close Dialog",
                    tint = AppUITheme.colors.textColorPrimary
                )
            }

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier.padding(top = 18.dp),
                    painter = painterResource(id = R.drawable.img_watch_ad_top),
                    contentDescription = "AD Image"
                )

                Text(
                    modifier = Modifier.padding(horizontal = AppUITheme.spacing.x16),
                    text = "Watching the complete advertisement allows you to enjoy of",
                    color = AppUITheme.colors.textColorPrimary,
                    textAlign = TextAlign.Center,
                    style = AppUITheme.typography.titleSmall
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = AppUITheme.spacing.x16)
                        .padding(top = AppUITheme.spacing.x24),
                    text = "Free VPN service",
                    color = AppUITheme.colors.textColorPrimary,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(800),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )

                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppUITheme.spacing.x16)
                    .padding(top = AppUITheme.spacing.x24)
                    .background(
                        color = Color(0xFFFF7E21),
                        shape = RoundedCornerShape(26.dp)
                    )
                    .height(52.dp),
                    onClick = { onClickWatchAD() }) {
                    Text(
                        text = "Watch AD",
                        color = AppUITheme.colors.textColorPrimary,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(900),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}

private fun Context.prepareVpnConnection(
    onPermissionGranted: () -> Unit,
    onPermissionDenied: (Intent) -> Unit
) {
    val intent = VpnService.prepare(this)
    if (intent != null) {
        onPermissionDenied(intent)
    } else {
        onPermissionGranted()
    }
}


private fun Long.toElapsedTimeFormat(): String {
    return String.format(
        "%02d:%02d:%02d",
        TimeUnit.MILLISECONDS.toHours(this),
        TimeUnit.MILLISECONDS.toMinutes(this) -
                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(this)),
        TimeUnit.MILLISECONDS.toSeconds(this) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(this))
    )
}

fun Context.openGPStore() {
    try {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(
                "https://play.google.com/store/apps/details?id=${packageName}"
            )
            setPackage("com.android.vending")
        }
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@CombinedThemePreviews
@Composable
private fun HomeScreenPreview() {
    VpnThemePreview {
        HomeScreen(
            uiState = HomeUIState(),
            savedStateHandle = SavedStateHandle(),
            navigateToTellYourFriends = { _, _ -> },
            navigateToPrivacyPolicy = { _, _ -> },
            navigateToAboutUs = {},
            navigationToRegion = {},
            navigateToConnectFail = {},
            navigateToShowAd = {},
            onClickPointAccess = {},
            onStartVpnTunnelService = {},
            onStopVpnTunnelService = {},
            resetNotifySelectRegionEvent = {},
            resetConnectFailEvent = {},
            onDismissADDialog = {},
            onClickWatchAD = {}
        )
    }
}
