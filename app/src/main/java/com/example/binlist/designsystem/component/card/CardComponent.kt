package com.example.binlist.designsystem.component.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.example.binlist.designsystem.component.card.variant.CardDetailsVariant
import com.example.binlist.designsystem.component.card.variant.CardInfoVariant
import com.example.binlist.designsystem.component.spacer.SpacerHeight
import com.example.binlist.designsystem.component.utils.formatString
import com.example.binlist.designsystem.ui.theme.BinTheme
import com.example.binlist.presentation.model.BankInfoStable
import com.example.binlist.utils.CommonString

@Composable
fun CardInfo(
    variant: CardInfoVariant,
    bankInfo: BankInfoStable,
    modifier: Modifier = Modifier,
    onClickUrl: (String) -> Unit,
    onClickPhoneNumber: (String) -> Unit
) {
    val arrayOfCardDetailsVariants = CardDetailsVariant.entries.toTypedArray()

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
            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 400.dp),
                columns = StaggeredGridCells.Fixed(count = grid_count),
                verticalItemSpacing = 30.dp
            ) {
                items(items = arrayOfCardDetailsVariants, key = { item ->
                    item.id
                }) {
                    CardDetails(
                        cardTitle = stringResource(it.title),
                        variant = it,
                        bankInfo = bankInfo,
                        bin = bankInfo.bin,
                        onClickUrl = { url ->
                            onClickUrl(url)
                        },
                        onClickPhoneNumber = { phoneNumber ->
                            onClickPhoneNumber(phoneNumber)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CardDetails(
    variant: CardDetailsVariant,
    cardTitle: String,
    bankInfo: BankInfoStable,
    bin: String?,
    onClickUrl: (String) -> Unit,
    onClickPhoneNumber: (String) -> Unit
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
                    url = bankInfo.url,
                    onClickUrl = {
                        onClickUrl(it)
                    },
                    onClickPhoneNumber = {
                            onClickPhoneNumber(it)
                    }
                )
            }

            CardDetailsVariant.EIGHTH -> {
                CardFivefold(bin = bin)
            }
        }
    }
}

@Composable
private fun CardFivefold(bin: String?) {
    bin?.let {
        Text(
            text = formatString(str = it),
            color = Color.Black,
            style = BinTheme.typography.regular16
        )
    }
}

@Composable
private fun CardQuaternary(
    phone: String?,
    url: String?,
    nameBank: String,
    city: String,
    onClickUrl: (String) -> Unit,
    onClickPhoneNumber: (String) -> Unit
) {
    Text(
        text = "${nameBank}, $city",
        color = Color.Black,
        style = BinTheme.typography.regular16
    )
    SpacerHeight(height = 2.dp)
    phone?.let {
        Text(
            modifier = Modifier
                .clickable { onClickPhoneNumber(it) }
                .clip(RoundedCornerShape(4.dp))
                .padding(2.dp),
            text = it,
            color = Color.Black,
            style = BinTheme.typography.regular12
        )
    }
    url?.let {
        Text(
            modifier = Modifier
                .clickable { onClickUrl(it) }
                .clip(RoundedCornerShape(4.dp))
                .padding(2.dp),
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
private const val grid_count = 2