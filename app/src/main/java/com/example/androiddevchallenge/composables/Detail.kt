/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import com.example.androiddevchallenge.ui.theme.backgroundBlue
import com.example.androiddevchallenge.ui.theme.textBlue
import java.util.Locale

@Composable
fun Detail(puppy: Puppy, onClickBack: () -> Unit) {
    val isFavoritePuppy = mutableStateOf(puppy.isFavoritePuppy)

    Scaffold(
        content = {
            Surface(color = MaterialTheme.colors.background) {
                Column {
                    Box {
                        Image(
                            painterResource(puppy.drawable),
                            contentDescription = "dog photo",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth().clip(
                                RoundedCornerShape(
                                    bottomStart = 32.dp,
                                    bottomEnd = 32.dp
                                )
                            )
                        )

                        Icon(
                            Icons.Default.ArrowBack,
                            "back arrow",
                            tint = Color.White,
                            modifier = Modifier.padding(16.dp).clickable { onClickBack() }
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                        Text(
                            puppy.name,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        )
                        Text(
                            " | ${puppy.sex.capitalize(Locale.getDefault())}, ${puppy.age} months",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    Text(puppy.description, modifier = Modifier.padding(horizontal = 20.dp))

                    Spacer(Modifier.height(20.dp))

                    Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                        puppy.tags.forEach {
                            Text(
                                it,
                                modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(8.dp))
                                    .background(backgroundBlue)
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                style = TextStyle(color = textBlue, fontSize = 16.sp)
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isFavoritePuppy.value = !isFavoritePuppy.value },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    if (isFavoritePuppy.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    "Love dog",
                    tint = Color.Red
                )
            }
        }
    )
}
