package com.example.cafes.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
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
@Composable
fun NewCarton(){
    Box(Modifier.fillMaxSize()){
        //Cabecera()
        UsersCardsList()
        //NewUserButton()
    }
}

@Composable
fun NewUserButton(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Column(Modifier.fillMaxSize(), verticalArrangement =  Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.NewAccount.route)
                    },
                    modifier = Modifier.padding(0.dp)
                ) {
                    Text("Nuevo usuario")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersCardsList(){
    val u = remember { users }
    val listState = rememberLazyListState()
    Cabecera()
    Box(
        modifier = Modifier
            .padding(top = 90.dp, bottom = 70.dp)
    ){
        LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
        ) {
            items(u.size) {
                    user -> UserCard(user = u[user])
            }
        }
    }
    NewUserButton()
}

/*
LazyColumn(
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = listState
        ) {
            items(u.size) {
                    user -> UserCard(user = u[user])
            }
        }
 */

@Composable
fun UserCard(user: User) {
    Card(
        Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(60.dp)
            .clickable {
                u = user
                navController.navigate(Screen.SelectPack.route)
            }
    ) {
        Text(
            text = user.userName,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 15.dp)
        )
    }
}