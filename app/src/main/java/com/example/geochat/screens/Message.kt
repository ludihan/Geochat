package com.example.geochat.screens

import java.util.Calendar
import kotlin.random.Random

data class Message(
    var text: String? = null,
    var recipient_id: String,
    var time: Long = Calendar.getInstance().timeInMillis,
    var isOut: Boolean = false
)

val message_dummy = listOf(
    Message(
        text = "Bom dia.",
        recipient_id = "bot",
        isOut = false,
    )
)