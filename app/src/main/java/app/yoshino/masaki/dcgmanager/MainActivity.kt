package app.yoshino.masaki.dcgmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import app.yoshino.masaki.dcgmanager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import app.yoshino.masaki.dcgmanager.MyApplication.Companion.gameList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var vpa: ViewPagerAdapter
    private val tabTitleArray = arrayOf(
        "Tab1",
        "Tab2"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val AddIntent = Intent(this,AddMatchesActivity::class.java)
        val toEditIntent = Intent(this,AddMatchesActivity::class.java)
        val Addtabintent = Intent(this,AddTabActivity::class.java)
        val InfoIntent = Intent(this,InfoActivity::class.java)
        //val vpa = ViewPagerAdapter(this, lifecycle)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        val matchesDao = db.matchesDao()
//        val matches: List<Matches> = matchesDao.getAll()
//        val recyclerAdapter =RecyclerAdapter(
//            OnClickListener{memo ->
//                toEditIntent.putExtra("ID".matches())
//                startActivity(toEditIntent)
//            }
//        )

        try{
            this.supportActionBar!!.hide()
        }catch (e: NullPointerException){
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        viewPager.adapter = ViewPagerAdapter(this)
        vpa = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = gameList[position]
        }.attach()

        var tabPosition = tabLayout.selectedTabPosition

        binding.buttonAdd.setOnClickListener{
            tabPosition = tabLayout.selectedTabPosition
            AddIntent.putExtra("pI", tabPosition)
            startActivity(AddIntent)
        }
        binding.buttonTab.setOnClickListener {
            tabPosition = tabLayout.selectedTabPosition
            Addtabintent.putExtra("pI", tabPosition)
            startActivity(Addtabintent)
        }
        binding.buttonInfo.setOnClickListener {
            tabPosition = tabLayout.selectedTabPosition
            InfoIntent.putExtra("pI", tabPosition)
            startActivity(InfoIntent)
        }
    }
}