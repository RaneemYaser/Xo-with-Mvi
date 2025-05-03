package com.example.simpleCounterMVI


data class CalculateState(
    val value1: String = "",
    val firstState : String = "",
    val operation: String = "",
    val finalValue : String = ""
)
