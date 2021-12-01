package com.vini.creditcardpay.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vini.creditcardpay.state.PaymentFlag
import com.vini.creditcardpay.state.StateScreen
import com.vini.creditcardpay.ui.theme.CardBackground
import com.vini.creditcardpay.ui.theme.White20
import com.vini.creditcardpay.ui.theme.typographyCreditCardPay

@Composable
fun CreditCard(stateScreen: StateScreen?) {
    Card(
        shape = RoundedCornerShape(12.dp),
        backgroundColor = CardBackground,
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.7f)

    ) {
        Column {
//            CreditCardName()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "MER\nCADO\nPAGO",
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 20.dp),
                    color = White20,
                    style = typographyCreditCardPay.displayLarge
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f),
            ) {
                if (stateScreen == StateScreen.CARD_RECOGNIZED) {
                    CheckMarkAnimation()
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                PaymentTypeSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.45f),
                    paymentFlag = PaymentFlag.MASTERCARD,
                    paymentText = "Crédito"
                )
            }
        }
    }
}

@Composable
fun CreditCardName() {

}