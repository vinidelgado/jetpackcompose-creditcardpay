package com.vini.creditcardpay.screens

import androidx.compose.animation.Animatable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import com.vini.creditcardpay.components.CreditCard
import com.vini.creditcardpay.components.PulseAnimation
import com.vini.creditcardpay.screens.viewmodel.CardProximityViewModel
import com.vini.creditcardpay.state.StateScreen
import com.vini.creditcardpay.ui.theme.Green
import com.vini.creditcardpay.ui.theme.White
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@Composable
fun CardProximityScreen(viewModel: CardProximityViewModel = viewModel()) {
    val stateScreen by viewModel.state.observeAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        when (stateScreen) {
            StateScreen.CARD_RECOGNIZED -> {
                ShowBoxGreen()
            }
            StateScreen.VALIDATING_CARD -> {
                PulseAnimation(green = true)
            }
            else -> {
                PulseAnimation(green = false)
            }
        }
        CreditCard(stateScreen)
        LaunchedEffect(key1 = true) {
            delay(2000L)
            viewModel.nextStep()
            delay(2000L)
            viewModel.nextStep()
        }
    }
}

@Composable
fun ShowBoxGreen() {
    val color = remember { Animatable(White) }
    LaunchedEffect(true) {
        color.animateTo(
            Green,
            animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing)
        )
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(color.value)
    )
}