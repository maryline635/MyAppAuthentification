package com.example.myappauthentification.app.presentation.profil

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myappauthentification.app.ecran2.ProfilPage

@Composable
fun ProfilScreen(
    onBack: () -> Unit,
    onFinish: () -> Unit,
    viewModel: ProfilViewModel = viewModel()
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.isSaved) {
        if (state.isSaved) {
            onFinish()
        }
    }

    ProfilPage(
        state = state,
        onIntent = viewModel::onIntent,
        onBack = onBack,
        onFinish = onFinish
    )
}