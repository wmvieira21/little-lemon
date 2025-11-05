package com.example.littlelemon.repository

import com.example.littlelemon.service.MenuItemsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MenuRepository(
    private val service: MenuItemsService, private val database: AppDatabase
) {
    suspend fun loadDataFromServer() {
        val itemsFromServer = service.getMenuItemsFromServer()
        if (itemsFromServer.isNotEmpty()) {
            val itemListEntity: List<MenuItemEntity> = itemsFromServer.map { it.toEntity() }
            saveDataDatabase(itemListEntity)
        }
    }

    suspend fun getMenuFromDatabase(): List<MenuItemEntity> {
        return withContext(Dispatchers.IO) {
            database.menuItemDAO().getAll().sortedBy { it -> it.title }
        }
    }

    suspend fun saveDataDatabase(items: List<MenuItemEntity>) {
        withContext(Dispatchers.IO) {
            database.menuItemDAO().insertAll(*items.toTypedArray())
        }
    }
}
