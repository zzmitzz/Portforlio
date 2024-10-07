package com.example.portforlio.presentation.screen.welcome

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.portforlio.presentation.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController){
    val welcomeViewModel: WelcomeViewModel = viewModel()
    var userInformation by remember { mutableStateOf(UserInformation()) }
    LaunchedEffect(key1 = Unit) {
        welcomeViewModel.userInformationFlow.collect{
            userInformation = it
        }
    }
    Button(modifier = Modifier.size(
        width = 200.dp,
        height = 50.dp
    ), onClick = {
        welcomeViewModel.fakeFetchData("123")
//        navController.navigate(Screen.LoginScreen.route)
    }) {
        Text(text=userInformation.name)
    }
}