package com.example.littlelemon.model

import com.example.littlelemon.repository.MenuItemEntity
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String
) {
    fun toEntity(): MenuItemEntity {
        return MenuItemEntity(
            id = id,
            title = title,
            description = description,
            price = price,
            image = image,
            category = category
        )
    }
}

@Serializable
data class Menu(val menu: List<MenuItem>)

