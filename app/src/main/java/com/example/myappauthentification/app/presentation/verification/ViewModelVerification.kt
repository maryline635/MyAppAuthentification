package com.example.myappauthentification.app.presentation.verification

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VerificationViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        VerificationState()
    )

    val state: StateFlow<VerificationState> =
        _state.asStateFlow()

    fun onIntent(intent: VerificationIntent) {

        when (intent) {

            is VerificationIntent.CodeChanged -> {

                if (intent.code.length <= 6 &&
                    intent.code.all { it.isDigit() }
                ) {

                    _state.update {
                        it.copy(
                            code = intent.code,
                            errorMessage = null
                        )
                    }
                }
            }

            VerificationIntent.VerifyClicked -> {

                verifyCode()
            }

            VerificationIntent.BackClicked -> {
                // Rien ici pour l'instant.
                // La navigation sera gérée par l'écran.
            }
        }
    }

    private fun verifyCode() {

        val code = _state.value.code

        if (code.length != 6) {

            _state.update {
                it.copy(
                    errorMessage = "Veuillez entrer un code à 6 chiffres."
                )
            }

            return
        }

        // Pour l'instant, on considère le code comme valide.
        _state.update {
            it.copy(
                isVerified = true,
                errorMessage = null
            )
        }
    }
}