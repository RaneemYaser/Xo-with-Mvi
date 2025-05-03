package com.example.jetbackcompose

import android.os.Bundle
 import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
 import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetbackcompose.ui.theme.JetBackComposeTheme
 import com.example.simpleCounterMVI.CounterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                         modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    CounterScreen(modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBackComposeTheme {
        Greeting()
    }
}}