package com.healthcare.health

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform