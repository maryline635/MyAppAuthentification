package com.example.myappauthentification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myappauthentification.app.ecran2.Navigation
import com.example.myappauthentification.ui.theme.MyAppAuthentificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppAuthentificationTheme {

                Navigation()
            }
        }
    }
}