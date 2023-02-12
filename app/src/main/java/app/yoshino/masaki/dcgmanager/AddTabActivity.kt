package app.yoshino.masaki.dcgmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import app.yoshino.masaki.dcgmanager.databinding.ActivityAddMatchesBinding
import app.yoshino.masaki.dcgmanager.databinding.ActivityAddTabBinding

class AddTabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTabBinding
    lateinit var TabAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTabBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val MainIntent = Intent(this,MainActivity::class.java)

        lateinit var TabAdapter: ViewPagerAdapter

        binding.buttonAddTab.setOnClickListener {
            val newSecondFragment: Fragment = SecondFragment()
            TabAdapter.addTab(newSecondFragment,binding.textNew.text.toString())
            startActivity(MainIntent)
        }
    }
}