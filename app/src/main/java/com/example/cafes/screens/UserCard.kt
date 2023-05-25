package com.example.cafes.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafes.models.User

val users = getUsers()
@Composable
fun NewCarton(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Cabecera()
        UsersCardsList()
    }
}

@Composable
fun UsersCardsList(){
    val u = remember { users }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        )
    ) {
        items(u.size) {
            user -> UserCard(user = u[user])
        }
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        Modifier
            .padding(10.dp)
            .height(60.dp)
            .width(60.dp)
            .clickable {
                u = user
                navController.navigate(Screen.SelectPack.route)
            }
    ) {
        Text(
            text = user.userName,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 15.dp)
        )
    }
}