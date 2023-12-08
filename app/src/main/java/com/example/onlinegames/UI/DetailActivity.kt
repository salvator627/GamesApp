package com.example.onlinegames.UI

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.onlinegames.Data.Datagames
import com.example.onlinegames.R

class DetailActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getParcelableExtra<Datagames>("data")
        val text = findViewById<TextView>(R.id.textView2)
        val text2 = findViewById<TextView>(R.id.textView3)
        val image = findViewById<ImageView>(R.id.imageView7)
        val publisher = findViewById<TextView>(R.id.textView4)
        val desc = findViewById<TextView>(R.id.textView7)
        val date = findViewById<TextView>(R.id.textView9)

        if (title != null){
            text.text = title.title
            text2.text = title.platform
            publisher.text = title.publisher
            desc.text = title.short_description
            date.text = title.release_date

            Glide.with(this@DetailActivity)
                .load(title.thumbnail)
                .into(image)
        }
    }
}