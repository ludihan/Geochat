package com.example.geochat.screens

import java.util.Calendar

data class Message(
    var text: String?=null,
    var recipient_id: String,
    var time: Long = Calendar.getInstance().timeInMillis,
    var isOut: Boolean = false
)

val message_dummy = listOf(
    Message(
        text = "Que bom!",
        recipient_id = "Fake",
        isOut = false
    ),
    Message(
        text = "Estou bem.",
        recipient_id = "user",
        isOut = true
    ),
    Message(
        text = "Olá, como vai você?",
        recipient_id = "Fake",
        isOut = false
    ),
    Message(
        text = "Oi! Bom dia.",
        recipient_id = "user",
        isOut = true
    )
)