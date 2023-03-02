package app.yoshino.masaki.dcgmanager

import android.app.Application
import androidx.fragment.app.Fragment


class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        // initialization code here
    }
    companion object {
        var gameList: MutableList<String> = arrayListOf("hunter","MRC","noa")
        var fragmentList: MutableList<Fragment> = arrayListOf(SecondFragment.newInstance("hunter"),SecondFragment.newInstance("MRC"), SecondFragment.newInstance("noa"))
        lateinit var instance: MyApplication
            private set
    }
}
