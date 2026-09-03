package com.example.myappauthentification.app.domain.usecase

import com.example.myappauthentification.app.domain.model.User
import com.example.myappauthentification.app.domain.repository.AuthRepository


// Pour la page CONNEXION (TELEPHONE + MOT DE PASSE)
class LoginUseCase (
    private val repository: AuthRepository
){

    suspend operator fun invoke(
        phone: String,
        password: String
    ): Result<User>{

       return repository.login(
           phone = phone,
           password = password
       )
    }
}