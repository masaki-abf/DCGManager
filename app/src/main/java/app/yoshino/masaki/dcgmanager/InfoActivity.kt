package app.yoshino.masaki.dcgmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.yoshino.masaki.dcgmanager.databinding.ActivityAddMatchesBinding
import app.yoshino.masaki.dcgmanager.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    lateinit var db: AppDatabase
    var pagerAdapter = ViewPagerAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater).apply{setContentView(this.root)}
        db = AppDatabase.getInstance(this.applicationContext)!!
        val MainIntent = Intent(this,MainActivity::class.java)
        val tabPosition = intent.getIntExtra("pI", 0)
        val matchlist = db.matchesDao().getGmae(pagerAdapter.gameList[tabPosition])
        matchlist.sortedBy { it.deck }
        val enemylist = matchlist.map { it.deck }.toList()
        val distinctlist = enemylist.distinct().toList()
        var templist: List<Matches>
        var CList: List<String> = listOf()
        var BList: List<String> = listOf()

        for (x in distinctlist){
            templist = matchlist.filter { it.deck == x }
            CList += templist.size.toString()
        }

        for (x in distinctlist){
            templist = matchlist.filter { it.deck == x && it.win }
            BList += templist.size.toString()
        }

        val recyclerView = binding.recyclerView
        recyclerView.adapter = RecyclerAdapter(distinctlist,CList,BList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.backButton.setOnClickListener {
            startActivity(MainIntent)
        }
    }
}

