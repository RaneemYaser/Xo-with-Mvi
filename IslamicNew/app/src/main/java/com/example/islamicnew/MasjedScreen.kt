package com.example.islamicnew

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MasjedScreen() {
    val timeItems = listOf("azan", "iqama", "gomaa")
    val prayerTimes = listOf(
        "Start:" to "6:30 AM",
        "End:" to "7:45 AM",
    )
    Scaffold(
        topBar = { startPar() },
        bottomBar = { PrayerTime(timeItems, prayerTimes) })
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .padding(horizontal = 12.dp)
        ) {
            MasjedImage()
            Spacer(modifier = Modifier.height(16.dp))
            MasjedName()
            MasjedPlace()
        }
    }
}


@Composable
fun startPar(onClickSeeMore: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
        Text(
            text = "save", fontSize = 20.sp, color = Color.Blue,
            modifier = Modifier.clickable(onClick = onClickSeeMore)
        )
    }
}

@Composable
fun MasjedImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(R.drawable.masgied),
            contentDescription = "image",
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 12.dp, end = 12.dp)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                .height(30.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp), text = "change the photo"
            )
        }

    }
}

@Composable
fun MasjedName() {
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        Text(text = "Masjed Name", fontSize = 16.sp, fontWeight = FontWeight.Black)
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp, color = Color.DarkGray,
                    shape = RoundedCornerShape(12.dp)
                )
                .height(50.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Masjed al naser",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MasjedPlace() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Address",
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                color = Color.Gray,
                text = "123 Main Street, Springfield, IL 62704, USA",
                fontSize = 12.sp,

                )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                color = Color.Blue,
                text = "Address with map",
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )
            Spacer(modifier = Modifier.height(12.dp))

        }
        Image(
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(R.drawable.map), contentDescription = "map"
        )
    }
}

@Composable
fun PrayerTime(item: List<String>, prayerTimed: List<Pair<String, String>>) {
    Column (modifier = Modifier.padding(horizontal = 12.dp)) {
        Text(
            text = "address",
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            item.forEachIndexed { location, prayer ->
                Box(
                    modifier = Modifier
                        .padding(bottom = 12.dp, end = 12.dp)
                        .border(
                            width = 1.dp, color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .height(30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = prayer,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


        }
        prayerTimed.forEach { (label, time) ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    text = label,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    text = time,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

        }


    }
}

@Preview
@Composable
private fun MasjedScreenPrev() {
    MasjedScreen()
}