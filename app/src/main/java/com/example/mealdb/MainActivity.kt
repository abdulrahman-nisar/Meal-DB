package com.example.mealdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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

            }

        }

    }


}