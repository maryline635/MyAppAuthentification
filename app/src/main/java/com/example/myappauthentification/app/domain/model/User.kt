package com.example.myappauthentification.app.domain.model

data class User(
    val id: Int,
    val phone: String,
    val nom: String,
    val prenom: String,
    val langue: String,

)