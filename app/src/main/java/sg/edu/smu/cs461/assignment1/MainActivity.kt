package sg.edu.smu.cs461.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spannableString = SpannableString("BinarySearch");
        val testSpan = UnderlineSpan()
        spannableString.setSpan(testSpan, 0, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        val output = findViewById<TextView>(R.id.title);
        output.text = spannableString;

    }
}