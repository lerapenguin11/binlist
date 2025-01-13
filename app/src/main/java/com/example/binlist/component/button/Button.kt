package com.example.binlist.component.button

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.binlist.component.progressbar.CircularProgressBar
import com.example.binlist.ui.theme.BinTheme
import com.example.binlist.utils.CommonString

@Composable
fun PrimaryButton(
    variant: ButtonVariant,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .heightIn(56.dp)
            .widthIn(min = 65.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = BinTheme.colors.primary,
            disabledContainerColor = BinTheme.colors.primary,
            disabledContentColor = Color.White
        ),
        enabled = variant == ButtonVariant.FILLED,
        shape = RoundedCornerShape(size = 4.dp),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        Crossfade(targetState = variant, label = "") { buttonContent ->
            when (buttonContent) {
                ButtonVariant.FILLED -> {
                    Text(
                        text = stringResource(CommonString.text_lookup),
                        style = BinTheme.typography.regular12,
                        color = Color.White
                    )
                }

                ButtonVariant.LOADING -> {
                    CircularProgressBar()
                }
            }
        }
    }
}

@Composable
fun IconButton(
    icon: Int,
    contentDescription: Int,
    onClick: () -> Unit
) {
    androidx.compose.material3.IconButton(
        onClick = { onClick() },
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = Color.Transparent
        ),
        content = {
            Image(
                painter = painterResource(id = icon),
                contentDescription = stringResource(
                    contentDescription
                )
            )
        }
    )
}