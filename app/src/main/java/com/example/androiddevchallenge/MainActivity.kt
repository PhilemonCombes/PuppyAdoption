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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.composables.Detail
import com.example.androiddevchallenge.composables.DogCard
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple500

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyTheme {
                NavHost(navController, startDestination = "home") {
                    composable("home") { Home(navController) }
                    composable(
                        "puppy/{puppyId}",
                        arguments = listOf(navArgument("puppyId") { type = NavType.StringType })
                    ) { backStackEntry -> Detail(backStackEntry.arguments?.getString("puppyId")) }
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun Home(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        val puppies = Puppy.basePuppies.toList().chunked(2)
        Column {

            Spacer(Modifier.height(8.dp))

            Text(
                stringResource(R.string.ready_adopted),
                style = TextStyle(
                    color = purple500,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                ),
                modifier = Modifier.padding(8.dp)
            )

            Spacer(Modifier.height(12.dp))

            LazyColumn(modifier = Modifier.padding(horizontal = 4.dp)) {
                items(puppies) {
                    Row {
                        it.forEach {
                            DogCard(it, Modifier.weight(1f)) { puppyId ->
                                navController.navigate("puppy/${puppyId}")
                            }
                        }
                    }
                }
            }
        }

    }
}
