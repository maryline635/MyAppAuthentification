package com.example.myappauthentification.app.presentation.connexion

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ConnexionViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        ConnexionState()
    )

    val state: StateFlow<ConnexionState> =
        _state.asStateFlow()


    fun onIntent(intent: ConnexionIntent) {

        when (intent) {

            is ConnexionIntent.UsernameChanged -> {

                _state.update {
                    it.copy(
                        username = intent.username
                    )
                }
            }


            is ConnexionIntent.PasswordChanged -> {

                _state.update {
                    it.copy(
                        password = intent.password
                    )
                }
            }


            ConnexionIntent.LoginClicked -> {

                // Ici tu mettras la logique de connexion

            }


            ConnexionIntent.ForgotPasswordClicked -> {

                // Navigation vers mot de passe oublié

            }


            ConnexionIntent.SignUpClicked -> {

                // Navigation vers inscription

            }
        }
    }
}