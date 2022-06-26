package com.example.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.examplecompose.ui.theme.ExampleComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //var text by rememberSaveable() {mutableStateOf("") }
                    // para devolver getter y setter
                    val (value, onValueChange) = rememberSaveable() {
                        mutableStateOf("")
                    }

                    StateSample(
                        value=value,
                        onValueChange = onValueChange
                    )

                }
            }
        }
    }
}
//state commit 11
@Composable
fun StateSample(value: String, onValueChange:(String)->Unit){
    //otra forma
    // debemos importar  import androix.composable.runtime.*
    //setter and getter verificar si los importa el runtime
    //var text by remember{mutableStateOf("")}
    // reemplazar text.value por text ... OK
    //val text = remember(){ mutableStateOf("")}
    //statehosting extraer estado de las vistas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp)
    ) {
        TextField(value = value,
            onValueChange = {onValueChange(it)},
            modifier = Modifier.fillMaxWidth()
        )
        
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        
        Button(
            onClick = { onValueChange("")},
            modifier = Modifier.fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text("Clear")
        }
    }
}


/// No va
@ExperimentalFoundationApi
//@Preview(showBackground = true)
@Composable
fun MediaList(){
    LazyVerticalGrid(
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        cells = GridCells.Adaptive(150.dp)
    ){
        items(getMedia()){itemx->
            MediaListItem(itemx,Modifier.padding(2.dp))

        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(color = Color.LightGray)
        ) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(item.thumb)
                .crossfade(2000)
                //.transformations(CircleCropTransformation())
                .build(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop

            )

            if (item.type == MediaItem.Type.VIDEO){

                Icon(imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier
                        .size(92.dp)
                        .align(Alignment.Center),
                    tint = Color.White)
                Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null)

            }

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ){
            Text(text = "Title ${item.id}")
        }

    }
}

//@Preview(showBackground = true)
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

//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
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

//@Preview(showBackground = true, widthDp = 400, heightDp = 100)
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


