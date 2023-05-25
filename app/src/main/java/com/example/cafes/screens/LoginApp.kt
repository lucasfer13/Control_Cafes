package com.example.cafes.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cafes.models.Carton
import com.example.cafes.viewModel.CartonViewModel

/*fun onLogInClick(username: String, password: String): Boolean {
    val users = getUsers()
    val user = users.find { it.userName == username }
    return user?.password.equals(password)
}*/

@Composable
fun LogInScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Cabecera()
        Cards()
    }
}