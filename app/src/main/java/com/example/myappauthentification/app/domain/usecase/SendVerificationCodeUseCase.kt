package com.example.myappauthentification.app.domain.usecase

import com.example.myappauthentification.app.domain.repository.AuthRepository


//il correspond au bouton continuer de la page CONTACT

class SendVerificationCodeUseCase (
    private val repository: AuthRepository
){

    suspend operator fun invoke(
        phone: String
    ): Result<Unit>{

        return repository.sendVerificationCode(
            phone = phone
        )
    }
}