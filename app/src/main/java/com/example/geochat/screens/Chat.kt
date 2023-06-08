package com.example.geochat.screens

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.geochat.ChatViewModel
import com.example.geochat.R
import com.example.geochat.ui.theme.GeochatTheme
import kotlin.random.Random

class Chat : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            GeochatTheme() {
                ChatScreen()
            }
        }
    }
}

@Composable
fun ChatScreen(viewModel: ChatViewModel = ChatViewModel()) {
    var context = LocalContext.current
    Toast.makeText(context,"Novo usuário encontrado!", Toast.LENGTH_LONG).show()
    val nome = stringArrayResource(R.array.nome)
    val snome = stringArrayResource(R.array.sobrenome)
    var randomn = Random.nextInt(6)
    var randoms = Random.nextInt(6)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBarSection(
            username = nome[randomn] + " " + snome[randoms],
            profile = painterResource(id = R.drawable.user),
            isOnline = true
        )
        ChatSection(Modifier.weight(1f), viewModel)
        MessageSection(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageSection(
    viewModel: ChatViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        //backgroundColor = Color.White,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        OutlinedTextField(
            placeholder = {
                Text("Mensagem..")
            },
            value = message.value,
            onValueChange = {
                message.value = it
            },
            shape = RoundedCornerShape(25.dp),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = "send-icon",
                    tint = MaterialTheme.colorScheme.primary,

                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            viewModel.sendMessage(
                                Message(
                                    text = message.value,
                                    recipient_id = viewModel.username,
                                    isOut = true
                                )
                            )
                            message.value = ""
                        }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GeochatTheme {
        ChatScreen()
    }
}