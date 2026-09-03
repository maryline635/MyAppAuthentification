package com.example.myappauthentification.app.domain.usecase

import com.example.myappauthentification.app.domain.model.User
import com.example.myappauthentification.app.domain.repository.AuthRepository


// Pour la page PROFIL
class RegisterUserCase (
    private val repository: AuthRepository
){

    suspend operator fun invoke(
        phone: String,
        nom: String,
        prenom: String,
        langue: String,
        password: String
    ): Result<User> {

        return repository.register(
            phone = phone,
            nom = nom,
            prenom = prenom,
            langue = langue,
            password = password
        )
    }
}