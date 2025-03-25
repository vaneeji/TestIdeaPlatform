package com.example.testideaplatform.presentation.screen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.testideaplatform.R
import com.example.testideaplatform.presentation.theme.Blue
import com.example.testideaplatform.presentation.theme.Typography

@Composable
fun TopBar() {
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Blue),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.goods_list),
                style = Typography.titleMedium,
                color = Color.Black
            )
        }
    }
}