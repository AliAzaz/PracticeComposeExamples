package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting("Ali")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val modifier = Modifier.padding(10.dp)
    val color = Color.Blue
    Text(text = "Hi! My name is $name", modifier = modifier, color = color)
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Ali")
    }
}