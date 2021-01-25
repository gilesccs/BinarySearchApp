package sg.edu.smu.cs461.assignment1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var randomNumber = 0
    private var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spannableString = SpannableString("BinarySearch");
        val testSpan = UnderlineSpan()
        spannableString.setSpan(testSpan, 0, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        val output = findViewById<TextView>(R.id.title);
        output.text = spannableString;

        generateRandomNumber()

    }

    private fun generateRandomNumber(){
        // Getting the random number
        var r = Random()
        // Assigning it to the var
        randomNumber = r.nextInt(99) + 1
    }

    fun checkUserInput(view: View){
        // Gets value of user input
        val userInputView = findViewById<TextView>(R.id.inputText)
        val userInputString = userInputView.text.toString()
        val userInputInt = Integer.parseInt(userInputString)

        // To get the imageview for output
        var imageView = findViewById<ImageView>(R.id.imageView)

        if (userInputInt < randomNumber) {
            // Changing image view data
            imageView.setImageResource(R.drawable.higher)
        } else if (userInputInt > randomNumber) {
            imageView.setImageResource(R.drawable.lower)
        } else {
            imageView.setImageResource(R.drawable.correct)
        }

        // Setting output to new message
//        output.text = outputMessage

        attempts++
        // Setting attempts to new attempts
        val attemptsMessage = findViewById<TextView>(R.id.attempt)
        attemptsMessage.text = "Attempt # " + attempts.toString()

        // Stops if game is still on
        if (userInputInt != randomNumber) {
            return
        }

        // Disable enter button
        val enterButton = findViewById<Button>(R.id.enterBtn)
        markButtonDisable(enterButton, false)
        // Send toast
//        context.toast("Congrats! Press reset to start a new game.")
        Toast.makeText(applicationContext, "Congrats! Press New Game to restart the game.",Toast.LENGTH_LONG).show()
        // Change button text
        val resetButton = findViewById<Button>(R.id.resetBtn)
        resetButton.text = "New Game"
    }

    private fun markButtonDisable(button: Button, enable: Boolean) {
        button?.isEnabled = enable
//        button?.setTextColor(ContextCompat.getColor(textView.context, R.color.white))
//        button?.setBackgroundColor(ContextCompat.getColor(textView.context, R.color.greyish))
    }

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun newGame(view: View) {

        // Disable enter button
        val enterButton = findViewById<Button>(R.id.enterBtn)
        markButtonDisable(enterButton, true)

        attempts = 0
        var imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(R.drawable.welcome)

        val attemptsMessage = findViewById<TextView>(R.id.attempt)
        attemptsMessage.text = "Welcome"

        generateRandomNumber()

        // Change button text
        val resetButton = findViewById<Button>(R.id.resetBtn)
        resetButton.text = "Restart"

        // Change input text
        val inputText = findViewById<TextView>(R.id.inputText)
        inputText.text = ""
    }
}