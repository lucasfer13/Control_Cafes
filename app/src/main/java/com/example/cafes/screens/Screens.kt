package com.example.cafes.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

lateinit var navController: NavHostController
var users = getUsers()

sealed class Screen(val route:String){
    object LoginScreen: Screen(route = "logInScreen")
    object NewAccount: Screen(route = "signInScreenLogo")
    object Enter: Screen(route = "enterApp")
    object NewCarton: Screen(route = "newCarton")
    object SelectPack: Screen(route = "selectPack")
    object PassScreen: Screen(route = "passScreen")
    object ChangePasswordScreen: Screen(route = "changePasswordScreen")
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
        composable(route = Screen.NewCarton.route, ) {
            NewCarton()
        }
        composable(route = Screen.Enter.route){
            Main()
        }
        composable(route = Screen.SelectPack.route){
            Packs()
        }
        composable(route = Screen.NewAccount.route){
            SignInScreenLogo()
        }
        composable(route = Screen.PassScreen.route){
            PasswordScreen()
        }
        composable(route = Screen.ChangePasswordScreen.route){
            ChangePasswordScreen()
        }
    }
}