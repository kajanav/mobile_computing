package com.example.simple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           UserInputApp()

        }
    }
}

@Composable
fun UserInputApp() {
    var inputText by remember { mutableStateOf("") }
    var displayText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(20.dp)) {

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter Text") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            displayText = inputText
        }) {
            Text("Show Text")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = displayText)
    }
}
