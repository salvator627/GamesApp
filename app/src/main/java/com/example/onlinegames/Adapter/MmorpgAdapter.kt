package com.example.onlinegames.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinegames.Data.Datagames
import com.example.onlinegames.R

class MmorpgAdapter(private val list: ArrayList<Datagames>): RecyclerView.Adapter<MmorpgAdapter.ViewHolder>() {

    private var onItemClickCallback : onItemClick? = null
    fun setOnItemClickCallback(onItemClick: onItemClick){
        this.onItemClickCallback = onItemClick
    }
    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(data : Datagames){
            with(itemView){
                val img = findViewById<ImageView>(R.id.imageView2)
                Glide.with(itemView)
                    .load(data.thumbnail)
                    .into(img)
                val text = findViewById<TextView>(R.id.textView)
                text.text = data.title

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(data)
                }
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
        fun onItemClicked(datagames: Datagames)
    }
}