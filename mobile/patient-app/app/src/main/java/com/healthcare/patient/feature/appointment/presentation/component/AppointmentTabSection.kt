package com.healthcare.patient.feature.appointment.presentation.component



import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.healthcare.patient.feature.appointment.presentation.model.AppointmentStatus

@Composable
fun AppointmentTabSection(
    selectedTab: AppointmentStatus,
    onTabSelected: (AppointmentStatus) -> Unit
) {

    val tabs = AppointmentStatus.entries

    TabRow(
        selectedTabIndex = tabs.indexOf(selectedTab)
    ) {

        tabs.forEach { status ->

            Tab(
                selected = status == selectedTab,
                onClick = {
                    onTabSelected(status)
                },
                text = {
                    Text(status.name)
                }
            )

        }

    }

}