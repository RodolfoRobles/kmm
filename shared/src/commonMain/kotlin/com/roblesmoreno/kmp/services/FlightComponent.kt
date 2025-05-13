package com.roblesmoreno.kmp.services

import com.roblesmoreno.kmp.model.FlightDetails
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FlightComponent {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

    }

    private suspend fun getFlightDetails(): String {
        val response =
            httpClient.get("https://gist.githubusercontent.com/RodolfoRobles/83bd3b0a4afb5a27da4eed754787fd21/raw/cd449d32dd2d86350b1bde9ff17da4dfd9976343/flight_response.json")
                .body<FlightDetails>()
        return response.data.flightNumber
    }

    suspend fun flightPhrase(): String =
        try {
            "Is flight number ${getFlightDetails()}"
        } catch (apiException: Exception) {
            println("Exception caught $apiException")
        }.toString()
}