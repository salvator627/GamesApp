package com.example.onlinegames.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.onlinegames.Data.Datagames
import com.example.onlinegames.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getParcelableExtra<Datagames>("data")
        val text = findViewById<TextView>(R.id.textView2)

        text.text = title?.title

    }
}