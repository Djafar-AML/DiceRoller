package aml.cefer.diceroller

import aml.cefer.diceroller.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding.rollBtn.text = "Let's Roll"

        binding.rollBtn.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {

        val drawableResource = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }


        binding.diceIv.setImageResource(drawableResource)


    }

}
