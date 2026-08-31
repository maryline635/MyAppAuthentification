package com.example.myappauthentification.app.presentation.contact

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.myappauthentification.app.ecran2.ContactPage

@Composable
fun ContactScreen(
    viewModel: ContactViewModel,
    onNext: () -> Unit
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.event.collect { event ->

            when (event) {

                ContactEvent.NavigateToVerification -> {
                    onNext()
                }
            }
        }
    }

    ContactPage(
        state = state,
        onIntent = viewModel::onIntent
    )
}