package com.example.myappauthentification.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginDataDto(
    val accessToken: String,
    val refreshToken: String,
    val User: UserDto
)