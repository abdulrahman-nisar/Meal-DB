package com.example.mealdb

sealed class Screen(route:String) {
    data object CategoriesScreen : Screen("categories_screen")
    data object RecipesScreen : Screen("recipes_screen")
}