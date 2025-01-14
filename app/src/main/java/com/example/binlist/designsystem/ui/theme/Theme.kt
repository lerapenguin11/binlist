package com.example.binlist.designsystem.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun BinTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides TypographyValue,
        LocalColors provides basePalette,
        content = content
    )
}

object BinTheme {
    val typography: BinTypography
        @Composable get() = LocalTypography.current
    val colors: ColorPalette
        @Composable @ReadOnlyComposable get() = LocalColors.current
}