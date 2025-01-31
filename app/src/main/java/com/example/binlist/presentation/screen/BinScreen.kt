package com.example.binlist.presentation.screen

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.binlist.designsystem.component.button.PrimaryButton
import com.example.binlist.designsystem.component.card.CardInfo
import com.example.binlist.designsystem.component.card.variant.CardInfoVariant
import com.example.binlist.designsystem.component.input.InputField
import com.example.binlist.designsystem.component.spacer.SpacerHeight
import com.example.binlist.designsystem.ui.theme.BinTheme
import com.example.binlist.domain.model.bin.Bin
import com.example.binlist.presentation.model.BankInfoStable
import com.example.binlist.presentation.viewmodel.BankInfoUiState
import com.example.binlist.presentation.viewmodel.BinViewModel
import com.example.binlist.utils.CommonString
import org.koin.androidx.compose.koinViewModel

@Composable
fun BinScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    binViewModel: BinViewModel = koinViewModel(),
) {
    val bin by binViewModel.getBinFlow().collectAsStateWithLifecycle()
    val bankInfo by binViewModel.getBankInfoFlow().collectAsStateWithLifecycle()
    val buttonState by binViewModel.getButtonStateFlow().collectAsStateWithLifecycle()
    val errorMessage by binViewModel.getErrorMessageFlow().collectAsStateWithLifecycle()
    val bankUiState by binViewModel.getBankInfoUIStateFlow().collectAsStateWithLifecycle()

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
                    inputText = bin.orEmpty()
                ) {
                    binViewModel.updateBin(bin = it)
                }
                Box(modifier = Modifier.padding(vertical = 8.dp)) {
                    SpacerHeight(height = 12.dp)
                    PrimaryButton(variant = buttonState) {
                        bin?.let {
                            if (it.isNotEmpty()) {
                                binViewModel.fetchBankInfo(bin = Bin(bin = it))
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = !bin.isNullOrEmpty(),
            enter = slideInHorizontally() + expandHorizontally(expandFrom = Alignment.End)
                    + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
                    + shrinkHorizontally() + fadeOut(),
        ) {
            Column {
                SpacerHeight(height = 45.dp)
                bankUiState?.let { uiState ->
                    when (uiState) {
                        BankInfoUiState.Success -> {
                            bankInfo?.let { bankInfoStable ->
                                BankInfoBlock(
                                    bankInfo = bankInfoStable,
                                    onClickUrl = {
                                        binViewModel.openUrl(url = it)
                                    },
                                    onClickPhoneNumber = {
                                        binViewModel.openDialer(phoneNumber = it)
                                    }
                                )
                            }
                        }

                        BankInfoUiState.Error -> {
                            errorMessage?.let {
                                ErrorMessageBlock(text = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ErrorMessageBlock(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = text,
        color = BinTheme.colors.accent,
        style = BinTheme.typography.medium16
    )
}

@Composable
private fun BankInfoBlock(
    bankInfo: BankInfoStable,
    onClickUrl: (String) -> Unit,
    onClickPhoneNumber: (String) -> Unit
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(CommonString.text_important_information),
        color = BinTheme.colors.accent,
        style = BinTheme.typography.medium16
    )
    SpacerHeight(height = 25.dp)
    CardInfo(
        variant = CardInfoVariant.PRIMARY,
        bankInfo = bankInfo,
        onClickUrl = {
            onClickUrl(it)
        },
        onClickPhoneNumber = {
            onClickPhoneNumber(it)
        }
    )
    SpacerHeight(height = 25.dp)
}