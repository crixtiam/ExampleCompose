package com.example.examplecompose

import android.graphics.Paint
import android.media.browse.MediaBrowser
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
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
                    //TextDesign()
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
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("https://loremflickr.com/320/240/dog")
                .crossfade(2000)
                //.transformations(CircleCropTransformation())
                .build(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop

            )

            Icon(imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier
                    .size(92.dp)
                    .align(Alignment.Center),
                tint = Color.White)
                Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null)
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

@Preview(showBackground = true, widthDp = 400, heightDp = 100)
@Composable
fun TextDesign(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Example Text",
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Right,
            maxLines = 1,
            softWrap = true,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(10f,10f),
                    blurRadius = 10f,
                    color = Color.Blue.copy(alpha = 0.5f)

                )
            )
        )
    }
}



//Function that do somethings
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}


