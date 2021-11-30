package com.vini.creditcardpay.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.vini.twitch.creditcardpay.R

@Composable
fun CheckMarkAnimation() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.check_mark),
    )
    LottieAnimation(
        modifier = Modifier.fillMaxWidth(0.25f),
        composition = composition,
        contentScale = ContentScale.FillWidth,
    )
}