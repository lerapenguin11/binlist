package com.example.binlist.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF0071E3)
val Accent = Color(0xFF1D1D1F)
val Secondary = Color(0xFFFAFAFC)
val Tertiary = Color(0xFF585858)
val Quaternary = Color(0xFFC5C5C5)

data class ColorPalette(
    val primary: Color,
    val accent: Color,
    val secondary: Color,
    val tertiary: Color,
    val quaternary: Color
)

val basePalette = ColorPalette(
    primary = Primary,
    accent = Accent,
    secondary = Secondary,
    tertiary = Tertiary,
    quaternary = Quaternary
)

val LocalColors = staticCompositionLocalOf<ColorPalette> {
    basePalette
}