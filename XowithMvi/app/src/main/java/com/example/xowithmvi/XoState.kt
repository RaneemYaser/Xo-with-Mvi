package com.example.xowithmvi

data class XoState (
    val score1 :Int = 0,
    val score2: Int =0,
    val counter : Int = 0,
    val boxX : String = "",
    val boxO : String = "",
    val list : List<String> =listOf<String>("","","","","","","","",""),
    val Xlist : List<Int> = listOf<Int>(),
    val Olist : List<Int> = listOf<Int>(),
    )
