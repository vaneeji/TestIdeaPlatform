package com.example.testideaplatform.presentation.screen.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.testideaplatform.R

@Composable
fun DeleteAlertDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Rounded.Warning,
                contentDescription = stringResource(R.string.delete_dialog_content_description)
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onConfirm
            ) {
                Text(stringResource(R.string.confirm_delete))
            }
        },
        title = {
            Text(stringResource(R.string.good_delete_action_title))
        },
        text = {
            Text(stringResource(R.string.good_delete_text))
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(stringResource(R.string.dismiss_delete))
            }
        },
        modifier = modifier
    )
}