package com.example.cafes.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route:String){
    object LoginScreen: Screen(route = "logInScreen")
    object NewAccount: Screen(route = "signInScreenLogo")
    object Enter: Screen(route = "enterApp")
    object NewCarton: Screen(route = "newCarton")
    object SelectPack: Screen(route = "selectPack")
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
        composable(route = Screen.NewCarton.route) {
            NewCarton(navController = navController)
        }
        composable(route = Screen.Enter.route){
            Main(navController = navController)
        }
        composable(route = Screen.SelectPack.route){
            Packs()
        }
    }
}