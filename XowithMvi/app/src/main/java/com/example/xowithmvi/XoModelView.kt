package com.example.xowithmvi

 import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class XoModelView : ViewModel() {
    private val _state = MutableStateFlow(XoState())
    val state: StateFlow<XoState> = _state


    fun buttonClicked(intent: XoIntent) {
        when (intent) {
            is XoIntent.Click1 -> clicked(intent.boxNum)
        }
    }

    fun clicked(number: Int) {
        val count: Int = _state.value.counter
        if (
            _state.value.Xlist.contains(number) || _state.value.Olist.contains(number))
            return
        val updatedList = _state.value.list.toMutableList()
        if (count % 2 == 0 && count <= 8) {
            updatedList[number - 1] = "X"
            _state.value = _state.value.copy(
                list = updatedList,
                Xlist = _state.value.Xlist + number,
                counter = count + 1
            )
        }
        if (count % 2 != 0 && count <= 8) {
            updatedList[number - 1] = "O"
            _state.value = _state.value.copy(
                list = updatedList,
                Olist = _state.value.Olist + number,
                counter = count + 1
            )
        }
        if (count > 8) {
            _state.value = _state.value.copy(
                counter = 0,
                Xlist = listOf<Int>(),
                Olist = listOf<Int>(),
                list = listOf("", "", "", "", "", "", "", "", "")
            )
        }
        calculateScore()

    }

    fun calculateScore() {
        val listX: List<Int> = _state.value.Xlist
        val listO: List<Int> = _state.value.Olist
        val winnerList1 = listOf<Int>(1, 2, 3)
        val winnerList2 = listOf<Int>(4, 5, 6)
        val winnerList3 = listOf<Int>(7, 8, 9)
        val winnerList4 = listOf<Int>(1, 4, 7)
        val winnerList5 = listOf<Int>(2, 5, 8)
        val winnerList6 = listOf<Int>(3, 6, 9)
        val winnerList7 = listOf<Int>(1, 5, 9)
        val winnerList8 = listOf<Int>(3, 5, 7)

        val winnerX = listOf(
            winnerList3,
            winnerList2,
            winnerList1,
            winnerList4,
            winnerList5,
            winnerList6,
            winnerList7,
            winnerList8
        ).any { winner ->
            winner.sorted() == listX.sorted()
        }
        val winnerO = listOf(
            winnerList3,
            winnerList2,
            winnerList1,
            winnerList4,
            winnerList5,
            winnerList6,
            winnerList7,
            winnerList8
        ).any { winner ->
            winner.sorted() == listO.sorted()
        }

        if (winnerX) {
            viewModelScope.launch {
                waitingX()
            }
        } else if (winnerO) {

            viewModelScope.launch {
                waitingO()
            }
        }
    }

    suspend fun waitingX() {
        delay(500)
        _state.value = _state.value.copy(
            score1 = _state.value.score1 + 1,
            counter = 0,
            Xlist = listOf<Int>(),
            Olist = listOf<Int>(),
            list = listOf("", "", "", "", "", "", "", "", "")
        )
    }

    suspend fun waitingO() {
        delay(500)
        _state.value = _state.value.copy(
            counter = 0,
            score2 = _state.value.score2 + 1,
            Xlist = listOf<Int>(),
            Olist = listOf<Int>(),
            list = listOf("", "", "", "", "", "", "", "", "")
        )
    }


}

