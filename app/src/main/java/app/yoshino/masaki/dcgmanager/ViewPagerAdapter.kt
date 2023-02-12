package app.yoshino.masaki.dcgmanager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
FragmentStateAdapter(fragmentActivity){
    val gameList: MutableList<String> = arrayListOf("hunter","MRC")
    val fragmentList: MutableList<Fragment> = arrayListOf(SecondFragment.newInstance("hunter"),SecondFragment.newInstance("MRC"))
    override fun getItemCount(): Int {
        return fragmentList.size
    }



    override fun createFragment(position: Int): Fragment {
        when(position){
            position -> return fragmentList[position]
        }
        return SecondFragment()
    }
    fun addTab(fragment: Fragment,title:String){
        gameList.add(title)
        fragmentList.add(fragment)
    }
}