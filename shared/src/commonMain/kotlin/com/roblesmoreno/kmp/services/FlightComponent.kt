package com.roblesmoreno.kmp.services

import com.roblesmoreno.kmp.model.FlightDetails
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
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
    private val client = HttpClient()

    private suspend fun getFlightDetailsModel(): FlightDetails {
        val response: FlightDetails =
            httpClient.get("https://gist.githubusercontent.com/RodolfoRobles/83bd3b0a4afb5a27da4eed754787fd21/raw/cd449d32dd2d86350b1bde9ff17da4dfd9976343/flight_response.json")
                .body()
        return response
    }

    private suspend fun getFlightDetails(): String {
        val response =
            client.get("https://gist.githubusercontent.com/RodolfoRobles/83bd3b0a4afb5a27da4eed754787fd21/raw/cd449d32dd2d86350b1bde9ff17da4dfd9976343/flight_response.json")
        return response.bodyAsText()
    }

    suspend fun getFLightNumber(): String =
        try {
            "Flight number: ${getFlightDetailsModel().data.flightNumber}"
        } catch (apiException: Exception) {
            println("Exception caught $apiException")
        }.toString()


    suspend fun flightPhrase(): String =
        try {
            "Is flight number ${getFlightDetails()}"
        } catch (apiException: Exception) {
            println("Exception caught $apiException")
        }.toString()
}