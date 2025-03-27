package com.example.testideaplatform.presentation.screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.testideaplatform.R
import com.example.testideaplatform.presentation.theme.Typography

@Composable
fun SearchField(
    fieldValue: String,
    onFieldValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = fieldValue,
            onValueChange = onFieldValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            label = {
                if (fieldValue.isNotBlank()) {
                    Text(
                        text = stringResource(R.string.search)
                    )
                }
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    color = Color.Black,
                    style = Typography.bodySmall
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
        )
    }
}