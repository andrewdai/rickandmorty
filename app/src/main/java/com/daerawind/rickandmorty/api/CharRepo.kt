package com.daerawind.rickandmorty.api

class CharRepo(/*val charLocalData: CharLocalData, */private val charRemoteData: CharRemoteData) {

    suspend fun getCharacters() = charRemoteData.getCharacters()
}