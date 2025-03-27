package com.example.testideaplatform.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.testideaplatform.presentation.screen.view.DeleteAlertDialog
import com.example.testideaplatform.presentation.screen.view.EditAlertDialog
import com.example.testideaplatform.presentation.screen.view.ItemCard
import com.example.testideaplatform.presentation.screen.view.SearchField
import com.example.testideaplatform.presentation.theme.Space12
import com.example.testideaplatform.presentation.theme.Space20
import com.example.testideaplatform.presentation.theme.Space8
import com.example.testideaplatform.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val fieldValue by viewModel.searchFieldInput.collectAsState()

    val items by viewModel.itemsToShow.collectAsState()

    var openDeleteAlertDialog by rememberSaveable { mutableStateOf(false) }

    var openEditDialog by rememberSaveable { mutableStateOf(false) }

    val itemToInteractWith by viewModel.itemToInteractWith.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SearchField(
            fieldValue = fieldValue,
            onFieldValueChange = viewModel::onSearchFieldValueChange,
            modifier = Modifier.padding(horizontal = Space8, vertical = Space8)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = Space8, end = Space8, top = Space12),
            verticalArrangement = Arrangement.spacedBy(Space20)
        ) {
            items(
                items = items,
                key = { item -> item.id }
            ) { item ->
                ItemCard(
                    item = item,
                    onEditClicked = {
                        viewModel.selectItemToInteractWith(item)
                        openEditDialog = true
                    },
                    onDeleteClicked = {
                        viewModel.selectItemToInteractWith(item)
                        openDeleteAlertDialog = true
                    }
                )
            }
        }

        if (openDeleteAlertDialog) {
            DeleteAlertDialog(
                onConfirm = {
                    openDeleteAlertDialog = false

                    viewModel.onDeleteClicked(itemToInteractWith)
                },
                onDismiss = {
                    openDeleteAlertDialog = false
                }
            )
        }

        if (openEditDialog) {
            EditAlertDialog(
                itemToEdit = itemToInteractWith,
                onConfirm = { amount ->
                    openEditDialog = false
                    viewModel.onEditClicked(itemToInteractWith?.copy(amount = amount))
                },
                onDismiss = {
                    openEditDialog = false
                }
            )
        }
    }
}