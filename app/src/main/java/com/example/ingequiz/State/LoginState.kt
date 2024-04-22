package com.example.ingequiz.State


data class LoginState(
    val email: String = "",
    val password : String = "",
    val IsValidEmail: Boolean = false,
    val IsValidPasword: Boolean = false
)
