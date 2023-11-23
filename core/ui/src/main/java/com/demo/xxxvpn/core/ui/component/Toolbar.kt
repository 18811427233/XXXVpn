package com.demo.xxxvpn.core.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xxxvpn.core.ui.R
import com.demo.xxxvpn.core.ui.preview.CombinedThemePreviews
import com.demo.xxxvpn.core.ui.theme.AppUITheme
import com.demo.xxxvpn.core.ui.theme.VpnThemePreview

val TOOLBAR_DEFAULT_HEIGHT = 64.dp

@Composable
fun DefaultToolbar(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter,
    onIconClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppUITheme.spacing.x8)
            .height(TOOLBAR_DEFAULT_HEIGHT)
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .wrapContentSize(),
            onClick = onIconClicked
        ) {
            Icon(
                modifier = Modifier
                    .size(AppUITheme.spacing.x24),
                painter = icon,
                tint = AppUITheme.colors.iconColorPrimary,
                contentDescription = "$title Icon"
            )
        }

        Text(
            modifier = Modifier
                .padding(start = AppUITheme.spacing.x4, end = AppUITheme.spacing.x16)
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = title,
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                color = AppUITheme.colors.textColorPrimary,
            ),
            color = AppUITheme.colors.textColorPrimary
        )
    }
}

@CombinedThemePreviews
@Composable
private fun DefaultToolbarPreview() {
    VpnThemePreview {
        DefaultToolbar(
            title = "Title",
            icon = painterResource(id = R.drawable.ic_arrow_back)
        ) {}
    }
}