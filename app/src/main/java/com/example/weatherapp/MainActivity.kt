package com.example.weatherapp

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, heightDp = 800, widthDp = 380)
@Composable
fun mainPage(): Unit {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Cabecalho()
        Informacao()
        imagemCentral()
    }
}

@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun imagemCentral(): Unit {
    Box (
        modifier = Modifier
            .height(300.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box {
            Box (
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(280.dp)
            ) {

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                contentAlignment = Alignment.TopCenter
            ){
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Sol")

            }

            Row  (
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 180.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center

            ) {
                Text(
                    text = "12ºC",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(45f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.primary

                )

                Text(
                    text = "Parcialmente Nublado",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(10f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.tertiary
                )

            }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 380, heightDp = 50)
@Composable
fun Cabecalho(): Unit {

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .fillMaxWidth()
        ) {

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            modifier = Modifier.size(35.dp)
            ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Lupa")
        }

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            modifier = Modifier
                .clip(CircleShape)
                .size(35.dp)
            ) {

            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Foto")


        }

    }

}

@Preview(showBackground = true, widthDp = 380)
@Composable
fun Informacao(name: String = "Rafael"): Unit {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row (
            modifier = Modifier.fillMaxWidth()

        ){

            Text(text = "Olá",
                modifier = Modifier.padding(end = 2.dp),
                fontSize = TextUnit(25f, TextUnitType.Sp),
                fontWeight = FontWeight.Light
            )

            Text(
                text = "$name",
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(25f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary
            )

        }

        Row (
            modifier = Modifier.fillMaxWidth()

        ){
            Text(
                text = formatData(Calendar.getInstance().time),
                fontWeight = FontWeight.Light,
                fontSize = TextUnit(18f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Castanheira do Ribatejo",
                fontWeight = FontWeight.Light,
                fontSize = TextUnit(18f, TextUnitType.Sp),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

fun formatData(data: Date): String {
    val format = SimpleDateFormat("dd MMMM, EEEE yyyy", Locale("pt", "PT"))
    return format.format(data)
}