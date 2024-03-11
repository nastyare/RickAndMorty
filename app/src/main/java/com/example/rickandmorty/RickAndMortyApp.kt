package com.example.rickandmorty

import android.app.Application

class RickAndMortyApp: Application() {

        companion object {
            const val baseUrl = "https://rickandmortyapi.com/api/"
            const val end_point = "character"
        }
    override fun onCreate() {
        super.onCreate()
    }
}