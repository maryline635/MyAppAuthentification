package com.example.myappauthentification.app.presentation.verification

data class VerificationState(
    val code: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isVerified: Boolean = false
)