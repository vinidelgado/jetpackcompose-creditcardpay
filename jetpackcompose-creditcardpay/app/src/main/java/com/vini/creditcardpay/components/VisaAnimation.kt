package com.vini.creditcardpay.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.vini.creditcardpay.ui.theme.Blue
import com.vini.creditcardpay.ui.theme.CardBackground
import com.vini.creditcardpay.ui.theme.CreditCardTheme
import com.vini.creditcardpay.ui.theme.White
import com.vini.creditcardpay.ui.theme.White20
import com.vini.creditcardpay.ui.theme.md_theme_light_error
import com.vini.creditcardpay.ui.theme.typographyCreditCardPay
import com.vini.twitch.creditcardpay.R

@Composable
fun VisaAnimation() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.mastercard),
    )
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        PaymentTypeSection()
        LottieAnimation(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            composition = composition,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
fun PaymentTypeSection() {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_card_outline),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            colorFilter = ColorFilter.tint(Blue),
            modifier = Modifier
                .fillMaxWidth(0.15f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Débito",
            color = Blue,
            style = typographyCreditCardPay.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenSample() {
    CreditCardTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = CardBackground),
            contentAlignment = Alignment.Center
        ) {
            PaymentTypeSection()
        }
    }
}