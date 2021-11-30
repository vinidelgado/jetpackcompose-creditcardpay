package com.vini.creditcardpay.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vini.creditcardpay.components.CreditCard
import com.vini.creditcardpay.components.PulseAnimation
import com.vini.creditcardpay.components.VisaAnimation
import com.vini.creditcardpay.state.StateScreen
import kotlinx.coroutines.delay

@Composable
fun CardProximityScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var stateScreen by remember { mutableStateOf(StateScreen.WAITING_CARD_PROXIMITY) }
        when (stateScreen) {
            StateScreen.CARD_RECOGNIZED -> {
            }
            StateScreen.VALIDATING_CARD -> {
                PulseAnimation(green = true)
            }
            else -> {
                PulseAnimation(green = false)
            }
        }
        CreditCard()
        LaunchedEffect(key1 = true) {
            delay(2000L)
            stateScreen = StateScreen.VALIDATING_CARD
            delay(2000L)
            stateScreen = StateScreen.CARD_RECOGNIZED
        }
    }
}