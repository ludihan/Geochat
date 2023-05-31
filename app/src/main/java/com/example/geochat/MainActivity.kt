package com.example.geochat

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geochat.ui.theme.GeochatTheme
import com.example.geochat.ui.theme.Gray
import com.example.geochat.ui.theme.GrayButtonColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeochatTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@Composable
fun LoginButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit,
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(137.dp),
        colors = buttonColors,
        modifier = Modifier.size(180.dp, 60.dp)
    ) {
        Text(
            text = text, fontSize = 20.sp, color = Color.Black, fontFamily = FontFamily(
                Font(R.font.jetbrainsmonoregular, FontWeight.Normal),
            )
        )
    }
}

/*
@Composable
fun CredentialsTextField(
    textLabel: String,
    textValue: String,
) {
    Column() {
        TextField(value = textValue, shape = RectangleShape, onValueChange = {
            textValue = it
        }, label = {
            Text(text = textLabel)
        }, colors = TextFieldDefaults.textFieldColors(
            containerColor = Gray
        )
        )
    }
}


 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App() {
    val context = LocalContext.current

    var nome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Coluna Geochat e Seta
            Column(
                verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Geochat",
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(R.font.jetbrainsmonoregular, FontWeight.Normal)),
                    fontWeight = FontWeight.Normal,
                )
            }

            //Coluna Usuário e Senha
            Column {
                TextField(value = nome, shape = RectangleShape, singleLine = true, onValueChange = { newText ->
                    nome = newText
                }, label = {
                    Text(text = "Nome", color = MaterialTheme.colorScheme.background)
                }, colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Gray
                )
                )
                TextField(value = senha, shape = RectangleShape, singleLine = true, onValueChange = { newText ->
                    senha = newText
                }, label = {
                    Text(text = "Senha", color = MaterialTheme.colorScheme.background)
                }, colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Gray
                )
                )
            }

            //Login e Esqueci a senha
            LoginButton(text = "Login", buttonColors = GrayButtonColors()) {
                if (nome == "admin" && senha == "admin") {
                    context.startActivity(Intent(context, MainScreen::class.java))
                } else {
                    Toast.makeText(context, "Login errado!!", Toast.LENGTH_LONG).show()
                }
            }
            Text(text = "Esqueci a senha",
                color = Color.Blue,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {})
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun AppPreview() {
    GeochatTheme {
        App()
    }
}
