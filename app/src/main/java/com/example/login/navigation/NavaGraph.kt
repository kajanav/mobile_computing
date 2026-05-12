package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.login.screen.*

@Composable
fun NavGraph(navController: NavHostController, userDao: UserDao) {

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                userDao = userDao,
                onLogin = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                userDao = userDao,
                onComplete = { navController.popBackStack() }
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}