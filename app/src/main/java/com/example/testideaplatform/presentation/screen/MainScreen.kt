package com.example.testideaplatform.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.testideaplatform.presentation.screen.view.ItemCard
import com.example.testideaplatform.presentation.screen.view.SearchField
import com.example.testideaplatform.presentation.theme.Space8
import com.example.testideaplatform.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val fieldValue by viewModel.searchFieldInput.collectAsState()

    val items by viewModel.itemsToShow.collectAsState()

    Column(
        modifier = modifier.fillMaxSize().background(Color.White)
    ) {
        SearchField(
            fieldValue = fieldValue,
            onFieldValueChange = viewModel::onSearchFieldValueChange,
            modifier = Modifier.padding(horizontal = Space8)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Space8),
            verticalArrangement = Arrangement.spacedBy(Space8)
        ) {
            items(
                items = items,
                key = { item -> item.id}
            ) { item ->
                ItemCard(
                    item = item,
                    onEditClicked = {},
                    onDeleteClicked = viewModel::onDeleteClicked
                )
            }
        }
    }
}