package com.example.binlist.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binlist.designsystem.component.card.CardInfo
import com.example.binlist.designsystem.component.card.variant.CardInfoVariant
import com.example.binlist.designsystem.component.spacer.SpacerHeight
import com.example.binlist.presentation.model.BankInfoStable

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
            CardInfo(
                variant = CardInfoVariant.SECONDARY,
                bankInfo = BankInfoStable(
                    scheme = "Visa",
                    type = "debit",
                    length = 16,
                    lunh = true,
                    country = "\uD83C\uDDE9\uD83C\uDDF0 Denmark",
                    phone = "+4589893300",
                    bankName = "Jyske Bank",
                    city = "Hjørring",
                    latitude = 56,
                    longitude = 56,
                    url = "www.jyskebank.dk",
                    brand = null,
                    prepaid = false
                )
            )
            SpacerHeight(height = 20.dp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBinListScreen() {
    BinListScreen(contentPadding = PaddingValues())
}