package com.example.premiereapplication

import ads_mobile_sdk.h6
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.premiereapplication.ui.theme.PremiereApplicationTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

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
                            title = { Text("Événement", color = Color.Black) },
                            navigationIcon = {
                                IconButton(onClick = { /* Action pour le menu burger */ }) {
                                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
                                }
                            },
                            actions = {
                                IconButton(onClick = { /* Action pour le cœur */ }) {
                                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favori", tint = Color.Black)
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
    Column(modifier = modifier.padding(16.dp)) {
        // Image de l'événement
        Image(
            painter = painterResource(id = R.drawable.capture),
            contentDescription = "Affiche de l'événement",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Où : Ecole ingénieur ISIS",
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Text(
            text = "Quand : 24 octobre",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Boutons d'action
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /* Action d'inscription */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Inscription")
            }
            Button(
                onClick = { /* Action "Pas intéressé" */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text(text = "Pas intéressé")
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
