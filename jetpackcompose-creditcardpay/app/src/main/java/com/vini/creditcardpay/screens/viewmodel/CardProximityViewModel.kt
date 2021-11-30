package com.vini.creditcardpay.screens.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vini.creditcardpay.state.StateScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CardProximityViewModel @Inject constructor() : ViewModel(), LifecycleObserver {
    private var value = 0
    private val _state = MutableLiveData(StateScreen.WAITING_CARD_PROXIMITY)
    val state: LiveData<StateScreen> get() = _state

    fun nextStep() {
        when (_state.value) {
            StateScreen.WAITING_CARD_PROXIMITY -> {
                _state.value = StateScreen.VALIDATING_CARD
            }
            StateScreen.VALIDATING_CARD -> {
                _state.value = StateScreen.CARD_RECOGNIZED
            }
            StateScreen.CARD_RECOGNIZED -> {
                _state.value = StateScreen.CARD_DONE
            }
            else -> {
                _state.value = StateScreen.CARD_NONE
            }
        }
    }

    sealed interface CardProximityUiState {
        val state: StateScreen
    }

}