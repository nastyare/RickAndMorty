package viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.RickAndMortyApiClient
import kotlinx.coroutines.launch


class CharactersViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = RickAndMortyApiClient()
    private val _characters = MutableLiveData<List<data.Character>>()
    val characters: LiveData<List<data.Character>> = _characters

    fun getCharacters() {
        viewModelScope.launch {
            try {
                val response = apiClient.fetchCharacters()
                if (response.isSuccessful) {
                    _characters.value = response.body()?.results
                } else {
                    Log.e("CharactersViewModel", "Ошибка: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("CharactersViewModel", "Исключение: ${e.message}")
            }
        }
    }
}
