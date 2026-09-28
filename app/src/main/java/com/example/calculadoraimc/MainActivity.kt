package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme
import java.awt.font.NumericShaper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IMCScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IMCScreen(modifier: Modifier = Modifier) {

    var alturaPaciente by remember {
        mutableStateOf("")
    }

    var pesoUsuario by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize(),

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            // -- header --
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(color = colorResource(R.color.cor_app)), // Usando a cor que nós criamos no /values/colors.xml
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.bmi),
                    contentDescription = "Logo App IMC",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(vertical = 16.dp)
                )

                Text(
                    text = "Calculadora IMC",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }

        // -- formulário -
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(Color.Green)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Seus Dados",
                color = colorResource(R.color.cor_app),
                fontWeight = FontWeight.Medium,
                fontSize = 26.sp
            )

            OutlinedTextField(
                value = alturaPaciente,
                onValueChange = { alturaPaciente = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = {
                    Text(text = "Digite sua altura")
                }
            )

            OutlinedTextField(
                value = alturaPaciente,
                onValueChange = { alturaPaciente = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = {
                    Text(text = "Digite seu peso")
                }
            )

            Button(
                onClick = {}
            ) {
                Text(
                    text = "CALCULAR"
                )
            }
        }

        // -- Card de Resultado
        Row(
            modifier = Modifier
                .background(Color.Green)
        ) {
            Text(
                text = "IMC Paciente",
                color = Color.White,
            )

            Text(
                text = "Status Paciente",
                color = Color.White
            )
        }

    }
}