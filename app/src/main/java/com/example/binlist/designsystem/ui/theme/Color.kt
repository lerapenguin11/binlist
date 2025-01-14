package com.example.binlist.designsystem.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF0071E3)
val Accent = Color(0xFF1D1D1F)
val Secondary = Color(0xFFFAFAFC)
val Tertiary = Color(0xFF585858)
val Quaternary = Color(0xFFC5C5C5)
val Fivefold = Color(0xFFF5F5F7)

data class ColorPalette(
    val primary: Color,
    val accent: Color,
    val secondary: Color,
    val tertiary: Color,
    val quaternary: Color,
    val fivefold: Color
)

val basePalette = ColorPalette(
    primary = Primary,
    accent = Accent,
    secondary = Secondary,
    tertiary = Tertiary,
    quaternary = Quaternary,
    fivefold = Fivefold
)

val LocalColors = staticCompositionLocalOf<ColorPalette> {
    basePalette
}