package com.demo.xxxvpn.presentation.home

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.demo.xxxvpn.R
import com.demo.xxxvpn.core.ui.theme.AppUITheme
import com.demo.xxxvpn.presentation.core.MainNavGraph
import com.demo.xxxvpn.presentation.dialog.ConfirmDialog
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Entry point for CRUDing tunnels
 */
@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            UpdateStatusBarColor()
            MainNavGraph(navHostController = rememberNavController())
        }

//        viewModel.showDialogLiveData.observe(this) { showDialog ->
//            var message: String? = null
//            if (showDialog == 1) {
//                message = "no access"
//            }else if (showDialog == 2){
//                message = "server error please try latter"
//            }
//
//            val confirmDialog = ConfirmDialog(this, R.style.BaseDialogTheme)
//            confirmDialog.setMessage(message)
//            confirmDialog.setCancelOnclickListener(
//                "Cancel",
//                ConfirmDialog.onCancelOnclickListener {
//                    confirmDialog.dismiss()
//                })
//            confirmDialog.setConfirmOnclickListener(
//                "OK",
//                ConfirmDialog.onConfirmOnclickListener {
//                    finish()
//                })
//            confirmDialog.show()
//        }
    }

    @Composable
    private fun UpdateStatusBarColor() {
        val isDarkTheme = isSystemInDarkTheme()
        val statusBarStyle = getVpnStatusBarStyle(isDarkTheme = isDarkTheme)

        LaunchedEffect(isDarkTheme) {
            enableEdgeToEdge(
                statusBarStyle = statusBarStyle,
                navigationBarStyle = statusBarStyle,
            )
        }
    }

    @Composable
    private fun getVpnStatusBarStyle(isDarkTheme: Boolean): SystemBarStyle {
        val statusBarColor = AppUITheme.colors.backgroundColor.toArgb()

        return if (isDarkTheme) {
            SystemBarStyle.dark(scrim = statusBarColor)
        } else {
            SystemBarStyle.light(
                scrim = statusBarColor,
                darkScrim = statusBarColor
            )
        }
    }
}
