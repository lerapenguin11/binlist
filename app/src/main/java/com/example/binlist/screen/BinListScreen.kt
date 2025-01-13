package com.example.binlist.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binlist.component.card.CardInfo
import com.example.binlist.component.card.variant.CardInfoVariant
import com.example.binlist.component.spacer.SpacerHeight

@Composable
fun BinListScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(contentPadding)
            .padding(horizontal = 16.dp)
    ) {
        item {
            SpacerHeight(height = 20.dp)
        }
        items(items = listOf(6), key = { it }) { bin ->
            CardInfo(variant = CardInfoVariant.SECONDARY)
            SpacerHeight(height = 20.dp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBinListScreen() {
    BinListScreen(contentPadding = PaddingValues())
}