package com.example.practicecompose_examples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.gravity
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardListViewGreeting()
        }
    }
}

@Composable
fun CardListViewGreeting() {

    LazyColumnItems(items = (0..5).toList()) { item ->
        cardViewImplementer(item)
        Spacer(modifier = Modifier.padding(2.dp))
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
                .drawShadow(3.dp)
                .padding(0.dp, 13.dp, 0.dp, 0.dp)
                .clickable(onClick = {
                    Toast.makeText(context, "Clicked $item", Toast.LENGTH_SHORT).show()
                }), children = {

                Image(
                    asset = imageResource(R.drawable.scene_01),
                    modifier = Modifier.drawBackground(
                        color = Color.Black,
                        style = Stroke(4f),
                        shape = CircleShape
                    ).preferredSize(120.dp)
                        .gravity(Alignment.CenterHorizontally)
                        .clip(CircleShape),
                    contentScale = ContentScale.FillHeight
                )
                Text(
                    "A day in Shark Fin Cove",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(15.dp, 10.dp, 0.dp, 0.dp)
                )
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text("Davenport, California", style = MaterialTheme.typography.body1)
                    Text("December 2018", style = MaterialTheme.typography.body2)
                }

            })
    }
}

@Preview
@Composable
fun DefaultPreview() {
    CardListViewGreeting()
}