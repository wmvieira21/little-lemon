package com.example.littlelemon.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R

@Composable
fun InfoBanner() {
    Column(
        modifier = Modifier
            .background(Color(0xFF495E57))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Little Lemon",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFFF4CE14),
            modifier = Modifier
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(0.70f)
                    .padding(end = 4.dp)
            ) {
                Text(
                    text = "Chicago",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFFEDEFEE)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xE2E8E8E8),
                )
            }
            Image(
                painterResource(R.drawable.hero_image),
                contentScale = ContentScale.Fit,
                contentDescription = "banner image",
                modifier = Modifier
                    .weight(0.30f)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.Transparent, RoundedCornerShape(16.dp))
            )
        }
    }
}