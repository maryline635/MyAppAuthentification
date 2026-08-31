package com.example.myappauthentification.app.ecran2


import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


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
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(15.dp))
            .border(
                width = 2.dp,
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color.White,
                shape = RoundedCornerShape(15.dp))
            .padding(26.dp)
    ) {

        Text(
            text = "Vérification",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Entrez le code reçu par SMS.",
            fontSize = 20.sp
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
            },
            shape = RoundedCornerShape(12.dp)
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
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFEF3155))
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