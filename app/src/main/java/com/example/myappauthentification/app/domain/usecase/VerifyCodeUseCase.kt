package com.example.myappauthentification.app.domain.usecase

import com.example.myappauthentification.app.domain.repository.AuthRepository


// pour la page VERIFICATION
class VerifyCodeUseCase (
    private val repository: AuthRepository
){

    suspend operator fun invoke(
        phone: String,
        code: String
    ): Result<Unit>{

        // le code a 6 chiffres sera transmise ici
        return repository.verifyCode(
            phone = phone,
            code = code
        )
    }
}