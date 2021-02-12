package com.daerawind.rickandmorty.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daerawind.rickandmorty.R
import com.daerawind.rickandmorty.model.Character
import kotlinx.android.synthetic.main.item_char.view.*

class CharAdapter : ListAdapter<Character, RecyclerView.ViewHolder>(Character.DiffCallback()) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun init(char: Character) {
            itemView.name.text = char.name
            Glide.with(itemView.context).load(char.image).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_char, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is ViewHolder) {
            holder.init(item)
        }
    }

}