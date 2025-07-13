package com.example.mealdb

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

data class CategoryResponse(
    val categories: List<Category>
)