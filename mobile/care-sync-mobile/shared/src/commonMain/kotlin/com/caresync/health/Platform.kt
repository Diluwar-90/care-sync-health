package com.caresync.health

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform