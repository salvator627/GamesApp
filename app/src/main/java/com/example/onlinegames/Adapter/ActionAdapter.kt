package com.example.onlinegames.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinegames.Data.Datagames
import com.example.onlinegames.R
import org.w3c.dom.Text

class ActionAdapter(private val list: ArrayList<Datagames>) : RecyclerView.Adapter<ActionAdapter.ViewHolder>() {

    private var ItemClickCallback : onItemClick? = null

    fun setOnItemclickcallback(onItemClick: onItemClick){
        this.ItemClickCallback = onItemClick
    }
    inner class ViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){
        fun bind(datagames: Datagames){
            with(itemView){
                val img = findViewById<ImageView>(R.id.imageView2)
                Glide.with(itemView)
                    .load(datagames.thumbnail)
                    .into(img)
                val text = findViewById<TextView>(R.id.textView)
                text.text = datagames.title
                val publisher = findViewById<TextView>(R.id.publisher)
                publisher.text = datagames.publisher

                val button = findViewById<Button>(R.id.button)
                button.setOnClickListener {
                    ItemClickCallback?.onItemclick(datagames)
                }

                itemView.setOnClickListener { ItemClickCallback?.onItemclick(datagames) }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
    interface onItemClick{
        fun onItemclick(datagames: Datagames)
    }
}