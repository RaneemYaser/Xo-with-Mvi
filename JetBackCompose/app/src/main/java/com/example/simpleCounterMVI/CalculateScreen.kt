package com.example.simpleCounterMVI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculateViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    val firstRowList = listOf<String>("1", "2", "3", "+")
    val secondRowList = listOf<String>("4", "5", "6", "-")
    val thirdRowList = listOf<String>("7", "8", "9", "*")
    val forthRowList = listOf<String>(".", "0", "=", "/")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        CalculateScreen(Modifier.weight(1f), state.finalValue)
        ItemsInRow(firstRowList, onClick = { viewModel.buttonPressed(it) }, Modifier.weight(1f))
        ItemsInRow(secondRowList, onClick = { viewModel.buttonPressed(it) }, Modifier.weight(1f))
        ItemsInRow(thirdRowList, onClick = { viewModel.buttonPressed(it) }, Modifier.weight(1f))
        ItemsInRow(forthRowList, onClick = { viewModel.buttonPressed(it) }, Modifier.weight(1f))
    }

}

@Composable
fun ItemsInRow(
    contents: List<String>,
    onClick: (CalculateIntent) -> Unit, modifier: Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        contents.forEachIndexed { i, item ->
            Box(
                modifier = modifier
                    .weight(1f)
                    .clickable {
                        when {
                            item.toIntOrNull() != null -> {
                                onClick(CalculateIntent.InterNumber(item.toInt()))
                            }

                            item == "=" -> {
                                onClick(CalculateIntent.IntentValue)
                            }
                            item == "." -> {
                                onClick(CalculateIntent.IntentDot)
                            }


                            else -> {
                                onClick(CalculateIntent.Interoperation(item))

                            }
                        }


                    }
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Blue,
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = item,
                    fontSize = 60.sp,
                    color = Color.Black
                )
            }

        }
    }

}

@Composable
fun CalculateScreen(modifier: Modifier, screenText: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            modifier = Modifier.padding(start = 12.dp, top = 12.dp),
            text = screenText, fontSize = 70.sp
        )
    }
}

@Preview
@Composable
private fun CounterScreenPrev() {
    CounterScreen()
}
