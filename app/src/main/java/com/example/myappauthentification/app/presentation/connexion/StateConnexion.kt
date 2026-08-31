package com.example.myappauthentification.app.presentation.connexion

data class ConnexionState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)