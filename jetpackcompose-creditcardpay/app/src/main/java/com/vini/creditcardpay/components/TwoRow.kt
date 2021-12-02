package com.vini.creditcardpay.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TwoRow(
    modifier: Modifier = Modifier,
    secondary: @Composable () -> Unit,
    primary: @Composable () -> Unit,
) {
    Row(modifier = modifier) {
        primary()
        secondary()
    }
}