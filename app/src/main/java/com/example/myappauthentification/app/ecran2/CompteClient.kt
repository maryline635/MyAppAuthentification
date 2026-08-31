package com.example.myappauthentification

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myappauthentification.app.ecran2.ContactPage
import com.example.myappauthentification.app.ecran2.ProfilPage
import com.example.myappauthentification.app.ecran2.VerificationPage
import com.example.myappauthentification.app.presentation.contact.ContactScreen
import com.example.myappauthentification.app.presentation.contact.ContactViewModel

@Preview
@Composable
fun CompteClient() {

    var currentPage by remember {
        mutableIntStateOf(1)
    }

    val contactViewModel: ContactViewModel = viewModel()

Box( modifier = Modifier
    .background(
        color = Color.White
        //shape = RoundedCornerShape(18.dp)
    )) {

    // Fond rose
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(445.dp)
            .background(
                color = Color(0xFFEF3155),
                shape = RoundedCornerShape(
                    bottomStart = 38.dp,
                    bottomEnd = 38.dp
                )
            )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(34.dp)
    ) {

        Spacer(
            modifier = Modifier.height(22.dp)
        )

        // TITRE
        Text(
            text = "Compte client",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(74.dp)
        )


        // LES 3 INDICATEUR
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ÉTAPE 1
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        color = if (currentPage >= 1)
                            Color.Black
                        else
                            Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1",
                    color = if (currentPage >= 1)
                        Color.White
                    else
                        Color.Black
                )
            }

            // LIGNE 1
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(
                        if (currentPage >= 2)
                            Color.Black
                        else
                            Color.LightGray
                    )
            )

            // ÉTAPE 2
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        color = if (currentPage >= 2)
                            Color.Black
                        else
                            Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "2",
                    color = if (currentPage >= 2)
                        Color.White
                    else
                        Color.Black
                )
            }

            // LIGNE 2
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(
                        if (currentPage >= 3)
                            Color.Black
                        else
                            Color.LightGray
                    )
            )

            // ÉTAPE 3
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        color = if (currentPage >= 3)
                            Color.Black
                        else
                            Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3",
                    color = if (currentPage >= 3)
                        Color.White
                    else
                        Color.Black
                )
            }
        }

        Spacer(
            modifier = Modifier.height(79.dp)
        )


        // CONTENU DE L'ÉTAPE
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {

            when (currentPage) {


                // PAGE 1
                1 -> {

                    ContactScreen(
                        viewModel = contactViewModel,
                        onNext = {
                            currentPage = 2
                        }
                    )
                }


                // PAGE 2
                2 -> {

                    VerificationPage(
                        onBack = {
                            currentPage = 1
                        },
                        onNext = {
                            currentPage = 3
                        }
                    )
                }


                // PAGE 3
                3 -> {

                    ProfilPage(
                        onBack = {
                            currentPage = 2
                        },
                        onFinish = {
                            // Enregistrement final
                        }
                    )
                }
            }
        }
    }
}
}