package com.daerawind.rickandmorty.api

import com.daerawind.rickandmorty.model.CharacterSheet
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }

    @GET("character")
    suspend fun getCharacters(): Response<CharacterSheet>

}