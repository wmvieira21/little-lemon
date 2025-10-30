package com.example.littlelemon.screens

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.composables.CustomButton
import com.example.littlelemon.composables.CustomTextField
import androidx.core.content.edit
import androidx.navigation.NavHostController
import com.example.littlelemon.destinations.Home

@Composable
fun OnboardingScreen(
    sharedPreferences: SharedPreferences? = null,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(modifier)
        GreetingTitle()
        SignUpForm(sharedPreferences!!, navController)
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentScale = ContentScale.Fit,
            contentDescription = "Logo",
            modifier = modifier
                .width(250.dp)
                .height(50.dp)
        )
    }
}

@Composable
fun GreetingTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xFF495E57)),
    ) {
        Text(
            text = "Let's get to know you!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
fun SignUpForm(sharedPreferences: SharedPreferences, navController: NavHostController) {
    val context = LocalContext.current;
    val firstNameValue = rememberSaveable { mutableStateOf("") }
    val lastNameValue = rememberSaveable { mutableStateOf("") }
    val emailValue = rememberSaveable { mutableStateOf("") }

    fun onChangeValue(field: MutableState<String>, value: String) {
        field.value = value
    }

    fun onButtonClick() {
        if (firstNameValue.value.isBlank() || lastNameValue.value.isBlank() || emailValue.value.isBlank()) {
            return showToast(context, "Registration unsuccessful. Please enter all data.")
        }
        saveLocalData(
            context, sharedPreferences, firstNameValue.value, lastNameValue.value, emailValue.value
        )
        return navController.navigate(Home.route)
    }

    Scaffold(modifier = Modifier.padding(horizontal = 16.dp), floatingActionButton = {
        CustomButton("Register", onClick = { onButtonClick() })
    }, floatingActionButtonPosition = FabPosition.Center, content = { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            CustomTextField(
                "First name",
                value = firstNameValue.value,
                onValueChange = { newValue: String -> onChangeValue(firstNameValue, newValue) })
            CustomTextField(
                "Last name",
                value = lastNameValue.value,
                onValueChange = { newValue: String -> onChangeValue(lastNameValue, newValue) })
            CustomTextField(
                "Email",
                value = emailValue.value,
                onValueChange = { newValue: String -> onChangeValue(emailValue, newValue) })
        }
    })
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun saveLocalData(
    context: Context,
    sharedPreferences: SharedPreferences,
    firstName: String,
    lastName: String,
    email: String
) {
    sharedPreferences.edit { putString("firstName", firstName) }
    sharedPreferences.edit { putString("lastName", lastName) }
    sharedPreferences.edit { putString("email", email) }
    showToast(context, "Registration successful!")
}

@Preview
@Composable
fun OnboardingScreenPreview() {
//    OnboardingScreen();
}
