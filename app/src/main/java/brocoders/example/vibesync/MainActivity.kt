package brocoders.example.vibesync

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the login button
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set an OnClickListener for the login button
        loginButton.setOnClickListener {
            // Start the MoodActivity when the login button is clicked
            val intent = Intent(this, MoodActivity::class.java)
            startActivity(intent)
        }
    }
}
