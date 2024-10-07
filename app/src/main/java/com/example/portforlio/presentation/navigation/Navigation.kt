package com.example.portforlio.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portforlio.presentation.screen.login.LoginScreen
import com.example.portforlio.presentation.screen.welcome.WelcomeScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route){

        composable(Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
    }

}