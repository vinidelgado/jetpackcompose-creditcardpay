package com.vini.creditcardpay.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.vini.creditcardpay.state.PaymentFlag
import com.vini.creditcardpay.ui.theme.Blue
import com.vini.creditcardpay.ui.theme.CardBackground
import com.vini.creditcardpay.ui.theme.CreditCardTheme
import com.vini.creditcardpay.ui.theme.typographyCreditCardPay
import com.vini.twitch.creditcardpay.R

@Composable
fun PaymentTypeSection(
    modifier: Modifier = Modifier,
    paymentFlag: PaymentFlag,
    paymentText: String
) {
    FoundationRow(modifier = modifier.fillMaxSize().background(CardBackground)) {
        TwoRow(primary = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_card_outline),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    colorFilter = ColorFilter.tint(Blue),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = paymentText,
                    color = Blue,
                    style = typographyCreditCardPay.bodyMedium
                )
            }
        }, secondary = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                val rawImage = if (paymentFlag == PaymentFlag.MASTERCARD) {
                    R.raw.mastercard
                } else {
                    R.raw.visa
                }
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(rawImage),
                )
                LottieAnimation(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(vertical = 8.dp),
                    composition = composition,
                    contentScale = ContentScale.FillHeight,
                )
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentTypeSectionSample() {
    CreditCardTheme {
        PaymentTypeSection(paymentFlag = PaymentFlag.MASTERCARD, paymentText = "Crédito")
    }
}