package com.example.rickandmorty

import API.APIService
import data.InfoClass
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RickAndMortyApiClient {
    private val apiService: APIService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(RickAndMortyApp.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(APIService::class.java)
    }

    suspend fun fetchCharacters(): Response<InfoClass> {
        return apiService.getCharacter()
    }
}