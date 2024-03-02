package com.example.rickandmorty

import Adapter.CharacterAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ActivityMainBinding
import viewModel.CharactersViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.rView
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getCharacters()

        viewModel.characters.observe(this) { characters ->
            recyclerView.adapter = CharacterAdapter(characters)
        }
    }
}




