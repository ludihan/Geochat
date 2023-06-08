package com.example.geochat.screens

import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen() {
    val cameraPositionState = rememberCameraPositionState {
        position =
            CameraPosition.fromLatLngZoom(LatLng(-3.7693680643443406, -38.480132266016994), 18f)
    }

    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    Box(Modifier.fillMaxSize()) {

        GoogleMap(
            uiSettings = uiSettings.copy(zoomControlsEnabled = false),
            modifier = Modifier.fillMaxSize(),
            properties = properties,
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(LatLng(-3.7693680643443406, -38.480132266016994)),
                title = "Brasil",
                snippet = "Brasil MARCADO"
            )
        }
        Column() {
            Spacer(Modifier.height(500.dp))
        }
    }
}

@Preview
@Composable
fun PreviewMapScren() {
    MapScreen()
}