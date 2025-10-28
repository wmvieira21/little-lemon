package Onboarding

import android.provider.CalendarContract.Colors
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import composables.CustomButton
import composables.CustomTextField

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(modifier)
        GreetingTitle()
        SignUpForm()
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
fun SignUpForm() {
    val firstNameValue = rememberSaveable { mutableStateOf("") }
    val lastNameValue = rememberSaveable { mutableStateOf("") }
    val emailValue = rememberSaveable { mutableStateOf("") }

    fun onChangeValue(field: MutableState<String>, value: String) {
        field.value = value
    }

    fun onButtonClick() {

    }

    Scaffold(
        modifier = Modifier.padding(horizontal = 16.dp), floatingActionButton = {
            CustomButton("Register", onClick = { onButtonClick() })
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = { innerPadding ->
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


@Preview
@Composable

fun GreetingPreeview() {
    Greeting();
}
