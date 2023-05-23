package com.example.cafes.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafes.ui.theme.Brown
import com.example.cafes.ui.theme.CafesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CafesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CafesTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun PrevItemCarton() {
    CafesTheme {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Brown)) {
            Column() {
                Text(text = "Precio", Modifier.padding(10.dp))
                Text(text = "Date", Modifier.padding(10.dp))
            }
            Column() {
                Text(text = "Totales", Modifier.padding(10.dp))
                Text(text = "Restantes", Modifier.padding(10.dp))
            }
        }
    }
}
