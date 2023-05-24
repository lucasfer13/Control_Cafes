package com.example.cafes.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cafes.R
import com.example.cafes.models.Carton
import com.example.cafes.models.User
import com.example.cafes.ui.theme.CafesTheme

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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            visualTransformation = PasswordVisualTransformation()
        )

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (!isUsernameError.value && !isPasswordError.value) {
                        onLogInClick(username.value, password.value)
                        navController.navigate(Screen.Enter.route)
                    }
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

@Composable
fun Cards(nombres: ArrayList<String>, packs: ArrayList<String>){
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        var i: Int = 0
        while(i < nombres.size) {
            if (i%2==0) {
                Row{
                    Card(nombres.get(i), packs.get(i))
                    i++
                    if (i < nombres.size) {
                        Card(nombres.get(i), packs.get(i))
                        i++
                    }
                }
            }
        }
    }
}

@Composable
fun Card(name: String, pack: String){
    Card( Modifier.padding(10.dp)
        //elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = name,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Pack: ${pack} €",
                    style = TextStyle(fontSize = 14.sp)
                )
            }
            Column (
                modifier = Modifier.padding(16.dp)
            ) {
                IconButton(onClick = { /*TODO*/ },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.coffee_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    CafesTheme() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val nombres: ArrayList<String> = ArrayList<String>()
            nombres.add("Juan")
            nombres.add("Lucas")
            nombres.add("Montse")
            val packs: ArrayList<String> = ArrayList<String>()
            packs.add("5")
            packs.add("10")
            packs.add("20")
            Cards(nombres, packs)
        }
    }
}