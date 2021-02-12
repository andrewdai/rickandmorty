package com.daerawind.rickandmorty.api

import com.daerawind.rickandmorty.model.CharacterSheet

class CharRemoteData(private val apiService: ApiService) {

    suspend fun getCharacters(): Result<CharacterSheet> {
        val response = apiService.getCharacters()
        return if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Result.Success(body)
            } else {
                Result.Failure(-1, "body is null")
            }
        } else {
            Result.Failure(-2, "call failed")
        }
    }
}