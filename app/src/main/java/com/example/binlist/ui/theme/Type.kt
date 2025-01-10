package com.example.binlist.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.binlist.R
import org.w3c.dom.Text

val ProDisplay = FontFamily(
    Font(resId = R.font.sf_pro_display_regular, weight = FontWeight.Medium),
    Font(resId = R.font.sf_pro_display_medium, weight = FontWeight.Normal),
)

@Immutable
data class BinTypography(
    val regular22: TextStyle,
    val regular16: TextStyle,
    val regular12: TextStyle,
    val medium16: TextStyle,
    val regular10: TextStyle
)

val TypographyValue = BinTypography(
    regular22 = TextStyle(
        fontFamily = ProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    regular16 = TextStyle(
        fontFamily = ProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    regular12 = TextStyle(
        fontFamily = ProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    regular10 = TextStyle(
        fontFamily = ProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    medium16 = TextStyle(
        fontFamily = ProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
)

val LocalTypography = staticCompositionLocalOf {
    TypographyValue
}