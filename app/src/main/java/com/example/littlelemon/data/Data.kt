package com.example.littlelemon.data

data class Category(
    val name: String
)

val categories: List<Category> = mutableListOf(
    Category("Starters"),
    Category("Mains"),
    Category("Desserts"),
    Category("Drinks"),
)