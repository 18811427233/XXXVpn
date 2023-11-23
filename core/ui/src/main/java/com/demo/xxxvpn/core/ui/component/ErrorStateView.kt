package com.demo.xxxvpn.core.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.xxxvpn.core.ui.theme.AppUITheme

@Composable
fun ErrorStateView(
    modifier: Modifier,
    @DrawableRes imageId: Int,
    title: String,
    subTitle: String,
    topBtnText: String? = null,
    onTopBtnClick: () -> Unit = {},
    bottomBtnText: String? = null,
    onBottomBtnClick: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Not Network Connection"
        )
        Text(
            text = title,
            color = AppUITheme.colors.textColorPrimary,
            style = AppUITheme.typography.headlineSmall
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = subTitle,
            color = AppUITheme.colors.textColorPrimary,
            style = AppUITheme.typography.bodyLarge
        )
        topBtnText?.let { text ->
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppUITheme.spacing.x40)
                    .padding(top = 34.dp)
                    .height(52.dp)
                    .background(
                        color = Color(0xFF6F4CFF),
                        shape = RoundedCornerShape(26.dp)
                    ),
                onClick = onTopBtnClick
            ) {
                Text(
                    text = text,
                    style = AppUITheme.typography.titleSmall,
                    color = AppUITheme.colors.textColorPrimary
                )
            }
        }

        bottomBtnText?.let { text ->
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppUITheme.spacing.x40)
                    .padding(top = AppUITheme.spacing.x16)
                    .height(52.dp)
                    .background(
                        color = Color(0xFF6F4CFF),
                        shape = RoundedCornerShape(26.dp)
                    ),
                onClick = onBottomBtnClick
            ) {
                Text(
                    text = text,
                    style = AppUITheme.typography.titleSmall,
                    color = AppUITheme.colors.textColorPrimary
                )
            }
        }
    }
}