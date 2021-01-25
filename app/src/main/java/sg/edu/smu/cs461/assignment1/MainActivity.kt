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
import android.widget.TextView
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

    }

    private fun generateRandomNumbers(){
        // Getting the random number
        var r = Random()
        // Assigning it to the var
        randomNumber = r.nextInt(100)
    }

    private fun checkUserInput(context: Context){
        // Gets value of user input
//        val userInput = findViewById<TextView>(R.id.userInput)
        val userInput = 50
//        var outputMessage = "Your number is: "
        var outputMessage = ""

        // To get the textview for output
//        val output = findViewById<TextView>(R.id.output)

        if (userInput < randomNumber) {
            // Changing text field data
            outputMessage = "HIGHER"
        } else if (userInput > randomNumber) {
            outputMessage = "LOWER"
        } else {
            outputMessage = "CORRECT"
        }

        // Setting output to new message
//        output.text = outputMessage

        attempts++
        // Setting attempts to new attempts
//        val attemptsMessage = findViewById<TextView>(R.id.attemptsMessage)
//        attemptsMessage.text = "#" + attempts.toString()

        // Stops if game is still on
        if (userInput != randomNumber) {
            return
        }

        // Disable enter button
//        Button b = findViewById<Button>(R.id.button)
//        markButtonDisable(b)
        // Send toast
        context.toast("Congrats! Press reset to start a new game.")

    }

    private fun markButtonDisable(button: Button) {
        button?.isEnabled = false
        button?.setTextColor(ContextCompat.getColor(textView.context, R.color.white))
        button?.setBackgroundColor(ContextCompat.getColor(textView.context, R.color.greyish))
    }

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}