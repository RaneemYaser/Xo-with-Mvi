package com.example.xowithmvi

sealed class XoIntent {
    class Click1 (val boxNum : Int) : XoIntent()
 }