package com.example.binlist.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binlist.component.button.ButtonVariant
import com.example.binlist.component.button.PrimaryButton
import com.example.binlist.component.card.CardInfo
import com.example.binlist.component.card.variant.CardInfoVariant
import com.example.binlist.component.input.InputField
import com.example.binlist.component.spacer.SpacerHeight
import com.example.binlist.ui.theme.BinTheme
import com.example.binlist.utils.CommonString

@Composable
fun BinScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(contentPadding)
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight(0.55f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InputField(
                    inputText = ""
                ) {

                }
                Box(modifier = Modifier.padding(vertical = 8.dp)) {
                    SpacerHeight(height = 12.dp)
                    PrimaryButton(variant = ButtonVariant.FILLED) {
                        //TODO
                    }
                }
            }

        }
        AnimatedVisibility(
            visible = true,
            enter = slideInHorizontally() + expandHorizontally(expandFrom = Alignment.End)
                    + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
                    + shrinkHorizontally() + fadeOut(),
        ) {
            Column {
                SpacerHeight(height = 45.dp)
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(CommonString.text_important_information),
                    color = BinTheme.colors.accent,
                    style = BinTheme.typography.medium16
                )
                SpacerHeight(height = 25.dp)
                CardInfo(variant = CardInfoVariant.PRIMARY)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBinScreen() {
    BinScreen(contentPadding = PaddingValues())
}