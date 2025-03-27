package com.example.testideaplatform.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testideaplatform.data.repository.ItemRepository
import com.example.testideaplatform.domain.model.Item
import com.example.testideaplatform.domain.repository.IItemRepository
import com.example.testideaplatform.presentation.mapper.toDomain
import com.example.testideaplatform.presentation.mapper.toViewData
import com.example.testideaplatform.presentation.model.ItemViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemRepository: IItemRepository
) : ViewModel() {
    private val _searchFieldInput: MutableStateFlow<String> = MutableStateFlow("")
    val searchFieldInput: StateFlow<String> = _searchFieldInput

    private val _items: StateFlow<List<ItemViewData>> = itemRepository.getAllItemsFlow()
        .map { items ->
            items.map(Item::toViewData)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    private val _itemToInteractWith: MutableStateFlow<ItemViewData?> = MutableStateFlow(null)
    val itemToInteractWith: StateFlow<ItemViewData?> = _itemToInteractWith

    val itemsToShow: StateFlow<List<ItemViewData>> =
        _items.combine(_searchFieldInput) { items, searchFieldValue ->
            items.filter { item ->
                item.name.contains(searchFieldValue, ignoreCase = true)
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onSearchFieldValueChange(fieldValue: String) {
        _searchFieldInput.value = fieldValue
    }

    fun onDeleteClicked(item: ItemViewData?) {
        if (item != null) {
            viewModelScope.launch {
                itemRepository.deleteItem(item.id)
            }
        }
    }

    fun onEditClicked(item: ItemViewData?) {
        if (item != null) {
            viewModelScope.launch {
                itemRepository.updateItem(item.toDomain())
            }
        }
    }

    fun selectItemToInteractWith(item: ItemViewData) {
        _itemToInteractWith.value = item
    }
}