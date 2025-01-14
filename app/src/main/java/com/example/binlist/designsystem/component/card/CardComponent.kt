package com.example.binlist.designsystem.component.card

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
import com.example.binlist.designsystem.component.card.variant.CardDetailsVariant
import com.example.binlist.designsystem.component.card.variant.CardInfoVariant
import com.example.binlist.designsystem.component.spacer.SpacerHeight
import com.example.binlist.designsystem.ui.theme.BinTheme
import com.example.binlist.presentation.model.BankInfoStable
import com.example.binlist.utils.CommonString

@Composable
fun CardInfo(
    variant: CardInfoVariant,
    bankInfo: BankInfoStable,
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
                        variant = CardDetailsVariant.FIRST,
                        bankInfo = bankInfo
                    )
                }
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_type),
                        variant = CardDetailsVariant.SECOND,
                        bankInfo = bankInfo
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
                        variant = CardDetailsVariant.THIRD,
                        bankInfo = bankInfo
                    )
                }
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_prepaid),
                        variant = CardDetailsVariant.FOURTH,
                        bankInfo = bankInfo
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
                        variant = CardDetailsVariant.FIFTH,
                        bankInfo = bankInfo
                    )
                }
                Box(modifier = Modifier.weight(5f)) {
                    CardDetails(
                        cardTitle = stringResource(CommonString.text_country),
                        variant = CardDetailsVariant.SIXTH,
                        bankInfo = bankInfo
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
                        variant = CardDetailsVariant.SEVENTH,
                        bankInfo = bankInfo
                    )
                }
                if (variant == CardInfoVariant.SECONDARY) {
                    Box(modifier = Modifier.weight(5f)) {
                        CardDetails(
                            cardTitle = stringResource(CommonString.text_bin),
                            variant = CardDetailsVariant.SIXTH,
                            bankInfo = bankInfo
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
    cardTitle: String,
    bankInfo: BankInfoStable
) {
    Column {
        Text(
            text = cardTitle,
            color = BinTheme.colors.quaternary,
            style = BinTheme.typography.regular12
        )
        when (variant) {
            CardDetailsVariant.FIRST -> {
                CardPrimary(text = bankInfo.scheme ?: no_data)
            }

            CardDetailsVariant.SECOND -> {
                CardPrimary(text = bankInfo.type ?: no_data)
            }

            CardDetailsVariant.THIRD -> {
                CardPrimary(text = bankInfo.brand ?: no_data)
            }

            CardDetailsVariant.FOURTH -> {
                CardPrimary(text = bankInfo.prepaid?.toString() ?: no_data)
            }

            CardDetailsVariant.FIFTH -> {
                CardSecondary(
                    length = bankInfo.length?.toString() ?: no_data,
                    lunh = bankInfo.lunh?.toString() ?: no_data
                )
            }

            CardDetailsVariant.SIXTH -> {
                CardTernary(
                    country = bankInfo.country ?: no_data,
                    latitude = bankInfo.latitude?.toString() ?: no_data,
                    longitude = bankInfo.longitude?.toString() ?: no_data
                )
            }

            CardDetailsVariant.SEVENTH -> {
                CardQuaternary(
                    phone = bankInfo.phone,
                    nameBank = bankInfo.bankName ?: no_data,
                    city = bankInfo.city ?: no_data,
                    url = bankInfo.url
                )
            }

            else -> {}
        }
    }
}

@Composable
fun CardQuaternary(
    phone: String?,
    url: String?,
    nameBank: String,
    city: String
) {
    Text(
        text = "${nameBank}, $city",
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
    SpacerHeight(height = 2.dp)
    phone?.let {
        Text(
            text = it,
            color = Color.Black,
            style = BinTheme.typography.regular12
        )
    }
    SpacerHeight(height = 2.dp)
    url?.let {
        Text(
            text = it,
            color = BinTheme.colors.primary,
            style = BinTheme.typography.regular12
        )
    }
}

@Composable
private fun CardTernary(
    country: String,
    latitude: String,
    longitude: String
) {
    Text(
        text = country,
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
    val annotatedString = buildAnnotatedString {
        pushStyle(SpanStyle(color = BinTheme.colors.quaternary))
        append(stringResource(CommonString.text_country_latitude))
        pushStyle(SpanStyle(color = Color.Black))
        append(latitude)
        pop()
        append(stringResource(CommonString.text_country_longitude))
        pushStyle(SpanStyle(color = Color.Black))
        append(longitude)
        pop()
        append(stringResource(CommonString.text_right_parenthesis))
        toAnnotatedString()
    }
    Text(text = annotatedString)
}

@Composable
private fun CardSecondary(
    length: String,
    lunh: String,
    modifier: Modifier = Modifier
) {
    Row {
        Column {
            Text(
                text = stringResource(CommonString.text_length),
                color = BinTheme.colors.quaternary,
                style = BinTheme.typography.regular10
            )
            Text(
                text = length,
                color = Color.Black,
                style = BinTheme.typography.regular16
            )
        }
        Column(modifier = modifier.absoluteOffset(x = 10.dp)) {
            Text(
                text = stringResource(CommonString.text_lunh),
                color = BinTheme.colors.quaternary,
                style = BinTheme.typography.regular10
            )
            Text(
                text = lunh,
                color = Color.Black,
                style = BinTheme.typography.regular16
            )
        }
    }
}

@Composable
private fun CardPrimary(text: String) {
    Text(
        text = text,
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
}

private const val no_data = "?"

@Preview(showBackground = true)
@Composable
fun PreviewCardDetails() {
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
}