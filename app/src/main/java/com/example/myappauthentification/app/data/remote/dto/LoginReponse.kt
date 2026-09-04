package com.example.myappauthentification.app.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
        val success: Boolean,
        val data: LoginDataDto
        )