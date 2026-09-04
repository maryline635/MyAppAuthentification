package com.example.myappauthentification.app.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ktorClient{

    val client = HttpClient(Android){

        //permet dee transformer les objects kotlin en JSON
        install(ContentNegotiation){
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }
        // temps maximum pour les requetes
        install(HttpTimeout){
            requestTimeoutMillis = 3000
            connectTimeoutMillis = 3000
            socketTimeoutMillis = 3000
        }

        //affiche les informations des requetes dans le LOGCAT
        install(Logging){
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }

        // Adresse de base de ton API
        defaultRequest {
            url("http://192.168.100.2:9091/")
        }
    }
}