package com.roblesmoreno.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform