package com.example.composeintro

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GreetingViewModel: ViewModel() {
    private val _state = mutableStateOf(GreetingState())
    val state: State<GreetingState> = _state

    fun setMessage(fine: Boolean){
        _state.value = when(fine){
            true -> _state.value.copy(message = "I'm glad you are fine!")
            false -> _state.value.copy(message = "I'm sorry to hear that. Hopefully you feel better soon!")
        }
    }
}