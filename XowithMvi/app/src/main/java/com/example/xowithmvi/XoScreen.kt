package com.example.xowithmvi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun XoScreen(
    modelView: XoModelView = viewModel()
) {
    val state by modelView.state.collectAsState()
    val list1 = listOf<Int>(1, 2, 3)
    val list2 = listOf<Int>(4, 5, 6)
    val list3 = listOf<Int>(7, 8, 9)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        RowPlayer(state.score1.toString(), state.score2.toString())
        RowsInOx(
            list1,
            text = state, onclick = { modelView.buttonClicked(it) }, modifier = Modifier.weight(1f))
        RowsInOx(
            list2,
            text = state,
            onclick = { modelView.buttonClicked(it) },
            modifier = Modifier.weight(1f)
        )
        RowsInOx(
            list3,
            text = state,
            onclick = { modelView.buttonClicked(it) },
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
fun RowsInOx(
    list: List<Int>,
    text: XoState,
    modifier: Modifier,
    onclick: (XoIntent) -> Unit) {
    Row(modifier = modifier.fillMaxWidth()) {
        list.forEachIndexed { i, int ->
            Box(
                contentAlignment = Alignment.Center, modifier = modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { onclick(XoIntent.Click1(int)) }
                    .clip(shape = RoundedCornerShape(12.dp))
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(width = 1.dp, color = Color.Green))
            {
                 Text(text = text.list[int-1]
                     , fontSize = 60.sp)
            }
        }
    }
}


@Composable
fun RowPlayer(score1: String, score2: String) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column  {
                Text(text = "player1", fontSize = 40.sp, color = Color.Green)
                Text(text = score1, fontSize = 40.sp, color = Color.Green)
            }
            Column {
                Text(text = "player2", fontSize = 40.sp, color = Color.Red)
                Text(text = score2, fontSize = 40.sp, color = Color.Red)
            }
        }

    }
}

@Preview
@Composable
private fun XoScreenPrev() {
    XoScreen()
}