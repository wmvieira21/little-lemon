package com.example.littlelemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemon.repository.MenuItemEntity
import com.example.littlelemon.repository.MenuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.collections.filter

class MenuItemsViewModel : ViewModel() {
    private var menuItemsFromDataBase: List<MenuItemEntity> = emptyList()
    private val _menuItems = MutableStateFlow<List<MenuItemEntity>>(emptyList())
    private val _searchInput = MutableStateFlow<String>("")

    val menuItems: StateFlow<List<MenuItemEntity>> = _menuItems
    val searchInput: StateFlow<String> = _searchInput

    fun loadMenuItemsDataBase(repository: MenuRepository) {
        viewModelScope.launch {
            repository.loadDataFromServer()
            val localData = repository.getMenuFromDatabase()

            _menuItems.value = localData
            menuItemsFromDataBase = _menuItems.value
        }
    }

    fun searchByTittle(title: String) {
        if (title.isNotBlank()) {
            val menuItemsFiltered = menuItemsFromDataBase
            _menuItems.value = menuItemsFiltered.filter {
                it.title.contains(title, ignoreCase = true)
            }
        } else {
            _menuItems.value = menuItemsFromDataBase
        }
    }

    fun searchByCategory(categoryName: String) {
        if (categoryName != "All") {
            val menuItemsFiltered = menuItemsFromDataBase
            _menuItems.value = menuItemsFiltered.filter {
                it.category.contains(categoryName, ignoreCase = true)
            }
        } else {
            _menuItems.value = menuItemsFromDataBase
        }
    }

    fun onChangeInputText(text: String) {
        _searchInput.value = text
    }
}
