package com.example.littlelemon

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.navigation.AppNavigation
import com.example.littlelemon.repository.AppDatabase
import com.example.littlelemon.repository.Database
import com.example.littlelemon.repository.MenuRepository
import com.example.littlelemon.service.MenuItemsService
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("little-lemon-data", Context.MODE_PRIVATE)
    }
    private val database: AppDatabase by lazy { Database.build(applicationContext) }
    private val repository: MenuRepository by lazy { MenuRepository(MenuItemsService(), database) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        repository = repository,
                        sharedPreferences = sharedPreferences,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(
    repository: MenuRepository, sharedPreferences: SharedPreferences, modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    AppNavigation(repository, sharedPreferences, navController, modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonTheme {
//        MyApp()
    }
}