package com.example.myappauthentification.app.data.dikoin

import com.example.myappauthentification.app.data.network.ktorClient
import org.koin.dsl.module

val networkModule = module{

    single{
        ktorClient.client
    }
}