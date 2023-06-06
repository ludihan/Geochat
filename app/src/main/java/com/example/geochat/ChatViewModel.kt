package com.example.geochat

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geochat.screens.Message
import com.example.geochat.screens.message_dummy
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val message_list: MutableList<Message> =
        mutableStateListOf(*message_dummy.toTypedArray())
    val messages: MutableList<Message> = message_list
    val username = "Usuário"
    val bot = "bot"

    fun addMessage(message: Message) {
        message_list.add(0, message)
    }


    fun sendMessage(message: Message) {
        addMessage(message)
        viewModelScope.launch {
            val response = generateAutoResponse(message)
            addMessage(response)
        }
    }

    fun generateAutoResponse(userInput: Message): Message {
        val response = when (userInput.text) {
            "Olá" -> "Olá, tudo bem?"
            "Como vai?" -> "Estou bem, obrigado!"
            "Qual é o seu nome?" -> "Não é bom sair divulgando informações pessoais aqui."
            "Cadê você?" -> "Tô na Unifor, assistindo aula do Leo, e você?"
            "Caramba, eu to na sala dele também!" -> "Meu deus, não acredito! Que legal!"
            "Vou indo nessa, tchau" -> "Até mais cara, boa noite."
            "emacs ou vim?" -> "vim"
            "M?" -> "Humano."
            "Gostou do app?" -> "Gostei muito, merece um 10 hein."
            else -> "Desculpe, não entendi."
        }
        return Message(
            text = response,
            recipient_id = this.bot,
            isOut = false
        )
    }
}