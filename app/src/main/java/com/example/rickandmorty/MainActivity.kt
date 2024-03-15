package com.example.rickandmorty

import Adapter.CharacterAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import viewModel.CharactersViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharactersViewModel by viewModels()
    private val characterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupObservers()
        viewModel.getCharacters()
    }

    private fun setupObservers() {
        viewModel.characters.observe(this) { characters ->
            characterAdapter.submitList(characters)
        }
    }
    private fun setupRecyclerView() {
        binding.rView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = characterAdapter
        }
    }
}




