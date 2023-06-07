package com.example.geochat.screens

import java.util.Calendar
import kotlin.random.Random

data class Message(
    var text: String? = null,
    var recipient_id: String,
    var time: Long = Calendar.getInstance().timeInMillis,
    var isOut: Boolean = false
)

var random = Random.nextInt(2)

val message_dummy = listOf(
    if (random == 0) {
        Message(
            text = "Oie!",
            recipient_id = "bot",
            isOut = false
        )
    } else if (random == 1) {
        Message(
            text = "E aí, beleza!?",
            recipient_id = "bot",
            isOut = false
        )
    } else {
        Message(
            text = "Opa, mais alguém usando o Geochat",
            recipient_id = "bot",
            isOut = false
        )
    }
)