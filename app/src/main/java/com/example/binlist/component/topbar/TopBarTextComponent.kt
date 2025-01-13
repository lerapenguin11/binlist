package com.example.binlist.component.topbar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.binlist.ui.theme.BinTheme

@Composable
fun TopBarText(text: String) {
    Text(
        text = text,
        color = BinTheme.colors.accent,
        style = BinTheme.typography.regular22
    )
}