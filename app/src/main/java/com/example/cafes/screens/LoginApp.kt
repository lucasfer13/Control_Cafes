package com.example.cafes.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val isUsernameError = remember { mutableStateOf(false) }
        val isPasswordError = remember { mutableStateOf(false) }

        TextField(
            value = username.value,
            onValueChange = { value ->
                username.value = value
                isUsernameError.value = value.isEmpty()
            },
            label = { Text("Nombre de usuario") },
            modifier = Modifier
                .padding(16.dp)
                .border(
                    width = 1.dp,
                    color = if (isUsernameError.value) Color.Red else Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
        )
        TextField(
            value = password.value,
            onValueChange = { value ->
                password.value = value
                isPasswordError.value = value.matches(Regex("[0123456789]"))
                isPasswordError.value = value.length != 4
            },
            label = { Text("Contraseña") },
            modifier = Modifier
                .padding(16.dp)
                .border(
                    width = 1.dp,
                    color = if (isPasswordError.value) Color.Red else Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (!isUsernameError.value && !isPasswordError.value) onLogInClick(username.value, password.value)
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Entrar")
            }
            Button(
                onClick = {
                          navController.navigate(Screen.NewAccount.route)
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Crear usuario")
            }
        }
    }
}

sealed class Screen(val route:String){
    object LoginScreen: Screen(route = "loginscreen")
    object NewAccount: Screen(route = "signinscreenlogo")
}

@Composable
fun CreateAccountScreen(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route){
            LogInScreen(navController = navController)
        }
        composable(route = Screen.NewAccount.route) {
            SignInScreenLogo()
        }
    }
}

@Composable
fun LogInScreen(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
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
                    text = "Made by Becarios",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp),
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
        Body(navController = navController)
    }
}

fun onLogInClick(username:String, password:String){

}