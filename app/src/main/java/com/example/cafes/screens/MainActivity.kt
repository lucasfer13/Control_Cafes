package com.example.cafes.screens

import android.widget.Toast
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafes.R
import com.example.cafes.models.Carton
import com.example.cafes.ui.theme.CafesTheme

lateinit var cartonUser: Carton
@Composable
fun Main(){
    val restantes = remember { mutableStateOf(cartonUser.restantes.toString()) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MadeBy()
        PriceDate(restantes)
        MakeACoffee(restantes)
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
fun PriceDate(restantes : MutableState<String>){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    )
    {
        Text(
            text = "Pack: ${cartonUser.type.price} €",
            modifier = Modifier
                .padding(start = 50.dp)
        )
        Text(
            text = "Totales: ${cartonUser.total}",
            modifier = Modifier
                .padding(start = 50.dp)
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
                .padding(end = 50.dp)
        )
        Text(
            text = "Restantes: ${restantes.value}",
            modifier = Modifier
                .padding(end = 50.dp)
                .padding(top = 40.dp)
        )
    }
}

@Composable
fun MakeACoffee(restantes : MutableState<String>){
    val context = LocalContext.current
    Button(
        onClick = {
            cartonViewModel.restarCafeCarton(cartonUser)
            restantes.value = cartonUser.restantes.toString()
            if (cartonUser.restantes == 0) navController.navigate(Screen.LoginScreen.route)
            Toast.makeText(context, R.string.toast_cafe, Toast.LENGTH_SHORT).show()
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
            onClick = { navController.navigate(Screen.LoginScreen.route)}
        ) {
            Icon(
                Icons.Filled.ArrowBack,
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
        }
    }
}


