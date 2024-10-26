package brocoders.example.vibesync

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)

        val happyMoodButton = findViewById<Button>(R.id.happyMoodButton)
        val sadMoodButton = findViewById<Button>(R.id.sadMoodButton)
        val angryMoodButton = findViewById<Button>(R.id.angryMoodButton)
        val loveMoodButton = findViewById<Button>(R.id.loveMoodButton)
        val relaxedMoodButton = findViewById<Button>(R.id.relaxedMoodButton)
        val excitedMoodButton = findViewById<Button>(R.id.excitedMoodButton)

        happyMoodButton.setOnClickListener {
            navigateToSongSuggestion("Happy")
        }

        sadMoodButton.setOnClickListener {
            navigateToSongSuggestion("Sad")
        }

        angryMoodButton.setOnClickListener {
            navigateToSongSuggestion("Angry")
        }

        loveMoodButton.setOnClickListener {
            navigateToSongSuggestion("Love")
        }

        relaxedMoodButton.setOnClickListener {
            navigateToSongSuggestion("Relaxed")
        }

        excitedMoodButton.setOnClickListener {
            navigateToSongSuggestion("Excited")
        }
    }

    private fun navigateToSongSuggestion(selectedMood: String) {
        val intent = Intent(this, SongSuggestionActivity::class.java)
        intent.putExtra("SELECTED_MOOD", selectedMood)
        startActivity(intent)
    }
}
