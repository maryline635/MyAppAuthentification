package com.example.myappauthentification.app.ecran2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappauthentification.app.presentation.profil.ProfilIntent
import com.example.myappauthentification.app.presentation.profil.ProfilState


@Composable
fun ProfilPage(
    state: ProfilState,
    onIntent: (ProfilIntent) -> Unit,
    onBack: () -> Unit,
    onFinish: () -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(24.dp)
    ) {

        Text(
            text = "Profil",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // NOM
        Text(
            text = "Nom",
            fontSize = 15.sp
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(
            value = state.nom,
            onValueChange = { nom ->

                onIntent(
                    ProfilIntent.NomChanged(nom)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // PRENOM
        Text(
            text = "Prénom",
            fontSize = 15.sp
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        OutlinedTextField(
            value = state.prenom,
            onValueChange = { prenom ->

                onIntent(
                    ProfilIntent.PrenomChanged(prenom)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // LANGUE
        Text(
            text = "Langue",
            fontSize = 15.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = state.langue == "FR",
                onClick = {

                    onIntent(
                        ProfilIntent.LangueChanged("FR")
                    )
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
                selected = state.langue == "EN",
                onClick = {

                    onIntent(
                        ProfilIntent.LangueChanged("EN")
                    )
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
        Text(
            text = "Mot de passe",
            fontSize = 15.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        OutlinedTextField(
            value = state.motDePasse,
            onValueChange = { motDePasse ->

                onIntent(
                    ProfilIntent.MotDePasseChanged(motDePasse)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        // ERREUR
        if (state.errorMessage != null) {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = state.errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // BOUTONS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OutlinedButton(
                onClick = onBack
            ) {

                Text(
                    text = "Retour",
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = {

                    onIntent(
                        ProfilIntent.FinishClicked
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF3155)
                )
            ) {

                Text(
                    text = "Enregistrer",
                    fontSize = 15.sp
                )
            }
        }
    }
}

