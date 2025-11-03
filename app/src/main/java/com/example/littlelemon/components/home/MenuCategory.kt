package com.example.littlelemon.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.data.categories

@Composable
fun CategoryFilter(onClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            "ORDER FOR DELIVERY!",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        CategoryList(onClick)
    }
}


@Composable
fun CategoryList(onClick: (String) -> Unit) {
    LazyRow(state = rememberLazyListState(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        itemsIndexed(categories) { index, category ->
            CategoryButton(category.name, onClick)
        }
    }
}

@Composable
fun CategoryButton(name: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(name) }, colors = ButtonColors(
            containerColor = Color(0x2A495E57),
            contentColor = Color(0xFF495E57),
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Red
        ), modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = name)
    }
}