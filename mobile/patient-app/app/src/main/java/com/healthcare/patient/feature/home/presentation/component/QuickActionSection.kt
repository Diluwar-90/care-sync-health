package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.healthcare.patient.feature.home.presentation.model.QuickAction
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun QuickActionSection(

    actions: List<QuickAction>,

    onClick: (QuickAction) -> Unit

) {

    Column(

        modifier = Modifier.fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(
            AppDimens.Space16
        )

    ) {

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            actions.take(2).forEach { action ->

                androidx.compose.foundation.layout.Box(
                    modifier = Modifier.weight(1f)
                ) {

                    QuickActionCard(

                        title = action.title,

                        icon = action.icon,

                        onClick = {

                            onClick(action)

                        }

                    )

                }

            }

        }

        Row(

            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            actions.drop(2).take(2).forEach { action ->

                androidx.compose.foundation.layout.Box(
                    modifier = Modifier.weight(1f)
                ) {

                    QuickActionCard(

                        title = action.title,

                        icon = action.icon,

                        onClick = {

                            onClick(action)

                        }

                    )

                }

            }

        }

    }

}