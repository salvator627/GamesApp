package com.example.onlinegames.Adapter

import ActionFragment
import MmorpgFragment
import ShooterFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = ActionFragment()
            1 -> fragment = MmorpgFragment()
            2 -> fragment = ShooterFragment()
        }
        return fragment as Fragment
    }
}