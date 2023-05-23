package com.example.cafes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

fun onLogInClick(username: String, password: String): Boolean {
    val users = getUsers()
    val user = users.find { it.userName == username }
    return user?.password.equals(password)
}

sealed class Screen(val route:String){
    object LoginScreen: Screen(route = "logInScreen")
    object NewAccount: Screen(route = "signInScreenLogo")
    object Enter: Screen(route = "enterApp")
}

@Composable
fun CreateAccountScreen(){
    call()
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
        composable(route = Screen.Enter.route){
            Main()
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
                    text = "Cafetería BDP",
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
        Body(navController = navController)
    }
}