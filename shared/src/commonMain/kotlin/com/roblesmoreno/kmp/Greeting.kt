package com.roblesmoreno.kmp

import com.roblesmoreno.kmp.services.FlightComponent
import dayPhrases
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val platform: Platform = getPlatform()
    private val flightComponent = FlightComponent()

    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "HI!" else "Hello!")
        delay(1.seconds)
        emit("Guess what it is! > ${platform.name.reversed()}!")
        emit(dayPhrases())
        delay(1.seconds)
        println("Greet: ${flightComponent.flightPhrase()}")
        emit(flightComponent.flightPhrase())
        emit(flightComponent.getFLightNumber())
    }

    fun flightResponse():Flow<String> = flow{
        emit(flightComponent.flightPhrase())
    }

    fun greetingList(): List<String> = buildList {
        add(if (Random.nextBoolean()) "HI!" else "Hello!")
        add("Guess what this is ! > ${platform.name.reversed()}")
        add(dayPhrases())
    }
}