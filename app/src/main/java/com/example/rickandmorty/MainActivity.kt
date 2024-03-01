package com.example.rickandmorty

import API.APIService
import API.RetrofitService
import Adapter.CharacterAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.r_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val apiService = RetrofitService.createService()


        lifecycleScope.launch {
            try {
                val response = apiService.getCharacter()
                if (response.isSuccessful) {
                    val characters: List<data.Character> = response.body()?.results ?: emptyList()
                    recyclerView.adapter = CharacterAdapter(characters)
                } else {
                    Log.e("MainActivity", "Ошибка: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Исключение: ${e.message}")
            }
        }

    }
    /*private fun getChar() {
        apiService.getCharacter().enqueue(object : Callback<InfoClass> {


            override fun onFailure(call: Call<InfoClass>, t: Throwable) {
                System.out.println("failed")
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<InfoClass>, response: Response<InfoClass>) {
                adapter = CharacterAdapter()
                recycler.adapter = adapter
                val wrapper = response.body() as InfoClass
                adapter.submitList((wrapper.list))
            }
        })
    }*/
}