package com.example.binlist.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binlist.component.card.variant.CardDetailsVariant
import com.example.binlist.component.card.variant.CardInfoVariant
import com.example.binlist.component.spacer.SpacerHeight
import com.example.binlist.ui.theme.BinTheme
import com.example.binlist.utils.CommonString

@Composable
fun CardInfo(
    variant: CardInfoVariant,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (variant == CardInfoVariant.PRIMARY)
                Color.Transparent else BinTheme.colors.fivefold
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Column(
            modifier = modifier.padding(all = if (variant == CardInfoVariant.SECONDARY) 24.dp else 0.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_scheme_network),
                        variant = CardDetailsVariant.PRIMARY
                    )
                }
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_type),
                        variant = CardDetailsVariant.PRIMARY
                    )
                }
            }
            SpacerHeight(height = 30.dp)
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_brand),
                        variant = CardDetailsVariant.PRIMARY
                    )
                }
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_prepaid),
                        variant = CardDetailsVariant.PRIMARY
                    )
                }
            }
            SpacerHeight(height = 30.dp)
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_card_number),
                        variant = CardDetailsVariant.SECONDARY
                    )
                }
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_country),
                        variant = CardDetailsVariant.TERNARY
                    )
                }
            }
            SpacerHeight(height = 30.dp)
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_bank),
                        variant = CardDetailsVariant.QUATERNARY
                    )
                }
                if (variant == CardInfoVariant.SECONDARY) {
                    Box(modifier = Modifier.weight(5f)) {
                        CardDetails(
                            cardTitle = stringResource(CommonString.text_bin),
                            variant = CardDetailsVariant.TERNARY
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardDetails(
    variant: CardDetailsVariant,
    cardTitle: String
) {
    Column {
        Text(
            text = cardTitle,
            color = BinTheme.colors.quaternary,
            style = BinTheme.typography.regular12
        )
        when (variant) {
            CardDetailsVariant.PRIMARY -> {
                CardPrimary()
            }

            CardDetailsVariant.SECONDARY -> {
                CardSecondary()
            }

            CardDetailsVariant.TERNARY -> {
                CardTernary()
            }

            CardDetailsVariant.QUATERNARY -> {
                CardQuaternary()
            }

            else -> {}
        }
    }
}

@Composable
fun CardQuaternary() {
    Text(
        text = "Jyske Bank, Hjørring",
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
    SpacerHeight(height = 2.dp)
    Text(
        text = "+4589893300",
        color = Color.Black,
        style = BinTheme.typography.regular12
    )
    SpacerHeight(height = 2.dp)
    Text(
        text = "www.jetbank.com",
        color = BinTheme.colors.primary,
        style = BinTheme.typography.regular12
    )
}

@Composable
private fun CardTernary() {
    Text(
        text = "\uD83C\uDDE9\uD83C\uDDF0 Denmark",
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
    val annotatedString = buildAnnotatedString {
        pushStyle(SpanStyle(color = BinTheme.colors.quaternary))
        append("(latitude: ")
        pushStyle(SpanStyle(color = Color.Black))
        append("56")
        pop()
        append(", longitude: ")
        pushStyle(SpanStyle(color = Color.Black))
        append("56")
        pop()
        append(")")
        toAnnotatedString()
    }
    Text(text = annotatedString)
}

@Composable
private fun CardSecondary(
    modifier: Modifier = Modifier
) {
    Row {
        Column {
            Text(
                text = "length",
                color = BinTheme.colors.quaternary,
                style = BinTheme.typography.regular10
            )
            Text(
                text = "16",
                color = Color.Black,
                style = BinTheme.typography.regular16
            )
        }
        Column(modifier = modifier.absoluteOffset(x = 10.dp)) {
            Text(
                text = "lunh",
                color = BinTheme.colors.quaternary,
                style = BinTheme.typography.regular10
            )
            Text(
                text = "Yes",
                color = Color.Black,
                style = BinTheme.typography.regular16
            )
        }
    }
}

@Composable
private fun CardPrimary() {
    Text(
        text = "Visa",
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCardDetails() {
    CardInfo(variant = CardInfoVariant.SECONDARY)
}