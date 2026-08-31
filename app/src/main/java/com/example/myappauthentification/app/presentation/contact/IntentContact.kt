package com.example.myappauthentification.app.presentation.contact

sealed class ContactIntent {

    //Quand l'utilisateur écrit dans le champ

    data class TelephoneChanged(
        val telephone: String
    ) : ContactIntent()

    //Quand il coche/décoche la confidentialité
    data object ConfidentialiteChanged : ContactIntent()


    data object ContinuerClicked : ContactIntent()
}

sealed class ContactEvent {

    data object NavigateToVerification : ContactEvent()
}