package com.example.testideaplatform.presentation.screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.testideaplatform.R
import com.example.testideaplatform.presentation.model.ItemViewData
import com.example.testideaplatform.presentation.theme.Size36
import com.example.testideaplatform.presentation.theme.Space12
import com.example.testideaplatform.presentation.theme.Typography

@Composable
fun EditAlertDialog(
    itemToEdit: ItemViewData?,
    onConfirm: (Int) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (itemToEdit != null) {

        var editableAmount by rememberSaveable { mutableIntStateOf(itemToEdit.amount) }

        AlertDialog(
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = stringResource(R.string.delete_dialog_content_description)
                )
            },
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(
                    onClick = { onConfirm(editableAmount) }
                ) {
                    Text(stringResource(R.string.confirm_edit))
                }
            },
            modifier = modifier,
            dismissButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text(stringResource(R.string.dismiss_edit))
                }
            },
            title = {
                Text(stringResource(R.string.edit_dialog_title))
            },
            text = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = {
                            editableAmount--
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_remove_circle_outline_24),
                            contentDescription = stringResource(R.string.remove_btn_content_description),
                            modifier = Modifier.size(Size36)
                        )
                    }

                    Text(
                        text = editableAmount.toString(),
                        style = Typography.titleLarge,
                        modifier = Modifier.padding(horizontal = Space12)
                    )

                    IconButton(
                        onClick = {
                            editableAmount++
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_add_circle_outline_24),
                            contentDescription = stringResource(R.string.add_btn_content_description),
                            modifier = Modifier.size(Size36)
                        )
                    }
                }
            },
        )
    }
}