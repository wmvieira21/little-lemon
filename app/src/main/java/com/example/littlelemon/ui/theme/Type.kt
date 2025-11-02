package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

val markaziFontFamily = FontFamily(
    Font(R.font.markazi_text, FontWeight.Normal),
    Font(R.font.markazi_text_semibold, FontWeight.SemiBold),
    Font(R.font.markazi_text_bold, FontWeight.Bold),
)
val karlaFamily = FontFamily(
    Font(R.font.karla, FontWeight.Normal)
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = markaziFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = markaziFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
    ),

//específico para textfield ou componentes Material
    bodyLarge = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),

    displayMedium = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = karlaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = markaziFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 58.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = markaziFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
    ),


    headlineLarge = TextStyle(
        fontFamily = markaziFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 44.sp,
    ),
)
