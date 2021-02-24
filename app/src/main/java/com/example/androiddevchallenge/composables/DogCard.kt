package com.example.androiddevchallenge.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.Puppy

@Composable
fun DogCard(puppy: Puppy, modifier: Modifier, onClickPuppy: (puppyId: Int) -> Unit) {
    Box(modifier = modifier.padding(12.dp).clickable(onClick = { onClickPuppy(puppy.id) })) {

        Image(
            painterResource(puppy.drawable),
            contentDescription = "dog photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(8.dp))
        )

        Text(
            puppy.name,
            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp),
            modifier = Modifier.align(Alignment.BottomStart).padding(8.dp)
        )
    }
}