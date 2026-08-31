package com.example.myappauthentification.app.ecran2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappauthentification.app.presentation.contact.ContactIntent
import com.example.myappauthentification.app.presentation.contact.ContactState


@Composable
fun ContactPage(
    state: ContactState,
    onIntent: (ContactIntent) -> Unit
) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .shadow(
                elevation = 2.dp, shape = RoundedCornerShape(15.dp))
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            .padding(24.dp)
    ) {

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {

        Text(
            text = "Créer un compte",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // TELEPHONE
        Text(
            text = "Téléphone"
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(
            value = state.telephone,
            onValueChange = {
                onIntent(
                    ContactIntent.TelephoneChanged(it)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // BOUTON CONFIDENTIALITER
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state.accepteConfidentialite,
                onCheckedChange = {
                    onIntent(
                        ContactIntent.ConfidentialiteChanged
                    )
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFEF3155),
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White
                )
            )

            Text(
                text = "J'accepte les conditions de confidentialité",
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // BOUTON
        Button(
            onClick = {onIntent(
                ContactIntent.ContinuerClicked
            )
                      },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFEF3155))
        ) {

            Text(
                text = "Continuer"
            )
        }
    }
}
}