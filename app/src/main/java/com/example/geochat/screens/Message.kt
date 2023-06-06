package com.example.geochat.screens

import java.util.Calendar

data class Message(
    var text: String? = null,
    var recipient_id: String,
    var time: Long = Calendar.getInstance().timeInMillis,
    var isOut: Boolean = false
)

data class GeochatButton(
    val title: String,
    val payload: String
)

val message_dummy = listOf(
    Message(
        text = "Que bom!",
        recipient_id = "bot",
        isOut = false
    ),
    Message(
        text = "Estou bem.",
        recipient_id = "user",
        isOut = true
    ),
    Message(
        text = "Olá, como vai você?",
        recipient_id = "bot",
        isOut = false
    ),
    Message(
        text = "Oi! Bom dia.",
        recipient_id = "user",
        isOut = true
    )
)