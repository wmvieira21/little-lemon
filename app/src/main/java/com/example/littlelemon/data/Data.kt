package com.example.littlelemon.data

data class Category(
    val name: String
)

val categories: List<Category> = mutableListOf(
    Category("All"),
    Category("Starters"),
    Category("Mains"),
    Category("Desserts"),
    Category("Drinks"),
)