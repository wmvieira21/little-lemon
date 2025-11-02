package com.example.littlelemon.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.destinations.Profile

@Composable
fun HeaderHome(navController: NavHostController, modifier: Modifier) {

    fun openProfileScreen() {
        navController.navigate(Profile.route)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentScale = ContentScale.Fit,
            contentDescription = "Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .height(100.dp)
                .width(200.dp)
        )
        Image(
            painter = painterResource(R.drawable.profile),
            contentScale = ContentScale.Crop,
            contentDescription = "Profile",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(70.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Transparent, CircleShape)
                .clickable { openProfileScreen() })
    }
}