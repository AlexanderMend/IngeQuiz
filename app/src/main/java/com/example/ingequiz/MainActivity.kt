package com.example.ingequiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ingequiz.navigation.NavManager
import com.example.ingequiz.ui.theme.IngeQuizTheme
import com.example.ingequiz.ui.views.loginView
import com.example.ingequiz.viewmodel.LoginViewModel
import com.example.ingequiz.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel: LoginViewModel by viewModels()
        val userViewModel: UserViewModel by viewModels()
        setContent {
            loginView(loginViewModel)
        }
    }
}

