package com.example.simpleCounterMVI

sealed class CalculateIntent {
    class InterNumber(val num: Int) : CalculateIntent()
    class Interoperation(val operation: String) : CalculateIntent()
    object IntentValue : CalculateIntent()
    object IntentDot: CalculateIntent()
}