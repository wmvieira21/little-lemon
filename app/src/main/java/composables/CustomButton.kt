package composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(nameButton: String, onClick: () -> Unit) {
    Button(
        onClick = onClick, colors = ButtonColors(
            containerColor = Color(0xFFF4CE14),
            contentColor = Color(0xFF333333),
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Red
        ), modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = nameButton, fontSize = 20.sp, modifier = Modifier.padding(4.dp))
    }
}