package com.example.simpleCounterMVI

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculateViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculateState())
    val state: StateFlow<CalculateState> = _state

    fun buttonPressed(intent: CalculateIntent) {
        when (intent) {
            is CalculateIntent.IntentValue -> operationEqual()
            is CalculateIntent.InterNumber -> numberPressed(intent.num)
            is CalculateIntent.Interoperation -> operationPressed(intent.operation)
            CalculateIntent.IntentDot -> operationDot()
        }
    }

    fun numberPressed(number: Int) {

        _state.value = _state.value.copy(
            value1 = _state.value.value1 + number,

        )
        _state.value= _state.value.copy(
            finalValue = _state.value.value1
        )
    }
    fun operationPressed(operation: String) {
        _state.value = _state.value.copy(
            firstState = _state.value.value1,
            finalValue = "",
            value1 = "", operation = operation
        )
    }
    fun operationDot(){

        _state.value = _state.value.copy(
            value1 = _state.value.value1 + ".",

            )
        _state.value= _state.value.copy(
            finalValue = _state.value.value1
        )
    }

    fun operationEqual() {
        val operation: String = _state.value.operation
        val operand1: Double = _state.value.firstState.toDouble()
        val operand2: Double = _state.value.value1.toDouble()
        if (true) {
            val result =
                when (operation) {
                    "+" -> operand1 + operand2
                    "*" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    "-" -> operand1 - operand2
                    else -> {
                        _state.value=_state.value.copy(
                            finalValue = "error",
                            firstState = "", value1 = "",
                            operation = "")
                    }
                }
            _state.value=_state.value.copy( firstState = "", value1 = "",
                operation = "",finalValue = result.toString())
        }
    }


}