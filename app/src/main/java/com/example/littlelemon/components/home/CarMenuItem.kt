package com.example.littlelemon.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.repository.MenuItemEntity

@Composable
fun CardMenuItem(
    item: MenuItemEntity
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEDEFEE),
        ),
        shape = RoundedCornerShape(0),
        modifier = Modifier
            .padding(4.dp)
            .border(
                width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.displayLarge,
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)

                )
                Text(
                    text = "$${item.price}",
                    style = MaterialTheme.typography.displayMedium,
                )
            }

            Image(
                painter = painterResource(R.drawable.pasta),
                contentDescription = "dish picture",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}