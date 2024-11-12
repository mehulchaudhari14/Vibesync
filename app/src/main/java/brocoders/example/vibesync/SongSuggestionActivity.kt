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
            "Happy" -> listOf("Zingaat – Dhadak", "Kala Chashma – Baar Baar Dekho", "Lungi Dance – Chennai Express","Kar Gayi Chull – Kapoor & Sons","Aankh Marey – Simmba")
            "Sad" -> listOf("Channa Mereya – Ae Dil Hai Mushkil","Agar Tum Saath Ho – Tamasha Tujhe"," Bhula Diya – Anjaana Anjaani","Hamari Adhuri Kahani – Hamari Adhuri Kahani","Bekhayali – Kabir Singh")
            "Angry" -> listOf("Sadda Haq – Rockstar", "Bhaag DK Bose – Delhi Belly", "Zinda – Bhaag Milkha Bhaag", "Angry Mix – Various Artists", "Yalgaar – CarryMinati")
            "Love" -> listOf("Tum Jo Aaye – Once Upon a Time in Mumbaai", "Raabta – Agent Vinod", "Pehli Nazar Mein – Race", "Jeene Laga Hoon – Ramaiya Vastavaiya", "Sun Saathiya – ABCD 2")
            "Relaxed" -> listOf("Ilahi – Yeh Jawaani Hai Deewani", "Phir Le Aya Dil (Rekha Bhardwaj version) – Barfi!", "Kabira – Yeh Jawaani Hai Deewani", "Ae Watan – Raazi", "Shayad – Love Aaj Kal (2020)")
            "Excited" -> listOf("Badtameez Dil – Yeh Jawaani Hai Deewani", "Ghungroo – War", "Kala Chashma – Baar Baar Dekho", "Jai Jai Shivshankar – War", "Malhari – Bajirao Mastani")
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