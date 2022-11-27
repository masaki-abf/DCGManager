package app.yoshino.masaki.dcgmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.yoshino.masaki.dcgmanager.databinding.ActivityAddMatchesBinding

class AddMatchesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMatchesBinding
    lateinit var db:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMatchesBinding.inflate(layoutInflater).apply{setContentView(this.root)}
        db = AppDatabase.getInstance(this.applicationContext)!!

        val MainIntent = Intent(this,MainActivity::class.java)
        binding.addButton.setOnClickListener {
            val matches :Matches = Matches(
                game = binding.gameText.text.toString(),
                deck = binding.enemyDeckText.text.toString(),
                first = binding.firstSwitch.isChecked,
                win = binding.winSwitch.isChecked
            )
            db.matchesDao().insert(matches)
            startActivity(MainIntent)
        }
    }
}