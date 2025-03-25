package com.example.testideaplatform.presentation.screen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import com.example.testideaplatform.R
import com.example.testideaplatform.presentation.theme.Size48
import com.example.testideaplatform.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    fieldValue: String,
    onFieldValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.background(Color.White)
    ) {
        BasicTextField(
            value = fieldValue,
            onValueChange = onFieldValueChange,
            modifier = Modifier.fillMaxWidth().height(Size48),
            singleLine = true
            ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = fieldValue,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = remember { MutableInteractionSource() },
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
                },
            )
        }
    }
}