package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollBtn)
        rollButton.setOnClickListener {
            val diceNumber = Dice(6).roll()

            val rolledNumber: TextView = findViewById(R.id.rolledNum)
            rolledNumber.text = diceNumber.toString()
        }
    }
}

class Dice(private val numOfSides: Int) {
    fun roll(): Int {
        return (1..numOfSides).random()
    }
}