package com.example.littlelemon.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.destinations.Onboarding
import com.example.littlelemon.destinations.Profile
import com.example.littlelemon.screens.HomeScreen
import com.example.littlelemon.screens.OnboardingScreen
import com.example.littlelemon.screens.ProfileScreen

@Composable
fun AppNavigation(
    sharedPreferences: SharedPreferences,
    navController: NavHostController,
    modifier: Modifier
) {
    fun getStartDestination(): String {
        val firstName = sharedPreferences.getString("firstName", null)
        if (firstName != null) {
            return Home.route
        } else {
            return Onboarding.route
        }
    }

    NavHost(navController = navController, startDestination = getStartDestination()) {
        composable(Onboarding.route) {
            OnboardingScreen(sharedPreferences, navController, modifier)
        }
        composable(Home.route) {
            HomeScreen(navController,modifier)
        }
        composable(Profile.route) {
            ProfileScreen(navController,modifier)
        }
    }

}
