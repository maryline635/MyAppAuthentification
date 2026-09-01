package com.example.myappauthentification.app.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LineWeight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    onSettingClick:()-> Unit
) {


    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val coroutineScope = rememberCoroutineScope()
    var moreMenu by remember { mutableStateOf(false) }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    // Partie du haut
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Magenta)
                    )
                    //Partie du bas
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.White)
                    )
                }

            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Home")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            },

                            ) {
                            Icon(
                                imageVector = Icons.Default.LineWeight,
                                contentDescription = "Menus"
                            )
                        }
                    },
                    actions = {

                        IconButton(onClick = onSettingClick
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Person"
                            )
                        }
                        Box {

                            IconButton(
                                onClick = {
                                    moreMenu = true
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Menus plus"
                                )
                            }

                            DropdownMenu(
                                expanded = moreMenu,
                                onDismissRequest = {
                                    moreMenu = false
                                }
                            ) {

                                DropdownMenuItem(
                                    text = {
                                        Text("nina dubois")
                                    },
                                    onClick = {
                                        moreMenu = false
                                    }
                                )

                                DropdownMenuItem(
                                    text = {
                                        Text("Paramètres")
                                    },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Settings,
                                            contentDescription = "Paramètres"
                                        )
                                    },
                                    onClick = {
                                        moreMenu = false
                                        onSettingClick()
                                    }
                                )
                                DropdownMenuItem(
                                    text = {
                                        Text("Déconnexion")
                                    },
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.Logout,
                                            contentDescription = "Déconnexion"
                                        )
                                    },
                                    onClick = {
                                        moreMenu = false
                                        onSettingClick()
                                    }
                                )
                            }
                        }

                    }
                )
            },



    ){ paddingValues ->

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color.Yellow)
            ) {
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {

    Dashboard(
        onSettingClick = {}
    )
}