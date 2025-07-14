package com.example.mealdb

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import coil3.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(category: Category, padding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = category.strCategory, textAlign = TextAlign.Center)
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        )

    }
}