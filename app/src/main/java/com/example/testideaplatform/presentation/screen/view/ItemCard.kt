package com.example.testideaplatform.presentation.screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.testideaplatform.R
import com.example.testideaplatform.presentation.model.ItemViewData
import com.example.testideaplatform.presentation.theme.Delete
import com.example.testideaplatform.presentation.theme.Edit
import com.example.testideaplatform.presentation.theme.Size4
import com.example.testideaplatform.presentation.theme.Space12
import com.example.testideaplatform.presentation.theme.Space8
import com.example.testideaplatform.presentation.theme.Typography
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemCard(
    item: ItemViewData,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val df = SimpleDateFormat("dd.MM.yyyy", Locale.US)
    val date = df.format(Date(item.time))

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardColors(Color.White, Color.White, Color.White, Color.White),
        elevation = CardDefaults.elevatedCardElevation(Size4)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = Space12, vertical = Space8)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.name,
                        color = Color.Black,
                        style = Typography.headlineSmall,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.weight(1f)
                    )

                    Row {
                        IconButton(
                            onClick = onEditClicked
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = stringResource(R.string.edit_content_description),
                                tint = Edit
                            )
                        }

                        IconButton(
                            onClick = onDeleteClicked
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = stringResource(R.string.delete_button_content_description),
                                tint = Delete
                            )
                        }
                    }
                }
            }

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Space8),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                item.tags.forEach { tag ->
                    if (tag.isNotBlank()) {
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
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.at_warehouse),
                        color = Color.Black,
                        style = Typography.titleMedium
                    )
                    Text(
                        text = item.amount.toString(),
                        color = Color.Black
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.date_added),
                        color = Color.Black,
                        style = Typography.titleMedium
                    )
                    Text(
                        text = date,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewItemCard() {
    ItemCard(
        item = ItemViewData(
            id = 0,
            name = "ASDASDASDASDASDASDASDSADASDSADSADASDADAWSDASDSDASDSA",
            time = 34567845678L,
            tags = emptyList(),
            amount = 1237812378
        ),
        onEditClicked = {},
        onDeleteClicked = {}
    )
}