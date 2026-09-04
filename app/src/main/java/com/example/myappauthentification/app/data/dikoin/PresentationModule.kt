package com.example.myappauthentification.app.data.dikoin

import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myappauthentification.app.presentation.connexion.ConnexionViewModel
import org.koin.dsl.module

val presentationModule = module{

    viewModel {
        ConnexionViewModel(
            loginUseCase = get()
        )
    }
}