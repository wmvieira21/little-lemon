package com.example.littlelemon.service

import android.content.Context
import com.example.littlelemon.model.Menu
import com.example.littlelemon.model.MenuItem
import com.example.littlelemon.repository.AppDatabase
import com.example.littlelemon.repository.Database
import com.example.littlelemon.repository.MenuItemEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MenuItemsService {

    private val client: HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }, contentType = ContentType("text", "plain"))
        }
    }

    suspend fun getMenuItemsFromServer(): List<MenuItem> {
        try {
            val response: Menu =
                client.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
                    .body()

            return response.menu

        } catch (error: Exception) {
            println("An exception occurred while fetching the menu items. Error:$error")
            return emptyList()
        }
    }
}
