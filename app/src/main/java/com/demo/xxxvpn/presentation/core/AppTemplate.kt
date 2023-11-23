package com.demo.xxxvpn.presentation.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.xxxvpn.core.ui.theme.AppTheme
import com.demo.xxxvpn.core.ui.theme.AppUITheme


@Composable
fun AppScaffold(
    snackBarHostState: SnackbarHostState,
    content: @Composable (PaddingValues) -> Unit
) {
    AppTheme {
        Scaffold(
            modifier = Modifier
                .background(color = AppUITheme.colors.backgroundColor)
                .fillMaxSize(),
//            snackbarHost = {
//                SnackbarHost(snackBarHostState) { data ->
//                    Snackbar(
//                        modifier = Modifier.padding(
//                            bottom = 12.dp,
//                            start = 8.dp,
//                            end = 8.dp
//                        ),
//                        snackbarData = data,
//                        containerColor = AppUITheme.colors.snackbarColor,
//                        contentColor = AppUITheme.colors.backgroundColor
//                    )
//                }
//            },
            content = content
        )
    }
}