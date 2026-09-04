package com.example.myappauthentification.app.data.dikoin

import com.example.myappauthentification.app.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module{

    factory{
        LoginUseCase(get())
    }
}