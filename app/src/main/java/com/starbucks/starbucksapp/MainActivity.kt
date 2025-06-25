package com.starbucks.starbucksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.starbucks.starbucksapp.ui.theme.StarbucksCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksCloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StarbucksApp() // Now calling the StarbucksApp Composable from StarbucksApp.kt
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun DefaultPreview() {
    StarbucksCloneTheme {
        StarbucksApp()
    }
}