package com.example.androiddevchallenge.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Detail(puppyId: String?) {

    puppyId?.let { Text(it) }

}