package com.example.myappauthentification.app.presentation.profil

sealed interface ProfilIntent {

    // L'utilisateur modifie son nom
    data class NomChanged(
        val nom: String
    ) : ProfilIntent

    // L'utilisateur modifie son prénom
    data class PrenomChanged(
        val prenom: String
    ) : ProfilIntent

    // L'utilisateur sélectionne une langue
    data class LangueChanged(
        val langue: String
    ) : ProfilIntent

    // L'utilisateur modifie son mot de passe
    data class MotDePasseChanged(
        val motDePasse: String
    ) : ProfilIntent

    // L'utilisateur appuie sur Enregistrer
    data object FinishClicked : ProfilIntent

    // L'utilisateur appuie sur Retour
    data object BackClicked : ProfilIntent
}