package com.roblesmoreno.kmp.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesmoreno.kmp.Greeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlightViewModel : ViewModel() {
    private val _greetingList = MutableStateFlow<List<String>>(listOf())
    val greetingList: StateFlow<List<String>> get() = _greetingList

    init {
        viewModelScope.launch {
            Greeting().flightResponse().collect { phrase ->
                _greetingList.update { list -> list + phrase }
            }
        }
    }
}