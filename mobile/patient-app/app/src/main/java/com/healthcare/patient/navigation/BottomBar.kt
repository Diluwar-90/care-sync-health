package com.healthcare.patient.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(

    navController: NavHostController

) {

    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value?.destination?.route

    NavigationBar {

        BottomDestination.items.forEach { destination ->

            NavigationBarItem(

                selected = currentRoute == destination.route,

                onClick = {

                    navController.navigate(destination.route) {

                        popUpTo(
                            navController.graph.findStartDestination().id
                        ) {

                            saveState = true

                        }

                        launchSingleTop = true

                        restoreState = true

                    }

                },

                icon = {

                    Icon(

                        imageVector = destination.icon,

                        contentDescription = destination.title

                    )

                },

                label = {

                    Text(
                        text = destination.title
                    )

                }

            )

        }

    }

}