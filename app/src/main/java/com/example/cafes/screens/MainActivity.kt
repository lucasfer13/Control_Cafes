package com.example.cafes.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafes.R
import com.example.cafes.repositorios.UserRepository
import com.example.cafes.ui.theme.CafesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var user : UserRepository = UserRepository()
        user.init()
        setContent {
            CafesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MadeBy()
        PriceDate()
        MakeACoffee()
        ExitApp()
    }
}

@Composable
fun MadeBy(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        /*Image(
            painter = painterResource(id = R.drawable.top_screen),
            contentDescription = ""
        )*/
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "Cafetería Express",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                modifier = Modifier.padding(1.dp)
            )
        }
        Row(
            modifier = Modifier.padding(1.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "Made by Los Becarios",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp),
                modifier = Modifier.padding(1.dp)
            )
        }
    }
}

@Composable
fun PriceDate(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    )
    {
        Text(
            text = "Pack",
            modifier = Modifier
                .padding(start = 100.dp)
        )
        Text(
            text = "Totales",
            modifier = Modifier
                .padding(start = 100.dp)
                .padding(top = 40.dp)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Date",
            modifier = Modifier
                .padding(end = 100.dp)
        )
        Text(
            text = "Restantes",
            modifier = Modifier
                .padding(end = 100.dp)
                .padding(top = 40.dp)
        )
    }
}

@Composable
fun MakeACoffee(){
    Button(
        onClick = {
        }
    ) {
        Icon(
            painter = painterResource(R.drawable.coffee_icon),
            contentDescription = "stringResource(id = R.string.coffee_icon)",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        )
    }
}

@Composable
fun ExitApp(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Lock,
                contentDescription = "Log out",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
    }
}

@Preview
@Composable
fun PrevItemCarton() {
    CafesTheme() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Main()
        }
    }
}


