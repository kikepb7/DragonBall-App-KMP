package com.kikepb7.dragonballapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform