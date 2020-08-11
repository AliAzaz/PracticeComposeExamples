package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ColumnGreeting()
            }
        }
    }
}

@Composable
fun ColumnGreeting() {
    val image = imageResource(id = R.drawable.scene_01)
    val imageModifier = Modifier
        .preferredHeightIn(maxHeight = 160.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(6.dp))
    val items = listOf("Ali", "John", "Wick", "Tom")
    Column(
        modifier = Modifier.padding(16.dp), children =
        {
            Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)
            Text(text = "Hello ${items.random()}!", style = MaterialTheme.typography.h2)
            Text(text = "Hello ${items.random()}!", fontSize = 15.sp)
        })
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ColumnGreeting()
    }
}