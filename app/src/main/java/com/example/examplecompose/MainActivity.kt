package com.example.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import com.example.examplecompose.ui.theme.ExampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Cristiam")
                }
            }
        }
    }
}
//Function that do somethings
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

//Configure the view
@Preview(showBackground = true,
    name = "Android Theme",
    widthDp = 400,
    heightDp = 200
    )

@Composable
fun DefaultPreview() {
    ExampleComposeTheme {
        //Similar to reciclerView
        Row(
            modifier= Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Greeting("Android", Modifier
                .background(Color.Yellow))

            Greeting("Cristiam", Modifier
                .background(Color.Blue))

            Greeting(name = "Garras", Modifier
                .background(Color.LightGray))
        }
        //Greeting("Android")
    }
}