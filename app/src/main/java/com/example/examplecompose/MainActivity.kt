package com.example.examplecompose

import android.media.browse.MediaBrowser
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
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
                    ButtonText()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaItem(){
    Column() {
        Box(
            //Modifier de posicionamiento
            //Modifier de funcionalidad
            //Modifier de diseno
            //Modifier de listeners
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(color = Color.LightGray)
        ) {
            
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(16.dp)
        ){
            Text(text = "Title 1")
        }

    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun ButtonText(){
    Box(

        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello World",
             modifier = Modifier
                 .clickable { /*TODO*/ }
                 .background(Color.Yellow)
                 .border(2.dp, color = Color.Blue)
                 .padding(horizontal = 16.dp, vertical = 8.dp)
        )

    }
}


//Function that do somethings
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

