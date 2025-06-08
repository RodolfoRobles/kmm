package com.roblesmoreno.kmp.android

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun App(mainViewModel: FlightViewModel = FlightViewModel()) {
    MaterialTheme {
        val greetings by mainViewModel.greetingList.collectAsStateWithLifecycle()
        Log.i("TAG", "DefaultPreview: ${greetings.size}")

        Column(
            modifier = Modifier.padding(all = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            greetings.forEach { greeting ->
                Text(greeting)
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}