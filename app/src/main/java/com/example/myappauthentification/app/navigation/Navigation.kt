package com.example.myappauthentification.app.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myappauthentification.CompteClient
import com.example.myappauthentification.Connexion
import com.example.myappauthentification.app.dashboard.Dashboard
import com.example.myappauthentification.app.presentation.connexion.ConnexionViewModel


sealed class Routes(val route: String) {

    data object Connexion : Routes("connexion")
    data object CompteClient : Routes("compte_client")
    data object Dashboard : Routes("dashboard")
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun Navigation() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Routes.Connexion.route
    ) {

        // CONNEXION
        composable(
            route = Routes.Connexion.route
        ) {

            Connexion(

                onSignUp = {
                    navController.navigate(
                        Routes.CompteClient.route
                    )
                },

                onLogin = {
                    navController.navigate(
                        Routes.Dashboard.route
                    )
                }
            )
        }

        // COMPTE CLIENT
        composable(
            route = Routes.CompteClient.route
        ) {

            CompteClient(
                onFinish = {
                    navController.navigate(
                        Routes.Dashboard.route
                    ) {
                        popUpTo(Routes.Connexion.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // DASHBOARD
        composable(
            route = Routes.Dashboard.route
        ) {

            Dashboard(
                onDeconnexionClick = {
                    navController.navigate("connexion") {
                        popUpTo("dashboard") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

