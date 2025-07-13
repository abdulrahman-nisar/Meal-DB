package com.example.mealdb


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val _categoriesState = mutableStateOf(recipeState())
    val categoriesState:State<recipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    categories = response.categories,
                    isLoading = false,
                    error = null
                )

            }
            catch(e:Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    error = e.message ?: "An unexpected error occurred"
                )
            }
        }

    }

    data class recipeState(
        val categories: List<Category> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null
    )
}