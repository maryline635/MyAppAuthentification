package com.example.myappauthentification.app.ecran2

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfilPage(
    onBack: () -> Unit,
    onFinish: () -> Unit
) {

    var nom by remember { mutableStateOf("") }

    var prenom by remember { mutableStateOf("") }

    var langue by remember { mutableStateOf("FR") }

    var motDePasse by remember { mutableStateOf("FR") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(24.dp)
    ) {

        Text(
            text = "Profil",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // NOM
        Text(
            text = "Nom"
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(
            value = nom,
            onValueChange = {
                nom = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // PRENOM
        Text(
            text = "Prénom"
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(
            value = prenom,
            onValueChange = {
                prenom = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // LANGUE
        Text(
            text = "Langue"
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = langue == "FR",
                onClick = {
                    langue = "FR"
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFFEF3155),
                    unselectedColor = Color.Gray
            )
            )

            Text("FR")

            Spacer(
                modifier = Modifier.width(20.dp)
            )

            RadioButton(
                selected = langue == "EN",
                onClick = {
                    langue = "EN"
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFFEF3155),
                    unselectedColor = Color.Gray
            )
            )

            Text("EN")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        // MOT DE PASSE
        Text( text = "Mot de passe" )

        Spacer( modifier = Modifier.height(8.dp) )

        OutlinedTextField(
            value = motDePasse,
            onValueChange = { motDePasse = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true, )

        Spacer( modifier = Modifier.height(24.dp) )


        // BOUTONS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OutlinedButton(
                onClick = onBack
            ) {

                Text(
                    text = "Retour"
                )
            }

            Button(
                onClick = onFinish,
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFEF3155))
            ) {

                Text(
                    text = "Enregistrer"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilPagePreview() {
    ProfilPage(
        onBack = {},
        onFinish = {}
    )
}