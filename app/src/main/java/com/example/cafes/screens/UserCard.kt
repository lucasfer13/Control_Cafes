package com.example.cafes.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cafes.models.User

@Composable
fun NewCarton(navController: NavController){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Cabecera()
        //UsersCardsList(navController = navController)
    }
}

/*@Composable
fun UsersCardsList(navController: NavController){
    val users = remember { getUsers() }
    LazyColumn() {
        items(users) {
            user -> UserCard(user = user, navController = navController)
        }
    }
}*/

/*@Composable
fun UserCard(user: User, navController: NavController) {
    Card(
        Modifier
            .padding(10.dp)
    ) {

    }
}*/