package app.yoshino.masaki.dcgmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}