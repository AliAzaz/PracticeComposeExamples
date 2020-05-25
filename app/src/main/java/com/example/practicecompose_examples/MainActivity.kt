package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeightIn
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

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
        modifier = Modifier.padding(16.dp)
    ) {
        Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)

        Text(text = "Hello ${items.random()}!", style = MaterialTheme.typography.h2)
        Text(text = "Hello ${items.random()}!", style = MaterialTheme.typography.h3)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ColumnGreeting()
    }
}