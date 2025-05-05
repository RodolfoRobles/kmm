package com.roblesmoreno.multi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform