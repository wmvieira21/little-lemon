package com.example.littlelemon.repository

import com.example.littlelemon.service.MenuItemsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MenuRepository(
    private val service: MenuItemsService, private val database: AppDatabase
) {
    suspend fun loadDataFromServer() {
        val itemsFromServer = service.getMenuItemsFromServer()
        println("william loading data from server..." + itemsFromServer.toString())
        if (itemsFromServer.isNotEmpty()) {
            val itemListEntity: List<MenuItemEntity> = itemsFromServer.map { it.toEntity() }
            saveDataDatabase(itemListEntity)
        }
    }

    suspend fun getMenuFromDatabase(): List<MenuItemEntity> {
        return withContext(Dispatchers.IO) {
            database.menuItemDAO().getAll()
        }
    }

    suspend fun saveDataDatabase(items: List<MenuItemEntity>) {
        println("william saving data from server..." + items.toString())
        withContext(Dispatchers.IO) {
            database.menuItemDAO().insertAll(*items.toTypedArray())
        }
    }
}
