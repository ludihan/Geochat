package com.example.geochat.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.geochat.R

@Composable
fun MapScreen() {
    Image(
        modifier = Modifier.size(850.dp),
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.image3),
        contentDescription = null
    )
}