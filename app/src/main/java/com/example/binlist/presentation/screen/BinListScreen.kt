package com.example.binlist.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.binlist.designsystem.component.card.CardInfo
import com.example.binlist.designsystem.component.card.variant.CardInfoVariant
import com.example.binlist.designsystem.component.spacer.SpacerHeight
import com.example.binlist.presentation.viewmodel.BinListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BinListScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    binListViewModel: BinListViewModel = koinViewModel()
) {
    val bankInfoList by binListViewModel.getBankInfoFlow().collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier
            .padding(contentPadding)
            .padding(horizontal = 16.dp)
    ) {
        item {
            SpacerHeight(height = 20.dp)
        }
        items(items = bankInfoList, key = { it.id }) { infoStable ->
            CardInfo(
                variant = CardInfoVariant.SECONDARY,
                bankInfo = infoStable
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