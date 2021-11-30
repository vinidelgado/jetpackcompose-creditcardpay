package com.vini.creditcardpay.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vini.creditcardpay.ui.theme.CardBackground
import com.vini.creditcardpay.ui.theme.White20
import com.vini.creditcardpay.ui.theme.md_theme_dark_onError
import com.vini.creditcardpay.ui.theme.typographyCreditCardPay

@Composable
fun CreditCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = CardBackground,
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.7f)

    ) {
        Column() {
            CreditCardName()
            VisaAnimation()
        }
    }
}

@Composable
fun CreditCardName(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "MER\nCADO\nPAGO",
            modifier = Modifier.padding(4.dp),
            color = White20,
            style = typographyCreditCardPay.displayLarge
        )
    }
}