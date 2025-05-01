package com.example.islamicnew

 import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
 import androidx.compose.foundation.clickable
 import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
 import androidx.compose.foundation.lazy.LazyRow
 import androidx.compose.foundation.lazy.itemsIndexed
 import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
 import androidx.compose.material3.Scaffold
 import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
 import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
 import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    val Items = listOf("masjed", "doaa", "aszar", "athan")
     val masjedList = List(5) { // or fetch from a ViewModel
        Pair("Masjed al afghany", "Masjed al afghany")
    }
    Scaffold(
        bottomBar = { ButtomBar() },
        topBar = {TopBar()}
    ){
            innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                ItemsRow(Items)
                Spacer(modifier = Modifier.height(20.dp))
                MainImage()
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "Masjed",
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))

                ImageCard(masjedList)

            }

        }
    }


}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .padding(top = 10.dp, start = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween, // <-- THIS IS IMPORTANT
        verticalAlignment = Alignment.CenterVertically // optional: to center vertically
    ) {
        Column(modifier = Modifier) {
            Text(text = "your location ", fontSize = 12.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "phalest,KR",
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Arrow"
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.masgied),
            contentDescription = "My beautiful image",
            modifier = Modifier
                .height(70.dp)
                .padding(top = 10.dp, end = 10.dp)
                .clip(CircleShape)
        )
    }}

@Composable
fun ItemsRow(ItemList: List<String>) {
    Row(
        modifier = Modifier
             .horizontalScroll(rememberScrollState()) // <-- make it scrollable
    ) {
        ItemList.forEachIndexed { index, location ->
            Text(text = location, fontSize = 12.sp)
            if (index < ItemList.lastIndex) {
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun MainImage() {
    Image(
        painter = painterResource(id = R.drawable.masgied),
        contentDescription = "main image",
        modifier = Modifier
            .padding(end = 12.dp)
            .height(200.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun MasjedCard(
    imageResId: Int,
    title: String,
    subtitle: String,
    onClickSeeMore: () -> Unit = {}
) {
    Box {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Masjed image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(300.dp)
                .width(230.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = title,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(180.dp)
                    .height(30.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = subtitle,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .width(100.dp)
                    .height(30.dp)
                    .border(2.dp, Color.White, RoundedCornerShape(10.dp))
                    .clickable { onClickSeeMore() }
            ) {
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "see more",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }
    }
}
@Composable
fun ImageCard( masjedList: List<Pair<String, String>>){

    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(masjedList) { index, (title, subtitle) ->
            MasjedCard(
                imageResId = R.drawable.masgied,
                title = title,
                subtitle = subtitle,
            )
        }
    }
}
@Composable
fun ButtomBar(){
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
         containerColor = Color.White,
        contentColor = Color.Black,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        // Add icons or other items to the bottom bar
        Column() {
            Icon(Icons.Default.Home, contentDescription = "Home")
            Text(text = "home", fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.Center // Optional: Center content vertically
        ) {
            Icon(Icons.Default.Notifications, contentDescription = "Settings")
            Text(text = "settings", fontSize = 12.sp)

        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.Center // Optional: Center content vertically
        ) {
            Icon(Icons.Default.Lock, contentDescription = "Settings")
            Text(text = "donates", fontSize = 12.sp)

        }
    }

}
@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}