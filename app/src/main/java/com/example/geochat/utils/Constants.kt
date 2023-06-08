package com.example.geochat.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import com.example.geochat.models.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Buscar",
            icon = Icons.Filled.Search,
            route = "chat"
        ),
        BottomNavItem(
            label = "Map",
            icon = Icons.Filled.LocationOn,
            route = "map"
        ),
        BottomNavItem(
            label = "Settings",
            icon = Icons.Filled.Settings,
            route = "settings"
        )
    )
}