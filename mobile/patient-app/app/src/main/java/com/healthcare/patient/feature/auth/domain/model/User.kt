package com.healthcare.patient.feature.auth.domain.model

data class User(
    val id: String,
    val phone: String,
    val name: String,
    val token: String
)