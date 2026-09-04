package com.example.myappauthentification.app.data.remote


import com.example.myappauthentification.app.data.remote.dto.LoginRequest
import com.example.myappauthentification.app.data.remote.dto.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

// c'est ici que l'on va faire la requete POST
class AuthApi (
    private val client: HttpClient
){

    suspend fun login(
        identifier: String,
        password: String
    ): LoginResponse {

        return client.post("/api/v1/auth/login"){

            contentType(ContentType.Application.Json)

            setBody(
                LoginRequest(
                    identifier = identifier,
                    password = password
                )
            )
        }.body()
    }
}