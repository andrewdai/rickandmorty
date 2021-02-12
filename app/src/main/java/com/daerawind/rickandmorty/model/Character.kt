package com.daerawind.rickandmorty.model

import androidx.recyclerview.widget.DiffUtil

data class Character(
    val id: Long = 0L,
    val name: String = "",
    val image: String = ""
) {
    class DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.image == newItem.image
        }
    }
}