package com.demo.xxxvpn.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.demo.xxxvpn.core.ui.preview.CombinedThemePreviews
import com.demo.xxxvpn.core.ui.theme.AppTheme
import mega.vpn.android.core.ui.component.ClippedShadow

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = modifier
                .size(108.dp)
                .background(
                    color = Color(0x33FAFAFA),
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            ClippedShadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .size(108.dp)
                    .background(
                        color = Color(0x33000000),
                        shape = RoundedCornerShape(8.dp),
                    ),
            )
            CircularProgressIndicator(
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center),
                color = Color(0xFF6F4CFF),
            )
        }
    }
}

@CombinedThemePreviews
@Composable
fun LoadingViewPreview() {
    AppTheme {
        LoadingView(modifier = Modifier)
    }
}