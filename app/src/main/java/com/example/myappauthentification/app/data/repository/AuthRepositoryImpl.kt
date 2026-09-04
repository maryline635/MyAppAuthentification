package com.example.myappauthentification.app.data.repository

import com.example.myappauthentification.app.data.mapper.toDomain
import com.example.myappauthentification.app.data.remote.AuthApi
import com.example.myappauthentification.app.domain.model.User
import com.example.myappauthentification.app.domain.repository.AuthRepository


class AuthRepositoryImpl (
    private val authApi: AuthApi
): AuthRepository{

    override suspend fun login(
       phone: String,
       password: String
    ): Result<User>{

        return try {

            val response = authApi.login(
                identifier = phone,
                password = password
            )

            val user = response.data.User.toDomain()


            Result.success(user)

        } catch (e: Exception){

            Result.failure(e)
        }
    }
    override suspend fun sendVerificationCode(
        phone: String
    ): Result<Unit> {
        TODO("À implémenter")
    }

    override suspend fun verifyCode(
        phone: String,
        code: String
    ): Result<Unit> {
        TODO("À implémenter")
    }

    override suspend fun register(
        phone: String,
        nom: String,
        prenom: String,
        langue: String,
        password: String
    ): Result<User> {
        TODO("À implémenter")
    }
    }
