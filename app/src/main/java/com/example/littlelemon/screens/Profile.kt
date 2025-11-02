package com.example.littlelemon.screens

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import com.example.littlelemon.components.CustomButton
import com.example.littlelemon.components.CustomTextField
import com.example.littlelemon.destinations.Onboarding
import com.example.littlelemon.utils.Header
import com.example.littlelemon.utils.showToast

@Composable
fun ProfileScreen(
    sharedPreferences: SharedPreferences? = null,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(modifier)
        ProfileGreetingTitle()
        UserProfileForm(sharedPreferences!!, navController)
    }
}

@Composable
private fun ProfileGreetingTitle() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Personal information",
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
private fun UserProfileForm(
    sharedPreferences: SharedPreferences, navController: NavHostController
) {
    val context = LocalContext.current
    val firstName = sharedPreferences.getString("firstName", "")
    val lastName = sharedPreferences.getString("lastName", "")
    val email = sharedPreferences.getString("email", "")

    fun onButtonClick() {
        sharedPreferences.edit { putString("firstName", null) }
        sharedPreferences.edit { putString("lastName", null) }
        sharedPreferences.edit { putString("email", null) }

        showToast(context, "You've successfully logged out!")

        return navController.navigate(Onboarding.route)
    }

    Scaffold(modifier = Modifier.padding(horizontal = 16.dp), floatingActionButton = {
        CustomButton("Log out", onClick = { onButtonClick() })
    }, floatingActionButtonPosition = FabPosition.Center, content = { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            CustomTextField(
                labelName = "First name", value = firstName!!, enable = false
            )
            CustomTextField(
                labelName = "Last name", value = lastName!!, enable = false
            )
            CustomTextField(
                labelName = "Email", value = email!!, enable = false
            )
        }
    })
}
