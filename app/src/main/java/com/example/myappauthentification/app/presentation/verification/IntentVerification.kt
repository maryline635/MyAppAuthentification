package com.example.myappauthentification.app.presentation.verification

sealed interface VerificationIntent {

    //l'utilisateur modifie le code
    data class CodeChanged(
        val code: String
    ) : VerificationIntent

    // l'utilisateur appuie sur Vérifier
    data object VerifyClicked : VerificationIntent

    //l'utilisateur appuie sur Retour
    data object BackClicked : VerificationIntent
}