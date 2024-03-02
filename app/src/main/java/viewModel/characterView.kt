package viewModel

import API.RetrofitService
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<data.Character>>()
    val characters: LiveData<List<data.Character>> = _characters

    fun getCharacters() {
        viewModelScope.launch {
            try {
                val apiService = RetrofitService.createService()
                val response = apiService.getCharacter()
                if (response.isSuccessful) {
                    _characters.value = response.body()?.results ?: emptyList<data.Character>()
                } else {
                    Log.e("CharactersViewModel", "Ошибка: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("CharactersViewModel", "Исключение: ${e.message}")
            }
        }
    }
}
