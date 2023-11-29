package com.example.onlinegames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.example.onlinegames.Adapter.SectionPagerAdapter
import com.example.onlinegames.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    //variabel
    private lateinit var binding: ActivityMainBinding
    //inisiasi viewPager
    companion object {
        @StringRes
        private val TAB_TITTLES = intArrayOf(
            R.string.action,
            R.string.mmorpg,
            R.string.shooter
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        val tabs : TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs,viewPager){tab, position ->
            tab.text = resources.getString(TAB_TITTLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
        //inisiasi recycler view
    }
}