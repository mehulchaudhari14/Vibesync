package brocoders.example.vibesync

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout


class SongSuggestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_suggestion)

        // Get the mood from the Intent
        val selectedMood = intent.getStringExtra("SELECTED_MOOD")

        // Set the mood emoji and title based on the selected mood
        val moodEmojiTextView = findViewById<TextView>(R.id.moodEmoji)
        val moodTitleTextView = findViewById<TextView>(R.id.moodTitle)

        val moodEmoji = getEmojiForMood(selectedMood)
        moodEmojiTextView.text = moodEmoji
        moodTitleTextView.text = "$selectedMood Mood"

        // Find the LinearLayout where we will display the song list
        val songListLayout = findViewById<LinearLayout>(R.id.songListLayout)

        // Get the songs based on the selected mood
        val songSuggestions = getSongsForMood(selectedMood)

        // Display each song as a TextView inside the songListLayout
        songSuggestions.forEach { song ->
            val songTextView = TextView(this)
            songTextView.text = song
            songTextView.textSize = 18f
            songTextView.setPadding(0, 8, 0, 8)
            songTextView.setTextColor(resources.getColor(android.R.color.white))
            songListLayout.addView(songTextView)
        }
    }

    // Function to return song suggestions based on the selected mood
    private fun getSongsForMood(mood: String?): List<String> {
        return when (mood) {
            "Happy" -> listOf("Happy - Pharrell Williams", "Walking on Sunshine - Katrina and the Waves", "Can't Stop the Feeling - Justin Timberlake")
            "Sad" -> listOf("Someone Like You - Adele", "Fix You - Coldplay", "Yesterday - The Beatles")
            "Angry" -> listOf("Break Stuff - Limp Bizkit", "Killing in the Name - Rage Against the Machine", "Headstrong - Trapt")
            "Love" -> listOf("All of Me - John Legend", "Perfect - Ed Sheeran", "Thinking Out Loud - Ed Sheeran")
            "Relaxed" -> listOf("Weightless - Marconi Union", "Sunset Lover - Petit Biscuit", "Breezeblocks - Alt-J")
            "Excited" -> listOf("Can't Hold Us - Macklemore & Ryan Lewis", "Uptown Funk - Mark Ronson ft. Bruno Mars", "Shut Up and Dance - Walk the Moon")
            else -> listOf("No songs available for this mood")
        }
    }

    // Function to return the emoji based on the selected mood
    private fun getEmojiForMood(mood: String?): String {
        return when (mood) {
            "Happy" -> "😊"
            "Sad" -> "😢"
            "Angry" -> "😡"
            "Love" -> "😍"
            "Relaxed" -> "😌"
            "Excited" -> "🤩"
            else -> "🎶"
        }
    }
}