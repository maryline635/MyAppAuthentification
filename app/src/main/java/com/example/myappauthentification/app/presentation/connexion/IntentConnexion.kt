package com.example.myappauthentification.app.presentation.connexion

sealed class ConnexionIntent {

    //l'utilisateur écrit son numéro
    data class UsernameChanged(
        val username: String
    ) : ConnexionIntent()

    //Quand il écrit son mot de passe :
    data class PasswordChanged(
        val password: String
    ) : ConnexionIntent()


    data object LoginClicked : ConnexionIntent()

    data object ForgotPasswordClicked : ConnexionIntent()

    data object SignUpClicked : ConnexionIntent()
}