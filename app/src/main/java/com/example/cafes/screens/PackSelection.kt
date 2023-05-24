package com.example.cafes.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.cafes.models.Carton
import com.example.cafes.models.TypeCarton
import com.example.cafes.models.User

val packs = getPacks()
//var u: User = null

@Composable
fun Packs(user: User){
    //u = user
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Cabecera()
        PacksCards()
    }
}

@Composable
fun PacksCards(){
    val p = remember { packs }
    LazyColumn() {
        items(p){
            type -> PackCard(pack = type)
        }
    }
}

@Composable
fun PackCard(pack: TypeCarton){
    Card(
        Modifier
            .padding(10.dp)
            .clickable { MakeNewCarton(pack) }
    ) {
        Text(
            text = "Precio: ${pack.price} €",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Cafés: ${pack.total}",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

fun MakeNewCarton(type: TypeCarton){
    /*val carton: Carton = Carton(consumed = 0, total = type.total, user = u, type = type)
    cartonViewModel.addCarton(carton)*/
}

