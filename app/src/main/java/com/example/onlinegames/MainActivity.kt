package com.example.onlinegames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.example.onlinegames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //variabel
    private lateinit var binding: ActivityMainBinding
    //inisiasi viewPager
    companion object {
        @StringRes
        private val TAB_TITTLES = intArrayOf(

        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //inisiasi recycler view

    }
}