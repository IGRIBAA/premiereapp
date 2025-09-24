package com.example.premiereapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.premiereapplication.ui.theme.PremiereApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PremiereApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Inscription", color = Color.Black, fontWeight = FontWeight.Bold) },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
                                }
                            },
                            actions = {
                                IconButton(onClick = { }) {
                                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Authentification", tint = Color.Black)
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.White
                            )
                        )
                    }
                ) { innerPadding ->
                    EventDetails(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventDetails(modifier: Modifier = Modifier) {

    val images = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    var currentImage by remember { mutableStateOf(images.random()) }

    Column(modifier = modifier.padding(16.dp)) {

        Text(
            text = "Générez votre numéro de passage !",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = "Affiche de l'événement",
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {

                    currentImage = images.random()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Roll")
            }
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text(text = "Retour")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailsPreview() {
    PremiereApplicationTheme {
        EventDetails()
    }
}
