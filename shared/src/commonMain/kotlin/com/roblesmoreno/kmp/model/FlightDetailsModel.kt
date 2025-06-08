package com.roblesmoreno.kmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlightDetails(
    @SerialName("status") val status: String,
    @SerialName("data") val data: FlightData
)

@Serializable
data class FlightData(
    @SerialName("flightNumber") val flightNumber: String,
    @SerialName("airline") val airline: String,
    @SerialName("departure") val departure: FlightLocationDetails,
    @SerialName("arrival") val arrival: FlightLocationDetails,
    @SerialName("duration") val duration: String,
    @SerialName("stops") val stops: Int,
    @SerialName("class") val flightClass: String,
    @SerialName("price") val price: PriceDetails,
    @SerialName("aircraft") val aircraft: String,
    @SerialName("baggageAllowance") val baggageAllowance: BaggageAllowanceDetails,
    @SerialName("isRefundable") val isRefundable: Boolean,
    @SerialName("fareBasisCode") val fareBasisCode: String
)

@Serializable
data class FlightLocationDetails(
    @SerialName("airport") val airport: String,
    @SerialName("airportName") val airportName: String,
    @SerialName("city") val city: String,
    @SerialName("state") val state: String,
    @SerialName("country") val country: String,
    @SerialName("time") val time: String,
    @SerialName("terminal") val terminal: String? = null,
    @SerialName("gate") val gate: String? = null
)

@Serializable
data class PriceDetails(
    @SerialName("amount") val amount: Double,
    @SerialName("currency") val currency: String
)

@Serializable
data class BaggageAllowanceDetails(
    @SerialName("checkedBags") val checkedBags: Int,
    @SerialName("carryOnBags") val carryOnBags: Int,
    @SerialName("checkedBagDetails") val checkedBagDetails: String? = null
)