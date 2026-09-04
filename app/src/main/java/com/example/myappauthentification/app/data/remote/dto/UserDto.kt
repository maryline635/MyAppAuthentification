package com.example.myappauthentification.app.data.remote.dto

import kotlinx.serialization.Serializable
import org.intellij.lang.annotations.Language

@Serializable
data class UserDto(
    val id: String,
    val role: String,
    val email: String,
    val phone: String,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String,
    val description: String,
    val preferredLanguage: String,
    val isVerified: Boolean,
    val is2faEnabled: Boolean,
    val status: String,
)