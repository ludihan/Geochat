package com.example.geochat

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geochat.screens.Message
import com.example.geochat.screens.message_dummy
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    var message_list: MutableList<Message> =
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
        val response = when (userInput.text?.lowercase()) {
            "olá" -> "Olá, tudo bem?"
            "como vai?" -> "Estou bem, obrigado!"
            "qual é o seu nome?" -> "Não é bom sair divulgando informações pessoais aqui."
            "cadê você?" -> "Tô na Unifor, assistindo aula do Leo, e você?"
            "caramba, eu to na sala dele também!" -> "Meu deus, não acredito! Que legal!"
            "vou indo nessa, tchau" -> "Até mais cara, boa noite."
            "emacs ou vim?" -> "vim"
            "m?" -> "Humano."
            "gostou do app?" -> "Gostei muito, merece um 10 hein."
            "e aí, beleza?" -> "Oi! Tudo tranquilo por aqui, e contigo?"
            "qual é o seu curso na Unifor?" -> "Desculpe, mas prefiro não divulgar informações pessoais."
            "está estudando para alguma prova?" -> "Sim, tenho um teste importante na próxima semana. E você?"
            "onde fica a biblioteca da Unifor?" -> "A biblioteca fica no prédio central, próximo ao estacionamento. É um ótimo lugar para estudar."
            "qual é o melhor professor de Ciência da Computação na Unifor?" -> "É difícil escolher apenas um, mas o professor Carlos tem uma ótima reputação entre os alunos."
            "vamos marcar um café na cantina?" -> "Claro, adoraria! Podemos combinar um horário depois das aulas. O que acha?"
            "você sabe onde consigo ajuda com programação em C?" -> "Com certeza! A sala do PET Computação é um ótimo lugar para tirar dúvidas e obter suporte em programação."
            "quais são as atividades extracurriculares disponíveis na Unifor?" -> "Temos diversos grupos estudantis, como o Clube de Programação e a Liga de Inteligência Artificial. Além disso, há eventos e palestras relacionadas à área de Ciência da Computação."
            "você conhece algum estágio em desenvolvimento web?" -> "Sim, a empresa XYZ está com vagas abertas para estagiários na área de desenvolvimento web. Posso fornecer mais informações, se quiser."
            "onde posso imprimir um trabalho aqui na Unifor?" -> "Existem impressoras disponíveis na biblioteca e nos laboratórios de informática. Você também pode utilizar o serviço de cópias e impressões do Centro de Cópias, próximo ao bloco B."
            "qual é o melhor horário para estudar na biblioteca?" -> "Geralmente, o período da manhã é mais tranquilo e silencioso. Se preferir um ambiente mais movimentado, as tardes costumam ser mais movimentadas."
            "você já participou de algum hackathon na Unifor?" -> "Sim, participei do Hackathon UniforX no ano passado. Foi uma experiência incrível e recomendo a todos os estudantes de Ciência da Computação."
            "sabe onde consigo um livro sobre algoritmos avançados?" -> "A biblioteca da Unifor possui uma seção dedicada a livros de algoritmos. Sugiro que você verifique o catálogo online para encontrar o título específico que procura."
            "qual é o laboratório de informática mais equipado na Unifor?" -> "O Laboratório de Informática 3, no bloco C, possui os equipamentos mais modernos e uma estrutura excelente para desenvolvimento de projetos e atividades práticas."
            "ei, qual é o seu superpoder?" -> "Ah, eu tenho o incrível poder de responder perguntas aleatórias sobre a Unifor! E você, qual é o seu superpoder?"
            "se a Unifor fosse um animal, qual você acha que seria?" -> "Com certeza um camaleão, pois se adapta a todas as áreas do conhecimento!"
            "já encontrou o amor da sua vida na Unifor?" -> "Ainda não, mas quem sabe em uma aula de programação eu encontre o match perfeito, não é mesmo?"
            "você conhece alguma fórmula mágica para passar em todas as provas?" -> "Infelizmente, não tenho um livro de feitiços, mas posso compartilhar dicas de estudo e motivação!"
            "qual é o melhor lugar para tirar um cochilo na Unifor?" -> "O sofá da sala de convivência do Centro Acadêmico é imbatível para uma soneca rápida entre as aulas."
            "se pudesse escolher um professor como presidente, quem seria?" -> "Definitivamente o professor de Filosofia, com sua sabedoria, teríamos um país mais reflexivo!"
            "qual é o seu prato favorito no restaurante universitário?" -> "Não tenho preferências alimentares, mas a batata frita sempre tem um lugar especial no meu coração... ou no meu código!"
            "qual é a melhor forma de se livrar do estresse pré-prova?" -> "Recomendo um kit de emergência: chocolate, música animada e um abraço de um colega de turma. Funciona como mágica!"
            "já viu algum fantasma rondando os corredores da Unifor?" -> "Ainda não, mas talvez um dia apareça um fantasma estudando para as provas que ficaram para trás!"
            "quem você acha que venceria numa batalha de programação: um unicórnio ou um dragão?" -> "Difícil escolha! Mas acho que o dragão, afinal, dominar as chamas é quase como dominar as linhas de código!"
            "qual é o melhor horário para pegar a cantina vazia?" -> "No momento em que o sinal toca e todos estão correndo para a aula. É a hora da lancheira desbravadora!"
            "você já viu algum alienígena disfarçado de estudante na Unifor?" -> "Não posso confirmar nem negar, mas talvez aquele aluno que sempre está um passo à frente em todas as matérias seja suspeito!"
            "se a Unifor tivesse uma trilha sonora, qual música seria o hino oficial?" -> "Com certeza seria 'Eye of the Tiger', para nos motivar nas batalhas acadêmicas!"
            "você prefere resolver um bug difícil ou assistir uma maratona de séries?" -> "É uma decisão difícil, mas acho que um bug difícil me traz mais emoção do que qualquer cliffhanger de série!"
            "tchau." -> "Foi bom falar com você, tchau!"
            else -> "Desculpe, não entendi."
        }
        return Message(
            text = response,
            recipient_id = this.bot,
            isOut = false
        )
    }
}