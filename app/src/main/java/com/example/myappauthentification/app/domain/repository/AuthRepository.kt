package com.example.myappauthentification.app.domain.repository

import com.example.myappauthentification.app.domain.model.User

interface AuthRepository{

    suspend fun login(
        phone: String,
        password: String
    ): Result<User>

    suspend fun sendVerificationCode(
        phone: String
    ): Result<Unit>

    suspend fun verifyCode(
        phone: String,
        code: String
    ): Result<Unit>

    suspend fun register(
        phone: String,
        nom: String,
        prenom: String,
        langue: String,
        password: String
    ): Result<User>
}