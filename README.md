# Image Column Template

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

In this tutorial, we'll follow how to extract image resource and populate in **Image** and what is **Column**.

## Image Widget

In Jetpack compose there's an available delegate to get specific resource from drawable. In this tutorial we'll follow image resource:

```sh
val image = imageResource(id = R.drawable.scene_01)
val imageModifier = Modifier
        .preferredHeightIn(maxHeight = 160.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(6.dp))
Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)
```

According to name specified RoundedCornerShape means it's rounded the borders. I've also passed **ContentScale.Crop** in Image which means that image filled the layout space and crop boundries that are outside of the layout.
The ContentScale layout provide multiple attributes that's helpful while interacting with images and these are:

```sh
ContentScale.Crop
ContentScale.None
ContentScale.Inside
ContentScale.FillWidth
ContentScale.FillHeight
ContentScale.Fit
```

#### Crop
Scale the source uniformly (maintaining the source's aspect ratio) so that both dimensions (width and height) of the source will be equal to or larger than the corresponding dimension of the destination.

This [ContentScale] implementation in combination with usage of ***[Alignment.Center]*** provides similar behavior to ***[android.widget.ImageView.ScaleType.CENTER_CROP]***

#### None
Do not apply any scaling to the source

#### Inside
Scale the source to maintain the aspect ratio to be inside the destination bounds if the source is larger than the destination. If the source is smaller than or equal to the destination in both dimensions, this behaves similarly to ***[None]***. This will always be contained within the bounds of the destination.

This ***[ContentScale]*** implementation in combination with usage of ***[Alignment.Center]*** provides similar behavior to ***[android.widget.ImageView.ScaleType.CENTER_INSIDE]***

#### FullWidth
Scale the source maintaining the aspect ratio so that the bounds match the destination width. This can cover a larger area than the destination if the width is larger than the height.

#### FullHeight
Scale the source maintaining the aspect ratio so that the bounds match the destination height. This can cover a larger area than the destination if the height is larger than the width.

#### Fit
Scale the source uniformly (maintaining the source's aspect ratio) so that both dimensions (width and height) of the source will be equal to or less than the
corresponding dimension of the destination

This ***[ContentScale]*** implementation in combination with usage of [Alignment.Center] provides similar behavior to ***[android.widget.ImageView.ScaleType.FIT_CENTER]***

## Column
A composable layout that aligned it's children in Vertical sequence. Some applied arguments on Column function:
***modifier*** The modifier to be applied to the Column.
***verticalArrangement*** When the size of the [Column] is larger than the sum of its children sizes, a [verticalArrangement] can be specified to define the positioning of the children inside the [Column].
***horizontalGravity*** The horizontal gravity of the layout's children.


### OUTPUT
<img alt="Pic-1" src="https://github.com/AliAzaz/PracticeComposeExamples/blob/ImageColumnTemplate/pic_card.png" width="400"/>


## CONNECT👍
Medium: https://medium.com/@ali.azaz.alam

Twitter: https://twitter.com/AliAzazAlam1

Github: https://github.com/aliazaz

LinkedIn: https://www.linkedin.com/in/aliazazalam/
