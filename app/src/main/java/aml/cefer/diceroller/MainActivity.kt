package aml.cefer.diceroller

import aml.cefer.diceroller.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val playerFirstName = PlayerFirstName()

    private var displayName: Boolean = true

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.apply {

            rollBtn.text = "Let's Roll"

            playerName = playerFirstName

            rollBtn.setOnClickListener {
                if (displayName) {
                    showName()
                }
                rollDice()
            }
        }


    }

    private fun showName() {

        binding.apply {

            // we can take one of these approaches!
//            playerName?.name = playerNameEditText.text.toString()
            playerFirstName.name = playerNameEditText.text.toString()

            // in order to refresh the UI with new data -> so that get recreated with new data!!!

            invalidateAll()

            playerNameText.visibility = View.VISIBLE
            playerNameEditText.visibility = View.GONE

        }
        displayName = false
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
