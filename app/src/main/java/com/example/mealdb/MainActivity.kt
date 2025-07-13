package com.example.mealdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.Image
import coil3.compose.rememberAsyncImagePainter
import com.example.mealdb.ui.theme.MealDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealDbTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MealDbApp(padding = innerPadding)

                }
            }
        }
    }
}

@Composable
fun MealDbApp(padding: PaddingValues, viewModel: MainViewModel = viewModel()) {
    val viewState by viewModel.categoriesState
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when {
            viewState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            viewState.error != null -> {
                Text(viewState.error!!)
            }

            else -> {
                CategoryScreen(categories = viewState.categories)
            }

        }

    }


}

@Composable
fun CategoryScreen(categories: List<Category>) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(categories) {
            CategoryItem(category = it)
        }
    }

}

@Composable
fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }

}