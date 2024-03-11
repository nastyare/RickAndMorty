package API

import com.example.rickandmorty.RickAndMortyApp
import data.InfoClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface APIService {
    @GET(RickAndMortyApp.end_point)
    suspend fun getCharacter(): Response<InfoClass>
}
