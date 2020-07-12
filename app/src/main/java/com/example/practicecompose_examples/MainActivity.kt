package com.example.practicecompose_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOAppGreeting()
        }
    }
}

@Composable
fun TODOAppGreeting() {
    MaterialTheme {
        /*LazyColumnItems(items = (0..20).toList()) { item ->
            cardViewImplementer(item)
            Spacer(modifier = Modifier.padding(2.dp))
        }*/

        com.example.practicecompose_examples.ui.ScaffoldContent()
    }
}


@Preview
@Composable
fun DefaultPreview() {
    TODOAppGreeting()
}