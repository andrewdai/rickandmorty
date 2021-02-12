package com.daerawind.rickandmorty.model

data class CharacterSheet(
    val info: Info = Info(),
    val results: List<Character> = mutableListOf()
) {
    data class Info(
        val count: Int = 0,
        val pages: Int = 0,
        val next: String = ""
    )
}