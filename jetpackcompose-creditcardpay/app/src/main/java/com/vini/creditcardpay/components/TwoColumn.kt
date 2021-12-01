package com.vini.creditcardpay.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TwoColumn(
    modifier: Modifier = Modifier,
    secondary: @Composable () -> Unit,
    primary: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        primary()
        secondary()
    }
}