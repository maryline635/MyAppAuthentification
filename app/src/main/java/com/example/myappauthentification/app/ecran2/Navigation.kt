package com.example.myappauthentification.app.ecran2

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myappauthentification.CompteClient
import com.example.myappauthentification.Connexion
import com.example.myappauthentification.app.presentation.connexion.ConnexionViewModel
import com.example.myappauthentification.app.presentation.contact.ContactScreen
import com.example.myappauthentification.app.presentation.contact.ContactViewModel

object Routes {
    const val CONNEXION = "connexion"
    const val COMPTE_CLIENT = "compte_client"
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.CONNEXION
    ) {

        // LOGIN
        composable(Routes.CONNEXION) {

            Connexion(
                viewModel = ConnexionViewModel(),

                onSignUp = {
                    navController.navigate(
                        Routes.COMPTE_CLIENT
                    )
                }
            )
        }


        // COMPTE CLIENT
        composable(Routes.COMPTE_CLIENT) {

            CompteClient()
        }
    }
}