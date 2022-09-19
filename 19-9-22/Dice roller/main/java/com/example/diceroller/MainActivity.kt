package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var diceImageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton:Button = findViewById(R.id.roll_button)
        diceImageView = findViewById(R.id.dice_image)
        rollButton.setOnClickListener(){
            rollDice()
        }
    }

    private fun rollDice() {
        val imageResource = when(Random.nextInt(1,6)){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            6-> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImageView.setImageResource(imageResource)
    }
}