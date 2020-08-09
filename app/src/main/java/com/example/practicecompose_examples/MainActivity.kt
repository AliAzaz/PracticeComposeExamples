package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

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