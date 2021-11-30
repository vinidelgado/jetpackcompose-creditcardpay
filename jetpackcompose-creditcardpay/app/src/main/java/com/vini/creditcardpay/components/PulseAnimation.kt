package com.vini.creditcardpay.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.vini.twitch.creditcardpay.R

@Composable
fun PulseAnimation(green: Boolean = false) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            if (green) {
                R.raw.pulse_green
            } else {
                R.raw.pulse
            }
        ),
    )

    LottieAnimation(
        modifier = Modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
        contentScale = ContentScale.FillHeight,
    )
}