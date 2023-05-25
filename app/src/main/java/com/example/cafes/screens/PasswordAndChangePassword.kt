package com.example.cafes.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.cafes.models.User
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun hash(password: String): String {
    try {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(password.toByteArray(StandardCharsets.UTF_8))
        return String.format("%064x", BigInteger(1, hash))
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Cabecera()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val password = remember { mutableStateOf("") }
            val isPasswordError = remember { mutableStateOf(false) }

            TextField(
                value = password.value,
                onValueChange = { value ->
                    password.value = value
                    isPasswordError.value = value.matches(Regex("[0123456789]"))
                    isPasswordError.value = value.length != 4
                    if (!isPasswordError.value) {
                        if (verifyPassword(password = password.value)) navController.navigate(Screen.NewCarton.route)
                        else isPasswordError.value = true
                    }
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
            Text(
                    text = "Cambiar contraseña",
            Modifier.clickable { navController.navigate(Screen.ChangePasswordScreen.route) }
            )
        }
    }
}

fun verifyPassword(password: String): Boolean{
    val user = users.find { it.userName == "admin" }
    if (user != null) {
        val p = hash(password = password)
        return user.password == hash(password = password)
    }
    return false
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Cabecera()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val password = remember { mutableStateOf("") }
            val first = remember { mutableStateOf("") }
            val repeat = remember { mutableStateOf("") }
            val isPasswordError = remember { mutableStateOf(true) }
            val isFirstError = remember { mutableStateOf(true) }
            val isRepeatError = remember { mutableStateOf(true) }

            TextField(
                value = password.value,
                onValueChange = { value ->
                    password.value = value
                    isPasswordError.value = value.matches(Regex("[0123456789]"))
                    isPasswordError.value = value.length != 4
                    if (!isPasswordError.value) {
                        isPasswordError.value = !verifyPassword(password = password.value)
                    }
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

            TextField(
                value = first.value,
                onValueChange = { value ->
                    first.value = value
                    isFirstError.value = value.matches(Regex("[0123456789]"))
                    isFirstError.value = value.length != 4
                },
                label = { Text("Contraseña nueva") },
                modifier = Modifier
                    .padding(16.dp)
                    .border(
                        width = 1.dp,
                        color = if (isFirstError.value) Color.Red else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                visualTransformation = PasswordVisualTransformation()
            )

            TextField(
                value = repeat.value,
                onValueChange = { value ->
                    repeat.value = value
                    isRepeatError.value = value.matches(Regex("[0123456789]"))
                    isRepeatError.value = value.length != 4
                    if (!isRepeatError.value && !isFirstError.value) {
                        isRepeatError.value = repeat.value != first.value
                    }
                },
                label = { Text("Repetir contraseña") },
                modifier = Modifier
                    .padding(16.dp)
                    .border(
                        width = 1.dp,
                        color = if (isRepeatError.value) Color.Red else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                visualTransformation = PasswordVisualTransformation()
            )
            
            Button(
                enabled = !isRepeatError.value && !isPasswordError.value && !isFirstError.value,
                onClick = {
                val user = users.find { it.userName == "admin" }
                if (user != null) {
                    user.password = hash(repeat.value)
                    userViewModel.modificarUsuario(user)
                }
            }) {
                Text(text = "Confirmar cambios")
            }
        }
    }
}