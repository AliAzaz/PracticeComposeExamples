package com.example.practicecompose_examples.utils

import androidx.compose.animation.animatedFloat
import androidx.compose.animation.animatedValue
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.animation.FlingConfig
import androidx.compose.foundation.animation.fling
import androidx.compose.foundation.gestures.draggable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.LayoutModifier
import androidx.compose.ui.Measurable
import androidx.compose.ui.MeasureScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
fun Modifier.swipeToDelete(
    constraints: Constraints,
    threshold: Float = .8f,
    swipeDirection: LayoutDirection? = null,
    onDelete: () -> Unit
): Modifier {
    val width = constraints.maxWidth

    val draggable = remember { mutableStateOf(true) }
    val deleted = remember { mutableStateOf(false) }

    val positionOffset = animatedFloat(0f)
    val collapse = remember { mutableStateOf(0) }
    val animatedCollapse = animatedValue(initVal = 0, converter = Int.VectorConverter)


    return (this + Modifier.draggable(
        enabled = draggable.value,
        orientation = Orientation.Horizontal,
        onDrag = { delta ->
            when (swipeDirection) {
                LayoutDirection.Ltr -> positionOffset.snapTo(
                    (positionOffset.value + delta).coerceAtLeast(
                        0f
                    )
                )
                LayoutDirection.Rtl -> positionOffset.snapTo(
                    (positionOffset.value + delta).coerceAtMost(
                        0f
                    )
                )
                else -> positionOffset.snapTo(positionOffset.value + delta)
            }
        },
        onDragStopped = { velocity ->
            val config = FlingConfig(anchors = listOf(-width.toFloat(), 0f, width.toFloat()))
            if (positionOffset.value.absoluteValue >= threshold) {
                positionOffset.fling(velocity, config) { _, endValue, _ ->
                    if (endValue != 0f) {
                        animatedCollapse.snapTo(collapse.value)
                        animatedCollapse.animateTo(0, onEnd = { _, _ ->
                            deleted.value = true
                            draggable.value = false
                            onDelete()
                        }, anim = tween(500))
                    }
                }
            } else {
                draggable.value = true
            }
        }
    )).then(object : LayoutModifier {
        override fun MeasureScope.measure(
            measurable: Measurable,
            constraints: Constraints
        ): MeasureScope.MeasureResult {
            val child = measurable.measure(constraints)
            positionOffset.setBounds(-width.toFloat(), width.toFloat())

            collapse.value = child.height

            val placeHeight = if (animatedCollapse.isRunning || deleted.value) {
                animatedCollapse.value
            } else {
                child.height
            }
            return layout(child.width, placeHeight) {
                child.place(positionOffset.value.roundToInt(), 0)
            }
        }
    })
}