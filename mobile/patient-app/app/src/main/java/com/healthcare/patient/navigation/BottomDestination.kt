package com.healthcare.patient.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.SmartToy
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomDestination(

    val route: String,

    val title: String,

    val icon: ImageVector

) {

    data object Home : BottomDestination(

        route = "tab_home",

        title = "Home",

        icon = Icons.Outlined.Home

    )

    data object Appointment : BottomDestination(

        route = "tab_appointment",

        title = "Appointments",

        icon = Icons.Outlined.CalendarMonth

    )

    data object Ai : BottomDestination(

        route = "tab_ai",

        title = "AI",

        icon = Icons.Outlined.SmartToy

    )

    data object Profile : BottomDestination(

        route = "tab_profile",

        title = "Profile",

        icon = Icons.Outlined.Person

    )

    companion object {

        val items = listOf(

            Home,

            Appointment,

            Ai,

            Profile

        )

    }

}