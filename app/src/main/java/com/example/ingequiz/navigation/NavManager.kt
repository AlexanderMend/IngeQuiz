package com.example.ingequiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ingequiz.ui.views.loginView
import com.example.ingequiz.viewmodel.LoginViewModel
import com.example.ingequiz.viewmodel.UserViewModel

@Composable
fun NavManager(
    loginViewModel: LoginViewModel,
    userViewModel: UserViewModel
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login" ){
        composable("Login"){
            loginView(loginViewModel)


        }
    }
}