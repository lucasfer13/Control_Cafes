package com.example.cafes.screens

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import com.example.cafes.models.Carton
import com.example.cafes.models.TypeCarton
import com.example.cafes.models.User
import com.example.cafes.repositorios.CartonRepository
import com.example.cafes.repositorios.UserRepository
import com.example.cafes.viewModel.CartonViewModel
import com.example.cafes.viewModel.TypeCartonViewModel
import com.example.cafes.viewModel.UserViewModel

val cartonViewModel: CartonViewModel = CartonViewModel()
val userViewModel: UserViewModel = UserViewModel()
val typeCartonViewModel: TypeCartonViewModel = TypeCartonViewModel()

/*fun getUsers(): MutableLiveData<ArrayList<User>> {
    return userRepository.userlist
}*/

fun getCartons(): SnapshotStateList<Carton> {
    return cartonViewModel.getCartons()
}

fun getUsers(): SnapshotStateList<User> {
    return userViewModel.getUsers()
}

fun getPacks(): SnapshotStateList<TypeCarton> {
    return typeCartonViewModel.getTypeCartons()
}