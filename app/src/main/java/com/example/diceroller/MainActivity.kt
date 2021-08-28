package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Roll dice on create
        rollDice()

        // on roll dice btn clicked
        val rollButton: Button = findViewById(R.id.rollBtn)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    // Roll dice and render dice image
    private fun rollDice() {
        val diceNumber = Dice(6).roll()

        var rolledDiceImg = getDiceImageByRolledNumber(diceNumber)
        val diceImage: ImageView = findViewById(R.id.diceImg)
        diceImage.setImageResource(rolledDiceImg)
        diceImage.contentDescription = diceNumber.toString()
    }
}


fun getDiceImageByRolledNumber(rolledNumber: Int): Int {
    val diceImage = when (rolledNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    return diceImage
}

class Dice(private val numOfSides: Int) {
    fun roll(): Int {
        return (1..numOfSides).random()
    }
}