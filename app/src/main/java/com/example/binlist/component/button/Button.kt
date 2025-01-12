package com.example.binlist.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.binlist.ui.theme.BinTheme
import com.example.binlist.utils.CommonString

@Composable
fun PrimaryButton(
    variant: ButtonVariant,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .heightIn(56.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = BinTheme.colors.primary,
            disabledContainerColor = BinTheme.colors.primary
        ),
        enabled = variant == ButtonVariant.FILLED,
        shape = RoundedCornerShape(size = 4.dp),
        contentPadding = PaddingValues(horizontal = 13.dp)
    ) {
        Text(
            text = stringResource(CommonString.text_lookup),
            style = BinTheme.typography.regular12,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButton() {
    PrimaryButton(variant = ButtonVariant.FILLED)
}