package app.yoshino.masaki.dcgmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import app.yoshino.masaki.dcgmanager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tabTitleArray = arrayOf(
        "Tab1",
        "Tab2"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val AddIntent = Intent(this,AddMatchesActivity::class.java)
        val toEditIntent = Intent(this,AddMatchesActivity::class.java)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        val matchesDao = db.matchesDao()
        val matches: List<Matches> = matchesDao.getAll()
        val recyclerAdapter =RecyclerAdapter(
            OnClickListener{memo ->
                toEditIntent.putExtra("ID".matches())
                startActivity(toEditIntent)
            }
        )

        try{
            this.supportActionBar!!.hide()
        }catch (e: NullPointerException){
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = tabTitleArray[position]
        }.attach()

        binding.buttonAdd.setOnClickListener{
            startActivity(AddIntent)
        }
    }
}