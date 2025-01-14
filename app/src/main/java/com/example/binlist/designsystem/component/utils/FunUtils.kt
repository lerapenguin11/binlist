package com.example.binlist.designsystem.component.utils

fun splitString(str: String): List<String> {
    return str.chunked(4)
}

fun formatString(str: String): String {
    val parts = splitString(str)
    val formattedParts = parts.map { it.trimEnd() }
    return formattedParts.joinToString(" ")
}