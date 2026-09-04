package com.example.myappauthentification.app.data.dikoin

import androidx.appcompat.widget.AppCompatDrawableManager.get
import com.example.myappauthentification.app.data.remote.AuthApi
import com.example.myappauthentification.app.data.repository.AuthRepositoryImpl
import com.example.myappauthentification.app.domain.repository.AuthRepository
import org.koin.dsl.module


val dataModule = module{

    single{
        AuthApi(get())
    }

    single <AuthRepository> {
        AuthRepositoryImpl(get())
    }
}