package com.roblesmoreno.kmp

import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun greetingList(): List<String> = buildList {
        add(if (Random.nextBoolean()) "HI!" else "Hello!")
        add("Guess what this is ! > ${platform.name.reversed()}")
    }
}