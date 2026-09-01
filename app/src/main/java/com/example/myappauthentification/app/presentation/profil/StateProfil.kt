package com.example.myappauthentification.app.presentation.profil

data class ProfilState(
    val nom: String = "",
    val prenom: String = "",
    val langue: String = "FR",
    val motDePasse: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSaved: Boolean = false
)