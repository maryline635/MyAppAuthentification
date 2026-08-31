package com.example.myappauthentification.app.ecran2


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun VerificationPage(
    onBack: () -> Unit ,
    onNext: () -> Unit
) {

    var code by remember {
        mutableStateOf("")
    }

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
            text = "Vérification",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Entrez le code reçu par SMS."
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // CODE
        OutlinedTextField(
            value = code,
            onValueChange = {
                if (it.length <= 6) {
                    code = it
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = {
                Text("000000")
            }
        )

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
                    text = "Retour"
                )
            }

            Button(
                onClick = onNext,
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFEF3155))
            ) {

                Text(
                    text = "Vérifier"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerificationPagePreview() {
    VerificationPage(
        onBack = {},
        onNext = {}
    )
}