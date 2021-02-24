package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Puppy(
    val id: Int,
    val name: String,
    @DrawableRes val drawable: Int,
    val sex: String = "male",
    val age: Int = 0
) : Serializable {
    companion object {
        val basePuppies = arrayOf(
            Puppy(0, "Cookie", R.drawable.dog1),
            Puppy(1, "Cindy", R.drawable.dog2, "female"),
            Puppy(2, "Gispy", R.drawable.dog3),
            Puppy(3, "Harry", R.drawable.dog4),
            Puppy(4, "Jony", R.drawable.dog5, "female"),
            Puppy(5, "Cookie", R.drawable.dog6),
            Puppy(6, "Stack", R.drawable.dog1, "female"),
            Puppy(7, "Pedro", R.drawable.dog2, "female"),
            Puppy(8, "Luigi", R.drawable.dog3),
            Puppy(9, "Cookie", R.drawable.dog4, "female"),
            Puppy(10, "Cookie", R.drawable.dog5),
            Puppy(11, "Cookie", R.drawable.dog6)
        )
    }
}
