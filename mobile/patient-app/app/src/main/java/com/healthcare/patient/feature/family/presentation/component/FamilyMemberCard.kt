package com.healthcare.patient.feature.family.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.feature.family.presentation.model.FamilyMember
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun FamilyMemberCard(

    member: FamilyMember,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick()

            }

    ) {

        Column(

            modifier = Modifier.padding(
                AppDimens.ContentPadding
            ),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space8
            )

        ) {

            Text(

                text = member.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Relation : ${member.relation}"
            )

            Text(
                text = "Age : ${member.age}"
            )

            Text(
                text = "Blood Group : ${member.bloodGroup}"
            )

        }

    }

}