package com.example.binlist.designsystem.component.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.binlist.R
import com.example.binlist.designsystem.ui.theme.BinTheme
import com.example.binlist.utils.CommonDrawables
import com.example.binlist.utils.CommonString

@Composable
fun InputField(
    inputText: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = inputText,
        onValueChange = { newValue ->
            onValueChange(newValue.take(MASK.count { it == MASK_NUMBER }))
        },
        label = {
            Text(
                text = stringResource(CommonString.text_label)
            )
        },
        maxLines = MAX_LINE,
        placeholder = {
            Text(
                text = stringResource(CommonString.text_placeholder),
                style = BinTheme.typography.regular16
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BinTheme.colors.primary,
            unfocusedBorderColor = BinTheme.colors.accent,
            focusedLabelColor = BinTheme.colors.primary,
            unfocusedLabelColor = BinTheme.colors.accent,
            focusedLeadingIconColor = BinTheme.colors.primary,
            unfocusedLeadingIconColor = BinTheme.colors.accent,
            cursorColor = BinTheme.colors.tertiary
        ),
        supportingText = {
            Text(
                text = stringResource(CommonString.text_supporting),
                style = BinTheme.typography.regular12,
                color = BinTheme.colors.tertiary
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = CommonDrawables.ic_search),
                contentDescription = stringResource(
                    R.string.text_search
                )
            )
        },
        visualTransformation = PhoneVisualTransformation(mask = MASK, maskNumber = MASK_NUMBER),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
    )
}

private const val MAX_LINE = 1
private const val MASK = "XXXX XXXX"
private const val MASK_NUMBER = 'X'