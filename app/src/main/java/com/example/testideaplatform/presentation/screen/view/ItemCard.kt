package com.example.testideaplatform.presentation.screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.testideaplatform.R
import com.example.testideaplatform.presentation.model.ItemViewData
import com.example.testideaplatform.presentation.theme.Delete
import com.example.testideaplatform.presentation.theme.Edit
import com.example.testideaplatform.presentation.theme.Size2
import com.example.testideaplatform.presentation.theme.Typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemCard(
    item: ItemViewData,
    onEditClicked: () -> Unit,
    onDeleteClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardColors(Color.White, Color.White, Color.White, Color.White),
        elevation = CardDefaults.elevatedCardElevation(Size2, Size2, Size2, Size2, Size2, Size2)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    color = Color.Black,
                    style = Typography.bodyLarge
                )

                Row {
                    IconButton(
                        onClick = { onEditClicked() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = stringResource(R.string.edit_content_description),
                            tint = Edit
                        )
                    }

                    IconButton(
                        onClick = { onDeleteClicked(item.id) }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = stringResource(R.string.delete_content_description),
                            tint = Delete
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                FlowRow {
                    item.tags.forEach { tag ->
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(text = tag)
                            },
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.at_warehouse)
                    )
                    Text(
                        text = item.amount.toString()
                    )
                }

                Column {
                    Text(
                        text = stringResource(R.string.date_added)
                    )
                    Text(
                        text = item.time.toString()
                    )
                }
            }
        }
    }
}