package com.example.cafes.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

var navController: NavHostController
    get() {
        TODO()
    } set(n: NavHostController) {
        navController = n
    }

sealed class Screen(val route:String){
    object LoginScreen: Screen(route = "logInScreen")
    object NewAccount: Screen(route = "signInScreenLogo")
    object Enter: Screen(route = "enterApp")
    object NewCarton: Screen(route = "newCarton")
    object SelectPack: Screen(route = "selectPack")
}

@Composable
fun CreateAccountScreen(){
    navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route){
            LogInScreen()
        }
        composable(route = Screen.NewCarton.route) {
            NewCarton()
        }
        composable(route = Screen.Enter.route){
            Main()
        }
        composable(route = Screen.SelectPack.route){
            Packs()
        }
    }
}