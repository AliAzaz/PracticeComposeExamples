package com.example.practicecompose_examples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardGreeting()
        }
    }
}

@Composable
fun CardGreeting() {

    LazyColumnItems(items = (0..50).toList()) { item ->
        cardViewImplementer(item)
        Spacer(modifier = Modifier.padding(5.dp))
    }

}

@Composable
fun cardViewImplementer(item: Int) {
    val context = ContextAmbient.current
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawShadow(5.dp)
                .clickable(onClick = {
                    Toast.makeText(context, "Clicked $item", Toast.LENGTH_SHORT).show()
                }), children = {

                Column {
                    Image(
                        imageResource(id = R.drawable.scene_01),
                        modifier = Modifier.preferredHeightIn(160.dp, 260.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        "A day in Shark Fin Cove",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(15.dp, 20.dp, 0.dp, 0.dp)
                    )
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text("Davenport, California", style = MaterialTheme.typography.body1)
                        Text("December 2018", style = MaterialTheme.typography.body2)
                    }
                }

            })
    }
}

@Preview
@Composable
fun DefaultPreview() {
    CardGreeting()
}