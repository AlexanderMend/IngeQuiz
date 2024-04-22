package com.example.ingequiz.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ingequiz.Repositorys.UsersRepository
import com.example.ingequiz.State.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UsersRepository): ViewModel() {
        var state by mutableStateOf(LoginState())
            private set

    fun getUserByEmailAndPass(email:String,password:String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUserByEmailPassword(email,password).collect{
                item ->
                    if (item != null){
                        state = state.copy(email = item.email)
                        state = state.copy(password = item.password)
                        state = state.copy(
                            IsValidEmail = true,
                            IsValidPasword = true,
                        )

                    }else{
                        Log.d("Error","El email o la contraseña son incorrectos")
                    }
            }
        }
    }




}