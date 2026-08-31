package com.example.myappauthentification

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappauthentification.app.presentation.connexion.ConnexionIntent
import com.example.myappauthentification.app.presentation.connexion.ConnexionViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun Connexion(
    viewModel: ConnexionViewModel,
    onSignUp: () -> Unit
) {

    val state by viewModel.state.collectAsState()

        // TELEPHONE LOGIN
        Box(
            modifier = Modifier
                .width(125.dp)
                .height(265.dp)
                .background(
                    color = Color.White
                    //shape = RoundedCornerShape(18.dp)
                )
        ) {

            // Fond rose
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp)
                    .background(
                        color = Color(0xFFEF3155),
                        shape = RoundedCornerShape(
                            bottomStart = 28.dp,
                            bottomEnd = 28.dp
                        )
                    )
            )
            

            // Carte blanche
            Box(
                modifier = Modifier
                    .width(103.dp)
                    .height(200.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 39.dp)
                    .shadow(elevation = 2.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 8.dp,
                            vertical = 5.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // GRAND LOGIN
                    Text(
                        text = "Login",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(top = 2.dp, bottom = 19.dp)
                    )

                    // TELEPHONE
                    Text(
                        text = "Phone Number",
                        fontSize = 6.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    OutlinedTextField(
                        value = state.username,
                        onValueChange = {
                            viewModel.onIntent(
                                ConnexionIntent.UsernameChanged(it)
                            )
                        },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(19.dp),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    // Password
                    Text(
                        text = "Password",
                        fontSize = 6.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    OutlinedTextField(
                        value = state.password,
                        onValueChange = {
                            viewModel.onIntent(
                                ConnexionIntent.PasswordChanged(it)
                            )
                        },
                        visualTransformation =
                            PasswordVisualTransformation(),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(19.dp),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Forgot Password?",
                        fontSize = 4.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.End)
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .width(49.dp)
                            .height(18.dp),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEF3155)
                        )
                    ) {

                        Text(
                            text = "Login",
                            fontSize = 8.sp
                        )
                    }
                }
            }

            // Texte du bas
            Text(
                text = buildAnnotatedString {
                    append("Don't have an account? ")

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFEF3155)
                        )
                    ) {
                        append("Sign Up")
                    }
                },
                fontSize = 6.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 14.dp)
                    .clickable {
                        onSignUp()
                    }
            )
        }
}