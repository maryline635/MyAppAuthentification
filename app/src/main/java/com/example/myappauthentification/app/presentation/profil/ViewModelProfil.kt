package com.example.myappauthentification.app.presentation.profil

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfilViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        ProfilState()
    )

    val state: StateFlow<ProfilState> =
        _state.asStateFlow()

    fun onIntent(intent: ProfilIntent) {

        when (intent) {

            is ProfilIntent.NomChanged -> {

                _state.update {
                    it.copy(
                        nom = intent.nom,
                        errorMessage = null
                    )
                }
            }

            is ProfilIntent.PrenomChanged -> {

                _state.update {
                    it.copy(
                        prenom = intent.prenom,
                        errorMessage = null
                    )
                }
            }

            is ProfilIntent.LangueChanged -> {

                _state.update {
                    it.copy(
                        langue = intent.langue,
                        errorMessage = null
                    )
                }
            }

            is ProfilIntent.MotDePasseChanged -> {

                _state.update {
                    it.copy(
                        motDePasse = intent.motDePasse,
                        errorMessage = null
                    )
                }
            }

            ProfilIntent.FinishClicked -> {

                saveProfil()
            }

            ProfilIntent.BackClicked -> {
                // La navigation sera gérée par l'écran.
            }
        }
    }

    private fun saveProfil() {

        val state = _state.value

        // Validation
        if (state.nom.isBlank()) {

            _state.update {
                it.copy(
                    errorMessage = "Veuillez entrer votre nom."
                )
            }

            return
        }

        if (state.prenom.isBlank()) {

            _state.update {
                it.copy(
                    errorMessage = "Veuillez entrer votre prénom."
                )
            }

            return
        }

        if (state.motDePasse.isBlank()) {

            _state.update {
                it.copy(
                    errorMessage = "Veuillez entrer votre mot de passe."
                )
            }

            return
        }

        // Pour l'instant, on considère l'enregistrement réussi.
        _state.update {
            it.copy(
                isSaved = true,
                errorMessage = null
            )
        }
    }
}