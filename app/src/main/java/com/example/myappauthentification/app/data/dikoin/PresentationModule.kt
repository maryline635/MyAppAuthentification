package com.example.myappauthentification.app.data.dikoin

import com.example.myappauthentification.app.presentation.connexion.ConnexionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module{

    viewModel {
        ConnexionViewModel(
            loginUseCase = get()
        )
    }
}