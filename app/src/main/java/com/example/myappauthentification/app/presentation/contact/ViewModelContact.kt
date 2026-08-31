package com.example.myappauthentification.app.presentation.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        ContactState()
    )

    val state: StateFlow<ContactState> =
        _state.asStateFlow()

    private val _event = Channel<ContactEvent>()

    val event = _event.receiveAsFlow()


    fun onIntent(intent: ContactIntent) {

        when (intent) {

            is ContactIntent.TelephoneChanged -> {

                _state.update {
                    it.copy(
                        telephone = intent.telephone
                    )
                }
            }

            ContactIntent.ConfidentialiteChanged -> {

                _state.update {
                    it.copy(
                        accepteConfidentialite =
                            !it.accepteConfidentialite
                    )
                }
            }

            ContactIntent.ContinuerClicked -> {

                if (
                    _state.value.telephone.isNotBlank() &&
                    _state.value.accepteConfidentialite
                ) {

                    viewModelScope.launch {
                        _event.send(
                            ContactEvent.NavigateToVerification
                        )
                    }
                }
            }
        }
    }
}