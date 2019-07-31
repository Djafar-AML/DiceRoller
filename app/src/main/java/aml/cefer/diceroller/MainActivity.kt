package aml.cefer.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_btn)
        diceImage = findViewById(R.id.dice_iv)

        rollButton.text = "Let's Roll"

        rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {

        val random = Random.nextInt(6) + 1

        val drawableResource = when (random) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }


        diceImage.setImageResource(drawableResource)


    }

}
