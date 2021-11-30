package com.vini.creditcardpay.screens.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vini.creditcardpay.state.StateScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardProximityViewModel @Inject constructor() : ViewModel(), LifecycleObserver {
    private val _navigateStep = MutableLiveData<StateScreen>()
    val navigateStep: LiveData<StateScreen> = _navigateStep


    fun init() {
        _navigateStep.value = StateScreen.WAITING_CARD_PROXIMITY
    }

    fun nextStep(step: StateScreen) {
        when (step) {
            StateScreen.WAITING_CARD_PROXIMITY -> {
                _navigateStep.value = StateScreen.VALIDATING_CARD
            }
            StateScreen.VALIDATING_CARD -> {
                _navigateStep.value = StateScreen.CARD_RECOGNIZED
            }
            StateScreen.CARD_RECOGNIZED -> {
                _navigateStep.value = StateScreen.CARD_DONE
            }
            else -> {
                _navigateStep.value = StateScreen.CARD_NONE
            }
        }
    }

}