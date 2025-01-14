package com.example.binlist.designsystem.component.progressbar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier
            .width(24.dp)
            .height(24.dp),
        color = Color.White,
        trackColor = Color.Transparent,
        strokeWidth = 2.dp
    )
}