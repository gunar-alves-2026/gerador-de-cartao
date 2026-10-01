package com.example.geradordecartao
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppInicianteScreen()
                }
            }
        }
    }
}

@Composable
fun AppInicianteScreen() {
    var nome by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Criador de Cartão",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Preencha os dados abaixo para gerar seu cartão!",
            style = MaterialTheme.typography.bodyMedium
        )


        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Digite seu nome") },
            modifier = Modifier.fillMaxWidth()
        )


        OutlinedTextField(
            value = cidade,
            onValueChange = { cidade = it },
            label = { Text("Digite sua cidade") },
            modifier = Modifier.fillMaxWidth()
        )


        Button(
            onClick = {
                if (nome.isNotBlank() && cidade.isNotBlank()) {
                    mensagem = "Seja bem-vindo(a), $nome! É um prazer ter alguém de $cidade por aqui!"
                } else {
                    mensagem = "Por favor, preencha todos os campos!"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Gerar Cartão")
        }

        if (mensagem.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Text(text = mensagem)
                }
            }
        }
    }
}

