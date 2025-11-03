package com.example.littlelemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemon.repository.MenuItemEntity
import com.example.littlelemon.repository.MenuRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuItemsViewModel : ViewModel() {
    private val _menuItems = MutableStateFlow<List<MenuItemEntity>>(emptyList())
    val menuItems: StateFlow<List<MenuItemEntity>> = _menuItems

    fun loadMenuItemsDataBase(repository: MenuRepository) {
        viewModelScope.launch {
            val loadFromServer = async { repository.loadDataFromServer() }
            val localData = async { repository.getMenuFromDatabase() }

            loadFromServer.await()
            _menuItems.value = localData.await()
        }
    }
}