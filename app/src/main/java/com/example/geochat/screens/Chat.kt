package com.example.geochat.screens

import android.os.Bundle
import android.view.WindowManager
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.geochat.R
import com.example.geochat.ui.theme.GeochatTheme

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
fun ChatScreen() {
    /*Image(
        modifier = Modifier.size(850.dp),
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.image,),
        contentDescription = null
    )*/
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBarSection(
            username = "Fake",
            profile = painterResource(id = R.drawable.user),
            isOnline = true
        )
        ChatSection(Modifier.weight(1f))
        MessageSection()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageSection() {
    val context = LocalContext.current
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
                        .clickable {}
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