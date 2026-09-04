package com.example.myappauthentification.app.data.mapper

import com.example.myappauthentification.app.data.remote.dto.UserDto
import com.example.myappauthentification.app.domain.model.User

fun UserDto.toDomain(): User {
    return User(
        id = id,
        role = role,
        email = email,
        phone = phone,
        firstName = firstName,
        lastName = lastName,
        avatarUrl = avatarUrl,
        description = description,
        preferredLanguage = preferredLanguage,
        isVerified = isVerified,
        is2faEnabled = is2faEnabled,
        status = status
    )
}