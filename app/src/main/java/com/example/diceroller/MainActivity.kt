package com.example.diceroller

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.hardware.SensorManager
import android.widget.Toast
import com.squareup.seismic.ShakeDetector

class MainActivity : AppCompatActivity(), ShakeDetector.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sd = ShakeDetector(this)
        sd.start(sm)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }
    override fun hearShake() {
        rollDice()
    }
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        val resultImage: ImageView = findViewById(R.id.diceView)

        when (diceRoll){
            1 ->{
                resultTextView.setText("The dice rolled $diceRoll")
                resultImage.setImageResource(R.drawable.dice_1)
                Toast.makeText(applicationContext, "The dice rolled $diceRoll", Toast.LENGTH_SHORT).show()
            }
            2 ->{
                resultTextView.setText("The dice rolled $diceRoll")
                resultImage.setImageResource(R.drawable.dice_2)
                Toast.makeText(applicationContext, "The dice rolled $diceRoll", Toast.LENGTH_SHORT).show()
            }
            3 ->{
                resultTextView.setText("The dice rolled $diceRoll")
                resultImage.setImageResource(R.drawable.dice_3)
                Toast.makeText(applicationContext, "The dice rolled $diceRoll", Toast.LENGTH_SHORT).show()
            }
            4 ->{
                resultTextView.setText("The dice rolled $diceRoll")
                resultImage.setImageResource(R.drawable.dice_4)
                Toast.makeText(applicationContext, "The dice rolled $diceRoll", Toast.LENGTH_SHORT).show()
            }
            5 ->{
                resultTextView.setText("The dice rolled $diceRoll")
                resultImage.setImageResource(R.drawable.dice_5)
                Toast.makeText(applicationContext, "The dice rolled $diceRoll", Toast.LENGTH_SHORT).show()
            }
            6 ->{
                resultTextView.setText("The dice rolled $diceRoll")
                resultImage.setImageResource(R.drawable.dice_6)
                Toast.makeText(applicationContext, "The dice rolled $diceRoll", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}