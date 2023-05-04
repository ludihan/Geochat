package com.example.geochat

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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


val fonteJBMR = FontFamily(Font(R.font.jetbrainsmonoregular, FontWeight.Normal))

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
        modifier = Modifier.size(100.dp, 40.dp)
    ) {
        Text(text = text, color = Color.Black, fontFamily = fonteJBMR)
    }
}

@Composable
fun CredentialsTextField(
    text: String,
    block: () -> Unit,
) {

    var text by remember { mutableStateOf(text) }

    TextField(
        value = "",
        onValueChange = { text = it },
        label = { Text(text) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Gray
        )
    )

}
@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Coluna Geochat e Seta
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Geochat",
                    fontSize = 40.sp,
                    fontFamily = fonteJBMR,
                    fontWeight = FontWeight.Normal
                )
            }

            //Coluna Usuário e Senha
            Column {
                CredentialsTextField(text = "Nome") {
                    /*TODO*/
                }
                CredentialsTextField(text = "Senha") {

                }
            }
            //Login e Esqueci a senha
            LoginButton(text = "Login", buttonColors = GrayButtonColors()) {
                Log.d(TAG, "App: Clicou em Login!")
            }
            Text(
                text = "Esqueci a senha",
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
