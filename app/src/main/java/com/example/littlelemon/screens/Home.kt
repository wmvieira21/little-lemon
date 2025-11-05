package com.example.littlelemon.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.littlelemon.components.home.CardMenuItem
import com.example.littlelemon.components.home.CategoryFilter
import com.example.littlelemon.components.home.HeaderHome
import com.example.littlelemon.components.home.InfoBanner
import com.example.littlelemon.components.home.SearchTextField
import com.example.littlelemon.repository.MenuItemEntity
import com.example.littlelemon.repository.MenuRepository
import com.example.littlelemon.viewmodel.MenuItemsViewModel

@Composable
fun HomeScreen(
    repository: MenuRepository, navController: NavHostController, modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        HeaderHome(navController, modifier)
        InfoBanner()
        Menu(repository = repository)
    }
}

@Composable
private fun SearchField(
    searchInput: String, onChangeValue: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color(0xFF495E57))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        SearchTextField(
            placeholder = "Enter search phrase",
            value = searchInput,
            onValueChange = { text ->
                onChangeValue(text)
            },
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

@Composable
private fun Menu(repository: MenuRepository, viewModel: MenuItemsViewModel = viewModel()) {
    val searchInput: String by viewModel.searchInput.collectAsState()
    val menuItems: List<MenuItemEntity> by viewModel.menuItems.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadMenuItemsDataBase(repository = repository)
    }

    val onSearchingByTitle: (String) -> Unit = { title ->
        viewModel.onChangeInputText(title)
        viewModel.searchByTittle(title)
    }
    val onSearchingByCategory: (String) -> Unit = { category ->
        viewModel.onChangeInputText("")
        viewModel.searchByCategory(category)
    }

    SearchField(searchInput, onSearchingByTitle)
    CategoryFilter(onSearchingByCategory)

    LazyColumn(state = rememberLazyListState(), modifier = Modifier.padding(8.dp)) {
        itemsIndexed(menuItems) { index, item ->
            CardMenuItem(item)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
}